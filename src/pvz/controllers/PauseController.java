/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class PauseController implements ActionListener{
    JPanel panel;
    JLabel pauseIcon, pauseText;
    JButton play, restart, exit, source;   
    
    public PauseController(JPanel p, JButton pl, JButton r, JButton e, JButton s){
        panel = p;
        play = pl;
        restart = r;
        exit = e;
        source = s;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            source.setEnabled(true);
            this.dispose();
        }
        else if(e.getSource() == restart){

        }
        else if(e.getSource() == exit){

        }
    }
    
}
