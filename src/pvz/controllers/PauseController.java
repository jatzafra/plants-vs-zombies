/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pvz.screens.Frame;

/**
 *
 * @author Lenovo
 */
public class PauseController implements ActionListener{
    JPanel panel;
    JLabel pauseIcon, pauseText;
    JButton play, restart, exit;   
    Frame frame;
    
    public PauseController(JPanel p, JButton pl, JButton r, JButton e, Frame f){
        panel = p;
        play = pl;
        restart = r;
        exit = e;
        frame = f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "gamePanel");
        }
        else if(e.getSource() == restart){
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "gamePanel");
        }
        else if(e.getSource() == exit){
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "menuPanel");
        }
    }
    
}
