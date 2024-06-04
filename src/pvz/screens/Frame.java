/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pvz.classes.BufferedImageLoader;
import pvz.classes.Entity;
import pvz.controllers.ResetGameListener;

/**
 *
 * @author Bella Buyco
 */
public class Frame extends JFrame {
    
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private PausePanel pausePanel;
    private CreditsPanel creditsPanel;
    private JButton button;
    
    public Frame(){
        this.setTitle("Plants vs. Zombies");
        this.setIconImage(new ImageIcon(getClass().getResource("../imgs/iconImage.png")).getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1400, 832); //800 + 32 from title bar
        this.setPreferredSize(new Dimension(1400, 832));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new CardLayout());
        
        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this);
        pausePanel = new PausePanel(this);
        creditsPanel = new CreditsPanel(this);
        
        menuPanel.addMenuController();
        gamePanel.addGameController();
        pausePanel.addPauseController();
        
        menuPanel.addResetGameListener(gamePanel);
        pausePanel.addResetGameListener(gamePanel);
        
        
        this.getContentPane().add("menuPanel", menuPanel);
        this.getContentPane().add("gamePanel", gamePanel);
        this.getContentPane().add("pausePanel", pausePanel);
        this.getContentPane().add("creditsPanel", creditsPanel);
        
        menuPanel.getController().setGameController(gamePanel.getController());
        pausePanel.getController().setGameController(gamePanel.getController());
        
        Entity.setGamePanel(gamePanel);
        
        this.setVisible(true);
//        
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        double width = screenSize.getWidth();
//        double height = screenSize.getHeight();
//        System.out.println("width: " + width + " height: " + height);
        
        gamePanel.getController().loopGame();
    }
}
