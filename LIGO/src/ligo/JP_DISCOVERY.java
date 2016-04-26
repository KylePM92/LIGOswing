/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligo;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Kyle
 */
public class JP_DISCOVERY extends javax.swing.JPanel {

   public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int dWidth = screenSize.width;
    public int dHeight = screenSize.height;
    public int halfWidth = ((dWidth/2)-200);
    public int halfHeight= ((dHeight/2)-100);
    public static JFrame frame2;
    /**
     * Creates new form JP_BLACKHOLES
     * @throws java.io.IOException
     */
     public JP_DISCOVERY() throws IOException, NoPlayerException, CannotRealizeException {
       
        this.setLayout(new BorderLayout());
        
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        
        left.setLayout(new BorderLayout());
        right.setLayout(new BorderLayout());      
        
        left.setBorder(new EmptyBorder(50,10,10,10));
        right.setBorder(new EmptyBorder(20,10,10,10));

        left.setBackground(Color.BLACK);
        right.setBackground(Color.BLACK);
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        sp.setResizeWeight(0.5);
        sp.setEnabled(false);
        sp.setDividerSize(0);
        
        //Right jpanel
        
        JTextArea header = new JTextArea("DISCOVERY");
        header.setWrapStyleWord(true);
        header.setLineWrap(true);
        header.setEditable(false);
        header.setFocusable(false);
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Serif", Font.BOLD, 40));
        header.setMargin( new Insets(0,20,0,0));
        
        JTextArea text = new JTextArea("On September 14, 2015 at 5:51 a.m. Eastern "
                + "Daylight Time (09:51 UTC), the twin Laser Interferometer "
                + "Gravitational-wave Observatory (LIGO) detectors, located "
                + "in Livingston, Louisiana, and Hanford, Washington, USA both "
                + "measured ripples in the fabric of spacetime – gravitational "
                + "waves – arriving at the Earth from a cataclysmic event in the "
                + "distant universe. The new Advanced LIGO detectors had just been "
                + "brought into operation for their first observing run when the "
                + "very clear and strong signal was captured.\n" + "\n" + "This "
                + "discovery comes at the culmination of decades of instrument "
                + "research and development, through a world-wide effort of "
                + "thousands of researchers, and made possible by dedicated "
                + "support for LIGO from the National Science Foundation. It "
                + "also proves a prediction made 100 years ago by Einstein that "
                + "gravitational waves exist. More excitingly, it marks the "
                + "beginning of a new era of gravitational wave astronomy – the "
                + "possibilities for discovery are as rich and boundless as they "
                + "have been with light-based astronomy.\n" + "\n" + "This first "
                + "detection is a spectacular discovery: the gravitational waves "
                + "were produced during the final fraction of a second of the "
                + "merger of two black holes to produce a single, more massive "
                + "spinning black hole. This collision of two black holes had "
                + "been predicted but never observed.");
        
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setFocusable(false);
        text.setForeground(Color.white);
        text.setBackground(Color.black);
        text.setMargin(new Insets(20,20,20,20));
        text.setFont(new Font("Serif", Font.PLAIN, 26));
        JScrollPane jScrollPane = new JScrollPane(text,
                                      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBackground(Color.black);
        jScrollPane.setPreferredSize(new Dimension(halfWidth,halfHeight));
        right.add(header, BorderLayout.PAGE_START);
        right.add(jScrollPane, BorderLayout.CENTER);

        //left jpanel
        JLabel imageLabel = new JLabel("",JLabel.CENTER);
        imageLabel.setIcon(new ImageIcon(new ImageIcon("images/merging_blk_holes.jpg").getImage(
            ).getScaledInstance(halfWidth, halfHeight, Image.SCALE_REPLICATE)));
        
        ImageIcon btnImage = new ImageIcon((new ImageIcon("images/discovery_still.jpg").getImage()));
        JButton btn = new JButton("",btnImage);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runVidDiscovery();
            }
        });         
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BorderLayout());
        btnPanel.setPreferredSize(new Dimension(halfWidth, halfHeight));
        btn.setMaximumSize(new Dimension(100, 100));
        btnPanel.add(btn, BorderLayout.CENTER);
        btnPanel.setBorder(new EmptyBorder(20,50,50,50));
        btnPanel.setBackground(Color.black);
       
        left.add(imageLabel, BorderLayout.PAGE_START);
        left.add(btnPanel, BorderLayout.SOUTH);
        
        //add Left and Right Panel
        sp.add(left);
        sp.add(right);
        this.add(sp, BorderLayout.CENTER);       
     }  
     
     public static void runVidDiscovery(){
         NativeInterface.open();
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame2 = new JFrame("Youtube video");
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel wbPanel = new JPanel(new BorderLayout());
                JWebBrowser wb = new JWebBrowser();
                wbPanel.add(wb, BorderLayout.CENTER);
                wb.setBarsVisible(false);
                wb.navigate("https://www.youtube.com/embed/B4XzLDM3Py8?rel=0&autoplay=1");
                frame2.add(wbPanel, BorderLayout.CENTER);
                frame2.setSize(screenSize.width, screenSize.height);
                frame2.setVisible(true);
            }
        });
                
     }
     
     public static void dispose_disc (){
         frame2.dispose();
     }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
