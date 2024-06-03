/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import java.awt.CardLayout;
import pvz.screens.CreditsPanel;
import pvz.screens.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pvz.screens.Frame;

/**
 *
 * @author Lenovo
 */
public class MenuController implements ActionListener{
    private JPanel panel;
    private JTextField nameField;
    private JButton enterName, credits, easy, normal, hard;
    private Frame frame;
    private GameController gameController;
    
    private String name;
    
    public MenuController(JPanel p, JTextField nText, JButton eName, JButton c, JButton e, JButton n, JButton h, Frame f){
        panel = p;
        nameField = nText;
        enterName = eName;
        credits = c;
        easy = e;
        normal = n;
        hard = h;
        frame = f;
    }
    
    public void setGameController(GameController c){
        gameController = c;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == credits){
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "creditsPanel");
        }
        else if(e.getSource() == easy){
            gameController.setUnpaused(true);
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "gamePanel");
            String difficulty = "easy"; //kind of a placeholder cuz idk how to indicate the change in difficulty
        }
        else if(e.getSource() == normal){
            gameController.setUnpaused(true);
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "gamePanel");
            String difficulty = "normal";
        }
        else if(e.getSource() == hard){
            gameController.setUnpaused(true);
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "gamePanel");
            String difficulty = "hard";
        }
        else if(e.getSource() == enterName){
            name = nameField.getText();
//            System.out.println("User: " + name);
        }
    }
    
}
