/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

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
            
        }
        else if(e.getSource() == easy){
            
        }
        else if(e.getSource() == normal){
            
        }
        else if(e.getSource() == hard){
            
        }
        else if(e.getSource() == enterName){
            
        }
    }
    
}
