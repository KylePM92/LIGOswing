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
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Kyle
 */
public class JP_EINSTEIN extends javax.swing.JPanel {

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int dWidth = screenSize.width;
    public int dHeight = screenSize.height;
    public int halfWidth = ((dWidth/2)-200);
    public int halfHeight= ((dHeight/2)-100);
    /**
     * Creates new form JP_BLACKHOLES
     * @throws java.io.IOException
     */
     public JP_EINSTEIN() throws IOException, NoPlayerException, CannotRealizeException {
       
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
        
        JTextArea header = new JTextArea("EINSTEIN");
        header.setWrapStyleWord(true);
        header.setLineWrap(true);
        header.setEditable(false);
        header.setFocusable(false);
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Serif", Font.BOLD, 40));
        header.setMargin( new Insets(0,20,0,0));
        
        JTextArea text = new JTextArea("The Laser Interferometer Gravitational-Wave Observatory (LIGO)"
                + " is designed to open the field of gravitational-wave astrophysics through the "
                + "direct detection of gravitational waves predicted by Einstein’s General Theory"
                + " of Relativity. LIGO’s multi-kilometer-scale gravitational wave detectors use "
                + "laser interferometry to measure the minute ripples in space-time caused by "
                + "passing gravitational waves from cataclysmic cosmic sources such as the "
                + "mergers of pairs of neutron stars or black holes, or by supernovae. LIGO"
                + " consists of two widely separated interferometers within the United States—one"
                + " in Hanford, Washington and the other in Livingston, Louisiana—operated in "
                + "unison to detect gravitational waves.\n" + "\n" + "LIGO is a national facility "
                + "for gravitational-wave research, providing opportunities for the broader "
                + "scientific community to participate in detector development, observation, "
                + "and data analysis. The capabilities of the LIGO detectors were greatly "
                + "improved with the completion of the Advanced LIGO project in late 2014. "
                + "The Advanced LIGO detectors will increase the sensitivity and observational "
                + "range of LIGO by a factor of 10 over its predecessor, bringing 1000 times "
                + "more galaxies into LIGO's observational range.\n" + "\n" + "The design and "
                + "construction of LIGO was carried out by LIGO Laboratory’s team of scientists, "
                + "engineers, and staff at the California Institute of Technology (Caltech) and "
                + "the Massachusetts Institute of Technology (MIT), and collaborators from the "
                + "over 80 scientific institutions world-wide that are members of the LIGO "
                + "Scientific Collaboration.\n" + "\n" + "The responsibilities of LIGO "
                + "Laboratory include operating the LIGO detectors, research and developent "
                + "aimed at further improving the capabilities of the LIGO detectors, research "
                + "in the fundamental physics of gravitation, astronomy, and astrophysics, and"
                + " public education and outreach. LIGO is funded by the U.S. National Science "
                + "Foundation and operated by the California Institute of Technology (Caltech)"
                + " and the Massachusetts Institute of Technology (MIT).");
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
        imageLabel.setIcon(new ImageIcon(new ImageIcon("images/einstein.jpg").getImage(
            ).getScaledInstance(halfWidth, halfHeight, Image.SCALE_REPLICATE)));
        
        ImageIcon btnImage = new ImageIcon((new ImageIcon("images/einstein_still.jpg").getImage()));
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
                wb.navigate("https://www.youtube.com/embed/6XSAVqm0XBI?rel=0&autoplay=1");
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
