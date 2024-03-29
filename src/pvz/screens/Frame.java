/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bella Buyco
 */
public class Frame extends JFrame {
    
    MenuPanel menuPanel;
    GamePanel gamePanel;
    PausePanel pausePanel;
    CreditsPanel creditsPanel;
    JButton button;
    
    public Frame(){
        this.setTitle("Plants vs. Zombies");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        this.getContentPane().setLayout(new CardLayout());
        
        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this);
        pausePanel = new PausePanel(this);
        creditsPanel = new CreditsPanel(this);
        
        this.getContentPane().add("menuPanel", menuPanel);
        this.getContentPane().add("gamePanel", gamePanel);
        this.getContentPane().add("pausePanel", pausePanel);
        this.getContentPane().add("creditsPanel", creditsPanel);
        
        ((CardLayout)(this.getContentPane().getLayout())).next(this.getContentPane());
        ((CardLayout)(this.getContentPane().getLayout())).next(this.getContentPane());
        ((CardLayout)(this.getContentPane().getLayout())).next(this.getContentPane());
        ((CardLayout)(this.getContentPane().getLayout())).next(this.getContentPane());
        
        this.setVisible(true);
        
        
    }
}
