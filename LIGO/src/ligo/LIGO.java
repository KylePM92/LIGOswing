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
    
    public static void main(String[] args) throws MalformedURLException{
      
        final URL url = new URL("https://media.giphy.com/media/KpBP8R8rBhwQ/giphy.gif");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("Image");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationByPlatform(true);

                Image image = f.getToolkit().createImage(url);
                LIGO imagePanel = new LIGO(image);
                JButton button = new JButton("Learn More");
                imagePanel.add(button);

                f.setContentPane(imagePanel);
                f.pack();
                f.setExtendedState(JFrame.MAXIMIZED_BOTH);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                f.setBounds(0,0,screenSize.width, screenSize.height);               
                f.setVisible(true);
                
                button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        //dispose();
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                f.dispose();
                                try {
                                    new Main_Menu().setVisible(true);
                                } catch (IOException ex) {
                                    Logger.getLogger(LIGO.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                    }
                });
            }
        });
    }


}
