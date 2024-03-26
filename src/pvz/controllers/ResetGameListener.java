/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import pvz.classes.Tile;
import pvz.screens.Frame;
import pvz.screens.GamePanel;

/**
 *
 * @author Lenovo
 */
public class ResetGameListener implements ActionListener {
    GamePanel gamePanel;
    
    public ResetGameListener(GamePanel g){
        gamePanel = g;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GameController gameController = gamePanel.getController();
        gameController.resetGameScreen();
        Tile.clearAllEntities();
    }
    
}
