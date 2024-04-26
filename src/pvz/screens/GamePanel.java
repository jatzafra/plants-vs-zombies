/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import pvz.controllers.GameController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pvz.classes.Plant;

/**
 *
 * @author Lenovo
 */
public class GamePanel extends JPanel {
    // - - - - - - - Declare Components - - - - - - - 
    private Frame frame;
    private GameController controller;
    private JButton sunBox, shovelBox, pauseBox;
    
    private ImageIcon wireframeIcon = new ImageIcon(getClass().getResource("../imgs/wireframe.jpg"));
    
    private ArrayList<JButton> plantButtonList = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> gridList;
    
    public GamePanel(Frame f){
        this.frame = f;
        
        this.gridList = new ArrayList<ArrayList<JLabel>>();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        // - - - - - - - BoxLayout Subpanel North - - - - - - -
        
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.X_AXIS));
        
        sunBox = new JButton();
        sunBox.setText("#Sun");
        sunBox.setIcon(getScaledIcon(wireframeIcon, 60, 60));
        sunBox.setFont(new Font("Serif", Font.PLAIN, 15));
        sunBox.setHorizontalTextPosition(JButton.CENTER);
        sunBox.setVerticalTextPosition(JButton.BOTTOM);
        sunBox.setFocusable(false);
        
        for(Object o : Plant.getUsedPlants()){
            Plant p = (Plant) o;
            
            BufferedImage grabbedImg = p.getSpriteSheet().grabImage(1, 1, p.getSpriteWidth(), p.getSpriteHeight());
            BufferedImage resizedImg = p.getSpriteSheet().resizeImage(75, 100,grabbedImg);
            
            JButton plantBox = new JButton();
            plantBox.setIcon(new ImageIcon(resizedImg));
//            plantBox.setIcon(getScaledIcon(new ImageIcon(getClass().getResource("../imgs/" + p.getImgFilename())), 80, 100));
            plantBox.setFocusable(false);
            
            plantButtonList.add(plantBox);
        }
        
        shovelBox = new JButton(getScaledIcon(wireframeIcon, 70, 70));
        pauseBox = new JButton(getScaledIcon(wireframeIcon, 70, 70));
        
        
        // - - - - - - - GridLayout SubPanel Center - - - - - - -
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5, 9));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(40, 230, 40, 230));
        
        for(int y = 0; y < 5; y++){
            ArrayList<JLabel> innerArr = new ArrayList<>();
            
            for(int x = 0; x < 9; x++){
                JLabel label = new JLabel();
                
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.black));
                
                innerArr.add(label);
            }
            
            gridList.add(innerArr);
        }
        
        // - - - - - - - Add Components in Subpanels - - - - - - -
        
        boxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        boxPanel.add(sunBox);
        boxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        
        for(JButton b : plantButtonList){
            boxPanel.add(b);
        }
        
        boxPanel.add(Box.createHorizontalGlue());
        
        boxPanel.add(shovelBox);
        boxPanel.add(pauseBox);
        boxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        
        for(int y = 0; y < gridList.size(); y++){
            for(int x = 0; x < gridList.get(y).size(); x++){
                gridPanel.add(gridList.get(y).get(x));
            }
        }
            
        // - - - - - - - Add Subpanels in Panel - - - - - - -
        
        this.add(boxPanel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);
    }
    
    public GameController getController(){
        return controller;
    }
    
    public void addGameController(){
        controller = new GameController(frame, this, shovelBox, pauseBox, plantButtonList, gridList);
        
        shovelBox.addActionListener(controller);
        pauseBox.addActionListener(controller);
        for(JButton p : plantButtonList){
            p.addActionListener(controller);
        }
        for(int y = 0; y < 5; y++){
            for(int x = 0; x < 9; x++){
                gridList.get(y).get(x).addMouseListener(controller);
            }
        }
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
