package ligo;

import com.leapmotion.leap.Controller;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import ligo.JP_LIGO;
import ligo.JP_BLACKHOLES;
import ligo.JP_EINSTEIN;
import ligo.JP_DISCOVERY;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.ScreenTapGesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.SwipeGesture.*;
import java.util.Arrays;
import javax.swing.JTextArea;
import static ligo.Main_Menu.checkPanel;
import static ligo.Main_Menu.controller;
import static ligo.Main_Menu.current_panel;
import static ligo.Main_Menu.nextSlide;
import static ligo.Main_Menu.panels;
import static ligo.Main_Menu.pnl;
import static ligo.Main_Menu.prevSlide;
import com.illposed.osc.*;


/**
 *
 * @author Kyle
 */
public class Main_Menu extends javax.swing.JFrame {

    public static JPanel pnl = new JPanel();
    public static JPanel intro_panel = new JPanel();
    public static int current_panel = 0;
    public static JButton btn_prev = new JButton("Prev");
    public static JButton btn_next = new JButton("Next");
    public static JPanel[] panels = new JPanel[5];
    public static SampleListener listener = new SampleListener();
    public static Controller controller = new Controller();
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Main_Menu() throws IOException {
        
        this.setTitle("LIGO");
        
        this.setBounds(0,0,screenSize.width, screenSize.height);  
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        controller.addListener(listener);
	this.setVisible(true);
        this.setLayout(new BorderLayout());
        
        JLabel background = new JLabel(new ImageIcon ("images/space.jpg"));
        this.setContentPane(background);
        background.setLayout(new FlowLayout());
        
        //Rectangle r = this.getBounds();
        
        pnl.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        //pnl.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-250));
        //pnl.setBackground(Color.black);
        //pnl.setBorder(BorderFactory.createLineBorder(Color.gray));
        pnl.setOpaque(false);
        
        btn_prev.setActionCommand("enable");
        btn_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevSlide();
            }
        });
       
        //btn_next.setActionCommand("enable");
        btn_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextSlide();
            }
        });
        
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
        
        intro_panel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-250));
        intro_panel.setBackground(Color.black);
        intro_panel.add(intro_text, BorderLayout.EAST);
        pnl.add(btn_prev,BorderLayout.WEST);
        pnl.add(intro_panel,BorderLayout.CENTER);
        pnl.add(btn_next,BorderLayout.EAST);
        background.add(pnl);
        
        this.add(pnl, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);      
   
        //JP_LIGO jp_ligo = new JP_LIGO();
        panels[0] = intro_panel;
        panels[1] = new JP_LIGO();
        panels[2] = new JP_BLACKHOLES();
        panels[3] = new JP_EINSTEIN();
        panels[4] = new JP_DISCOVERY();
        
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1374, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void nextSlide(){
        int temp = (checkPanel("next", current_panel));
        current_panel = temp;
        JPanel tempPanel = panels[temp];
        pnl.setVisible(false);
        pnl.remove(1);
        //tempPanel.setPreferredSize(new Dimension(r.width-200, r.height-250));
        tempPanel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-250));
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
        tempPanel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-250));
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

//class SampleListener extends Listener {
//
//    @Override
//    public void onConnect(Controller controller) {
//        
//        System.out.println("Connected");
//        
//        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
//        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
//        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
//        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
//    }
//
//    @Override
//    public void onFrame(Controller controller) {
//        Frame frame = controller.frame();
//
//        
////      System.out.println("Frame id: " + frame.id()
////                   + ", timestamp: " + frame.timestamp()
////                   + ", hands: " + frame.hands().count()
////                   + ", fingers: " + frame.fingers().count()
////                   + ", gestures " + frame.gestures().count());
//        
//        if(frame.gestures().count() > 0) {
//            System.out.println("Wow, a gesture!");
//                        Gesture gesture = frame.gestures().get(0);
//            switch(gesture.type()) {
//            	case TYPE_SCREEN_TAP:
//            		//System.out.println("You've made a screen tap gesture!");
//            		break;
//            	case TYPE_KEY_TAP:
//            		//System.out.println("You've made a key tap gesture!");
//            		break;
//            	case TYPE_CIRCLE:
//            		//System.out.println("You've made a circle gesture!");
//            		break;
//            	case TYPE_SWIPE:
//                    
//                                SwipeGesture swipeGesture = new SwipeGesture(gesture);
//                                Vector swipeVector = swipeGesture.direction();
//                                float swipeDirection = swipeVector.getX();
//                                
//                                if(swipeDirection < 0){
//                                    prevSlide();
//                                    try {
//                                        Thread.sleep(1000); //1000 milliseconds is one second.
//                                    } catch(InterruptedException ex) {
//                                        Thread.currentThread().interrupt();
//                                    }
//                                }
//                                else if(swipeDirection > 0){
//                                    nextSlide();
//                                    try {
//                                        Thread.sleep(1000); //1000 milliseconds is one second.
//                                    } catch(InterruptedException ex) {
//                                        Thread.currentThread().interrupt();
//                                    }
//                                }
//                                
//                                
//        			System.out.println("You've made a swipe gesture!");
//        			break;
//            	default:
//        			System.out.println("Broken gesture");
//        			break;
//            }
//            System.out.println(gesture.type());
//        	ScreenTapGesture screentap = new ScreenTapGesture(frame.gestures().get(0));
//        	System.out.println(screentap.position());
//        }
//    }
//}