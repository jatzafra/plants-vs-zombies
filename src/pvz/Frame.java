/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

import pvz.screens.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pvz.screens.CreditsPanel;
import pvz.screens.GamePanel;
import pvz.screens.MenuPanel;
import pvz.screens.PausePanel;

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
    
    Frame(){
        this.setTitle("Plants vs. Zombies");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        
        menuPanel = new MenuPanel();
        gamePanel = new GamePanel();
        pausePanel = new PausePanel();
        creditsPanel = new CreditsPanel();
        
        // - - - - - - - CHANGE FOLLOWING LINE TO SWITCH DISPLAY - - - - - - -
        JPanel displayedPanel = gamePanel;
        
        this.add(displayedPanel);

        this.setVisible(true);
        
        
    }
}
