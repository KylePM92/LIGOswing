/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligo;

import java.awt.Color;
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
public class JP_EINSTEIN extends javax.swing.JPanel {

     public Image image;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form JP_BLACKHOLES
     */
    public JP_EINSTEIN() {
       
        try
        {
            image = ImageIO.read(new File("images/Einstein.png"));
        }
        catch (Exception e) { /*handled in paintComponent()*/ }
    }
 
    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image.getScaledInstance(this.getSize().width, this.getSize().height, Image.SCALE_SMOOTH), 0,0,this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
