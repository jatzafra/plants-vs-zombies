/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import pvz.controllers.GameController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import pvz.classes.Plant;

/**
 *
 * @author Lenovo
 */
public class GamePanel extends JPanel {
    // - - - - - - - Declare Components - - - - - - - 
    private Frame frame;
    private JLayeredPane layeredPane;
    private JPanel background, movingEntities, gameLayer;
    private GameController controller;
    private JButton sunBox, shovelBox, pauseBox;
    
    private ImageIcon wireframeIcon = new ImageIcon(getClass().getResource("../imgs/wireframe.jpg"));
    
    private ArrayList<JButton> plantButtonList = new ArrayList<>();
    private ArrayList<JPanel> rowList = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> gridList;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    double width = screenSize.getWidth();
//    double height = screenSize.getHeight();
    double width = 1400;
    double height = 800;
    
    public GamePanel(Frame f){
        this.frame = f;
        
        this.gridList = new ArrayList<ArrayList<JLabel>>();
        this.setLayout(null);
        
        // - - - - - - - LayeredPane - - - - - - -
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, (int)width, (int)height);
        
        // - - - - - - - Background Layer - - - - - - -
        background = new JPanel();
        background.setLayout(null);
        background.setBounds(0, 0, (int)width, (int)height);
            
        ImageIcon bg = new ImageIcon(getClass().getResource("../imgs/garden_draft.png"));
        ImageIcon resizedBg = getScaledIcon(bg, 2073, 800); //original dimensions are 2060x795
        
        JLabel bgLabel = new JLabel();
        bgLabel.setBounds(-200, 0, 2073, 800);
        bgLabel.setIcon(resizedBg);
        bgLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        bgLabel.setHorizontalAlignment(JLabel.LEFT);
        bgLabel.setVerticalAlignment(JLabel.TOP);
        background.add(bgLabel);
        
        // - - - - - - - MovingEntities Layer - - - - - - -
        movingEntities = new JPanel();
        movingEntities.setLayout(null);
        movingEntities.setBounds(0, 0, (int)width, (int)height);
        movingEntities.setOpaque(false);
        
        // - - - - - - - GameLayer - - - - - - -
        gameLayer = new JPanel();
        gameLayer.setLayout(new BorderLayout());
        gameLayer.setBounds(0, 0, (int)width, (int)height);
        gameLayer.setOpaque(false);
        gameLayer.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        // - - - - - - - BoxLayout Game Subpanel - - - - - - -
        JLayeredPane gameBoxPanel = new JLayeredPane();
        gameBoxPanel.setLayout(null);
        gameBoxPanel.setOpaque(false);
        
        for(int y = 0; y < 5; y++){
            JPanel entityPanel = new JPanel();
            entityPanel.setLayout(null);
            entityPanel.setOpaque(false);
//            entityPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            entityPanel.setBounds(0, 110*y, 1100, 167);
            
            rowList.add(entityPanel);
        }
        
        // - - - - - - - BoxLayout Plant Subpanel North - - - - - - -
        
        JPanel plantBoxPanel = new JPanel();
        plantBoxPanel.setLayout(new BoxLayout(plantBoxPanel, BoxLayout.X_AXIS));
        plantBoxPanel.setOpaque(false);
        
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
        gridPanel.setOpaque(false);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(56, 307, 64, 94));
        
        for(int y = 0; y < 5; y++){
            ArrayList<JLabel> innerArr = new ArrayList<>();
            
            for(int x = 0; x < 9; x++){
                JLabel label = new JLabel();
                
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
//                label.setBorder(BorderFactory.createLineBorder(Color.black));
                
                innerArr.add(label);
            }
            
            gridList.add(innerArr);
        }
        
        // - - - - - - - Add Components in Subpanels - - - - - - -
        
        plantBoxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        plantBoxPanel.add(sunBox);
        plantBoxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        
        for(JButton b : plantButtonList){
            plantBoxPanel.add(b);
        }
        
        plantBoxPanel.add(Box.createHorizontalGlue());
        
        plantBoxPanel.add(shovelBox);
        plantBoxPanel.add(pauseBox);
        plantBoxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        
        for(int y = 0; y < rowList.size(); y++){
            JPanel p = rowList.get(y);
            gameBoxPanel.add(p, Integer.valueOf(y));
        }
        
        for(int y = 0; y < gridList.size(); y++){
            for(int x = 0; x < gridList.get(y).size(); x++){
                gridPanel.add(gridList.get(y).get(x));
            }
        }
        
        // - - - - - - - Add Subpanels in MovingEntities Layer - - - - - - -
        movingEntities.add(gameBoxPanel);
        gameBoxPanel.setBounds(280, 130, 1100, 700);
        
        // - - - - - - - Add Subpanels in Game Layer - - - - - - -
        gameLayer.add(plantBoxPanel, BorderLayout.NORTH);
        gameLayer.add(gridPanel, BorderLayout.CENTER);
        
        // - - - - - - - Add Layers to LayeredPane - - - - - - - 
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(gameLayer, Integer.valueOf(1));
        layeredPane.add(movingEntities, Integer.valueOf(2));
        
        // - - - - - - - Add LayeredPane to GamePanel - - - - - - - 
        this.add(layeredPane);
    }
    
    public GameController getController(){
        return controller;
    }
    
    public void addGameController(){
        controller = new GameController(frame, this, shovelBox, pauseBox, plantButtonList, rowList, gridList);
        
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
