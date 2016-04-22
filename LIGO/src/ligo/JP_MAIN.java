/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Kyle
 */
public class JP_MAIN extends javax.swing.JPanel {
    
   public Image image;
   public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form JP_BLACKHOLES
     */
    public JP_MAIN() {
       
        try
        {
            image = ImageIO.read(new File("images/LIGO_Main.png"));
        }
        catch (Exception e) { /*handled in paintComponent()*/ }
    }
 
    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image.getScaledInstance(this.getSize().width, this.getSize().height, Image.SCALE_SMOOTH), 0,0,this);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

