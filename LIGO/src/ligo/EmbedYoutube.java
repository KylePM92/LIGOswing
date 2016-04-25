package ligo;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kyle
 */
public class EmbedYoutube extends JFrame{
    
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public static void main(String[] args){
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Youtube video");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(getBrowser(), BorderLayout.CENTER);
                frame.setSize(screenSize.width, screenSize.height);
                //frame.pack();
                frame.setVisible(true);
            }
        });
        
        NativeInterface.runEventPump();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
            @Override
            public void run(){
                NativeInterface.close();
            }
        }));
    }
    
    public static JPanel getBrowser(){
        JPanel wbPanel = new JPanel(new BorderLayout());
        JWebBrowser wb = new JWebBrowser();
        wbPanel.add(wb, BorderLayout.CENTER);
        wb.setBarsVisible(false);
        wb.navigate("https://www.youtube.com/embed/6XSAVqm0XBI?rel=0&autoplay=1");
        
        return wbPanel;
    }
}
