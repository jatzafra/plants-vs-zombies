/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import pvz.controllers.PauseController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class PausePanel extends JPanel {
    // - - - - - - - Declare Components - - - - - - -     
    PauseController controller;
    JLabel pauseIcon, pauseText;
    JButton play, restart, exit, source;    
    Frame frame;
    
    ImageIcon wireframeIcon = new ImageIcon(GamePanel.class.getResource("../imgs/wireframe.jpg"));
    
    public PausePanel(Frame f) {
        this.frame = f;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.setAlignmentX(Component.CENTER_ALIGNMENT);
//        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        // - - - - - - - BoxLayout Subpanel Center - - - - - - -
        
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setMaximumSize(new Dimension(800, 800));
        boxPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10, true));
//        boxPanel.setBackground(Color.red);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
//        buttonPanel.setBackground(Color.red);
        
        pauseIcon = new JLabel(getScaledIcon(wireframeIcon, 100, 120));
        pauseText = new JLabel("I don't know what to put here yet.");
        play = new JButton("Play");
        restart = new JButton("Restart");
        exit = new JButton("Exit");
        
        play.setFocusable(false);
        restart.setFocusable(false);
        exit.setFocusable(false);
        
        play.setPreferredSize(new Dimension(200, 50));
        restart.setPreferredSize(new Dimension(200, 50));
        exit.setPreferredSize(new Dimension(200, 50));
        
        pauseText.setFont(new Font("Dialog", Font.PLAIN, 30));
        play.setFont(new Font("Dialog", Font.PLAIN, 30));
        restart.setFont(new Font("Dialog", Font.PLAIN, 30));
        exit.setFont(new Font("Dialog", Font.PLAIN, 30));
        
        
        pauseIcon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        pauseText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        // - - - - - - - Add Controllers to Components - - - - - - - 
        
        controller = new PauseController(this, play, restart, exit, frame);
        
        play.addActionListener(controller);
        restart.addActionListener(controller);
        exit.addActionListener(controller);
        
        // - - - - - - - Add Components in Sub-subpanels - - - - - - -
        
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(play);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(restart);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(exit);
        buttonPanel.add(Box.createHorizontalGlue());
        
        // - - - - - - - Add Components in Subpanels - - - - - - -
        
        boxPanel.add(Box.createVerticalStrut(80));
        boxPanel.add(pauseIcon);
        boxPanel.add(Box.createVerticalStrut(20));
        boxPanel.add(pauseText);
        boxPanel.add(Box.createVerticalStrut(120));
        boxPanel.add(buttonPanel);
        boxPanel.add(Box.createVerticalStrut(20));
        
        // - - - - - - - Add Subpanels in Panel - - - - - - -
        
        this.add(Box.createVerticalGlue());
        this.add(boxPanel, BorderLayout.CENTER);
        this.add(Box.createVerticalGlue());
    }
    
    private ImageIcon getScaledIcon(ImageIcon srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg. getImage(), 0, 0, w, h, null);
        g2.dispose();
        
        return new ImageIcon(resizedImg);
    }
    
}
