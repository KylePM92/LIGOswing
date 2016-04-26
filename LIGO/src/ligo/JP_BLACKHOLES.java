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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
import javax.swing.border.EmptyBorder;
import static ligo.LIGO.frame;

/**
 *
 * @author Kyle
 */
public class JP_BLACKHOLES extends javax.swing.JPanel {
    
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int dWidth = screenSize.width;
    public int dHeight = screenSize.height;
    public int halfWidth = ((dWidth/2)-200);
    public int halfHeight= ((dHeight/2)-100);
    /**
     * Creates new form JP_BLACKHOLES
     * @throws java.io.IOException
     */
     public JP_BLACKHOLES() throws IOException, NoPlayerException, CannotRealizeException {
       
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
        
        JTextArea header = new JTextArea("BLACK HOLES");
        header.setWrapStyleWord(true);
        header.setLineWrap(true);
        header.setEditable(false);
        header.setFocusable(false);
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Serif", Font.BOLD, 40));
        header.setMargin( new Insets(0,20,0,0));
        
        JTextArea text = new JTextArea("Gravitational waves are 'ripples' in the"
                + " fabric of space-time caused by some of the most violent and "
                + "energetic processes in the Universe. Albert Einstein predicted "
                + "the existence of gravitational waves in 1916 in his general "
                + "theory of relativity. Einstein's mathematics showed that "
                + "massive accelerating objects (such as neutron stars or black "
                + "holes orbiting each other) would disrupt space-time in such a "
                + "way that 'waves' of distorted space would radiate from the "
                + "source (like the movement of waves away from a stone thrown "
                + "into a pond). Furthermore, these ripples would travel at the "
                + "speed of light through the Universe, carrying with them "
                + "information about their cataclysmic origins, as well as "
                + "invaluable clues to the nature of gravity itself.\n" + "\n" 
                +"The strongest gravitational waves are produced by catastrophic "
                + "events such as colliding black holes, the collapse of stellar "
                + "cores (supernovae), coalescing neutron stars or white dwarf "
                + "stars, the slightly wobbly rotation of neutron stars that are"
                + " not perfect spheres, and the remnants of gravitational "
                + "radiation created by the birth of the Universe itself.\n" + 
                "\n" + "The animation below illustrates how gravitational waves "
                + "are emitted by two neutron stars as they first orbit each "
                + "other and then coalesce. (Credit: NASA/Goddard Space Flight "
                + "Center)\n" +"\n" + "Though gravitational waves were predicted "
                + "to exist in 1916, actual proof of their existence wouldn't "
                + "arrive until 1974, 20 years after Einstein's death. In that "
                + "year, two astronomers working at the Arecibo Radio Observatory "
                + "in Puerto Rico discovered a binary pulsar--two extremely "
                + "dense and heavy stars in orbit around each other. This was "
                + "exactly the type of system that, according to general "
                + "relativity, should radiate gravitational waves. Knowing that "
                + "this discovery could be used to test Einstein's audacious"
                + " prediction, astronomers began measuring how the period of "
                + "the stars' orbits changed over time. After eight years of "
                + "observations, it was determined that the stars were getting "
                + "closer to each other at precisely the rate predicted by "
                + "general relativity. This system has now been monitored for "
                + "over 40 years and the observed changes in the orbit agree "
                + "so well with general relativity, there is no doubt that it "
                + "is emitting gravitational waves.");
        
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
        imageLabel.setIcon(new ImageIcon(new ImageIcon("images/blk_hole.jpg").getImage(
            ).getScaledInstance(halfWidth, halfHeight, Image.SCALE_REPLICATE)));
        
        ImageIcon btnImage = new ImageIcon((new ImageIcon("images/blk_hole_still.jpg").getImage()));
        JButton btn = new JButton("",btnImage);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NativeInterface.open();
                
                JFrame frame2 = new JFrame("Youtube video");
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel wbPanel = new JPanel(new BorderLayout());
                JWebBrowser wb = new JWebBrowser();
                wbPanel.add(wb, BorderLayout.CENTER);
                wb.setBarsVisible(false);
                wb.navigate("https://www.youtube.com/embed/e-P5IFTqB98?rel=0&autoplay=1");
                frame2.add(wbPanel, BorderLayout.CENTER);
                frame2.setSize(screenSize.width, screenSize.height);
                frame2.setVisible(true);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ligo/Black_Hole.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
