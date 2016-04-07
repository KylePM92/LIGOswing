package ligo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.illposed.osc.*;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.ScreenTapGesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;
import java.net.SocketException;
import javax.swing.BorderFactory;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import static ligo.LIGO.prevSlide;
import static ligo.LIGO.nextSlide;

/**
 * @author Danny Truong, Kyle Martinez, Michael Chan
 */
public class LIGO extends JPanel{
    
    private final Image image;

    public LIGO(Image image) {
        super();
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);
    }
    
    public static JFrame frame = new JFrame("LIGO");
    public static JPanel pnl = new JPanel();
    public static JPanel intro_panel = new JPanel();
    public static int current_panel = 0;
    public static JButton btn_prev = new JButton("Prev");
    public static JButton btn_next = new JButton("Next");
    public static JPanel[] panels = new JPanel[5];
    public static SampleListener listener = new SampleListener();
    public static Controller controller = new Controller();
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static LIGO imagePanel;
    public static int binaryCheck = 0;
    public static int mainBuildCheck = 0;
    
    public static void main(String[] args) throws MalformedURLException, SocketException{
      
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                Image image = frame.getToolkit().createImage("images/blackhole.gif");
                imagePanel = new LIGO(image);
                JButton button = new JButton("Learn More");

                frame.setContentPane(imagePanel);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setBounds(0,0,screenSize.width, screenSize.height);               
                frame.setVisible(true);
                
                imagePanel.setLayout(new GridBagLayout());
                GridBagConstraints bc = new GridBagConstraints();
                bc.anchor = GridBagConstraints.CENTER;
                imagePanel.add(button);
                
                button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        //dispose();
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                learnMore();
                                binaryCheck++;
                            }
                        });
                    }
                });
            }
        });
        
        //frame.setBounds(0,0,screenSize.width, screenSize.height);  
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setLocationRelativeTo(null);
	//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //controller.addListener(listener);
	//main_frame.setVisible(true);
        
        btn_prev.setActionCommand("enable");
        btn_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevSlide();
            }
        });
       
        btn_next.setActionCommand("enable");
        btn_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextSlide();
            }
        });      
   
        //JP_LIGO jp_ligo = new JP_LIGO();
        panels[0] = intro_panel;
        panels[1] = new JP_LIGO();
        panels[2] = new JP_BLACKHOLES();
        panels[3] = new JP_EINSTEIN();
        panels[4] = new JP_DISCOVERY();
        
        //TouchOSC    
        int receiverPort = 8000;
        OSCPortIn receiver = new OSCPortIn(receiverPort);
   
        receiver.startListening();
        System.out.println("Server is listening on port " + receiverPort + "...");
    
    
        OSCListener handler1 = new OSCListener() {
            @Override
            public void acceptMessage(java.util.Date time, OSCMessage message) {
                System.out.println("Handler1 called with address " + message.getAddress());
                nextSlide();
           } 
        };
        OSCListener handler2 = new OSCListener() {
            @Override
            public void acceptMessage(java.util.Date time, OSCMessage message) {
                System.out.println("Handler1 called with address " + message.getAddress());
                prevSlide();
           } 
        };
        OSCListener handler3 = new OSCListener() {
            @Override
            public void acceptMessage(java.util.Date time, OSCMessage message) {
                System.out.println("Handler1 called with address " + message.getAddress());
                if (binaryCheck == 0){
                    learnMore();
                    binaryCheck++;                    
                }else{
                    //backToSplash();
                    //binaryCheck--;
                }                
           } 
        };
        
        receiver.addListener("/1/toggle4", handler1); //next
        receiver.addListener("/1/toggle3", handler2); //prev
        receiver.addListener("/1/toggle2", handler3); //learn more
        
        receiver.startListening();
        System.out.println("Server is listening on port " + receiverPort + "...");
    }
    
    public static void learnMore (){
        frame.remove(imagePanel);
        if(mainBuildCheck == 0){
            createMainFrame();
            mainBuildCheck++;
        }else{
            backToMain();            
        }
        
    }
    public static void backToSplash (){
        frame.remove(pnl);
        frame.setContentPane(imagePanel);
    }
    
    public static void backToMain (){
        frame.add(pnl, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    public static void createMainFrame(){   
        frame.setLayout(new BorderLayout());
        
        JLabel background = new JLabel(new ImageIcon ("images/space.jpg"));
        frame.setContentPane(background);
        background.setLayout(new FlowLayout());
        
        //Rectangle r = this.getBounds();
        
        pnl.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        //pnl.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-250));
        //pnl.setBackground(Color.black);
        //pnl.setBorder(BorderFactory.createLineBorder(Color.gray));
        pnl.setOpaque(false);
        
        JTextArea intro_text = new JTextArea(
                "Gravitational waves are 'ripples' in the fabric of space-time caused"
                        + " by some of the most violent and energetic processes in the "
                        + "Universe. Albert Einstein predicted the existence of gravitational "
                        + "waves in 1916 in his general theory of relativity. Einstein's "
                        + "mathematics showed that massive accelerating objects (such as "
                        + "neutron stars or black holes orbiting each other) would disrupt "
                        + "space-time in such a way that 'waves' of distorted space would "
                        + "radiate from the source (like the movement of waves away from a "
                        + "stone thrown into a pond). Furthermore, these ripples would travel "
                        + "at the speed of light through the Universe, carrying with them "
                        + "information about their cataclysmic origins, as well as invaluable "
                        + "clues to the nature of gravity itself.");
        
        intro_text.setPreferredSize(new Dimension((screenSize.width-200 )/2, (screenSize.height-250)/2));
        intro_text.setLineWrap(true);
        intro_text.setWrapStyleWord(true);
        intro_text.setForeground(Color.white);
        intro_text.setBackground(Color.black);
        //intro_text.setBorder(null);
        intro_text.setBorder(BorderFactory.createLineBorder(Color.white));
        intro_text.setLayout(new GridBagLayout());
        intro_text.setPreferredSize(new Dimension((screenSize.width/2)-200, screenSize.height-350));
        GridBagConstraints bc = new GridBagConstraints();
        bc.anchor = GridBagConstraints.EAST;
        
        intro_panel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-100));
        intro_panel.setBackground(Color.black);
        intro_panel.add(intro_text, BorderLayout.EAST);
        pnl.add(btn_prev,BorderLayout.WEST);
        pnl.add(intro_panel,BorderLayout.CENTER);
        pnl.add(btn_next,BorderLayout.EAST);
        background.add(pnl);
        frame.add(pnl, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void nextSlide(){
        int temp = (checkPanel("next", current_panel));
        current_panel = temp;
        JPanel tempPanel = panels[temp];
        pnl.setVisible(false);
        pnl.remove(1);
        //tempPanel.setPreferredSize(new Dimension(r.width-200, r.height-250));
        tempPanel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-100));
        pnl.add(tempPanel, 1);
        pnl.setVisible(true);
    }
    
    public static void prevSlide(){
        int temp = (checkPanel("prev", current_panel));
        current_panel = temp;
        JPanel tempPanel = panels[temp];
        pnl.setVisible(false);
        pnl.remove(1);      
        //tempPanel.setPreferredSize(new Dimension(r.width-200, r.height-250));
        tempPanel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-100));
        pnl.add(tempPanel, 1);
        pnl.setVisible(true); 
    }
    
    public static int checkPanel(String btn, int currentPanel){
        
        int newPanel = 0;
        
        if("prev".equals(btn)){
           if(currentPanel == 0){
               newPanel = 4;
           }else{
               newPanel = currentPanel - 1;
           }
        }
        else{
            if(currentPanel == 4){
               newPanel = 0;
           }else{
               newPanel = currentPanel + 1;
           }
        }
        return newPanel;
    }
    // Variables declaration - do not modify                     
    // End of variables declaration                   
}

 class SampleListener extends Listener {

    @Override
    public void onConnect(Controller controller) {
        
        System.out.println("Connected");
        
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
    }

    @Override
    public void onFrame(Controller controller) {
        com.leapmotion.leap.Frame frame = controller.frame();

        
//      System.out.println("Frame id: " + frame.id()
//                   + ", timestamp: " + frame.timestamp()
//                   + ", hands: " + frame.hands().count()
//                   + ", fingers: " + frame.fingers().count()
//                   + ", gestures " + frame.gestures().count());
        
        if(frame.gestures().count() > 0) {
            System.out.println("Wow, a gesture!");
                        Gesture gesture = frame.gestures().get(0);
            switch(gesture.type()) {
            	case TYPE_SCREEN_TAP:
            		//System.out.println("You've made a screen tap gesture!");
            		break;
            	case TYPE_KEY_TAP:
            		//System.out.println("You've made a key tap gesture!");
            		break;
            	case TYPE_CIRCLE:
            		//System.out.println("You've made a circle gesture!");
            		break;
            	case TYPE_SWIPE:
                    
                                SwipeGesture swipeGesture = new SwipeGesture(gesture);
                                Vector swipeVector = swipeGesture.direction();
                                float swipeDirection = swipeVector.getX();
                                
                                if(swipeDirection < 0){
                                    prevSlide();
                                    try {
                                        Thread.sleep(1000); //1000 milliseconds is one second.
                                    } catch(InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                else if(swipeDirection > 0){
                                    nextSlide();
                                    try {
                                        Thread.sleep(1000); //1000 milliseconds is one second.
                                    } catch(InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                
                                
        			System.out.println("You've made a swipe gesture!");
        			break;
            	default:
        			System.out.println("Broken gesture");
        			break;
            }
            System.out.println(gesture.type());
        	ScreenTapGesture screentap = new ScreenTapGesture(frame.gestures().get(0));
        	System.out.println(screentap.position());
        }
    }
}
