/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import pvz.screens.CreditsPanel;
import pvz.screens.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class MenuController implements ActionListener{
    private JPanel panel;
    private JButton enterName, credits, easy, normal, hard;
    
    public MenuController(JPanel p, JButton eName, JButton c, JButton e, JButton n, JButton h){
        panel = p;
        enterName = eName;
        credits = c;
        easy = e;
        normal = n;
        hard = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == credits){
            credits.setEnabled(false);
            CreditsPanel creditsP = new CreditsPanel(credits);
            
            creditsP.setVisible(true);
        }
        else if(e.getSource() == easy){
            GamePanel easyP = new GamePanel();
            easy.setEnabled(false);
            easyP.setVisible(true);
            String difficulty = "easy"; //kind of a placeholder cuz idk how to indicate the change in difficulty
        }
        else if(e.getSource() == normal){
            GamePanel normalP = new GamePanel();
            normal.setEnabled(false);
            normalP.setVisible(true);
            String difficulty = "normal";
        }
        else if(e.getSource() == hard){
            GamePanel hardP = new GamePanel();
            hard.setEnabled(false);
            hardP.setVisible(true);
            String difficulty = "hard";
        }
        else if(e.getSource() == enterName){
            
        }
    }
    
}
