/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class GameController implements ActionListener, MouseListener{
    private JPanel panel;
    private JButton sunBox, shovelBox, pauseBox, plantBox;
    
    private ArrayList<JButton> plantButtonList = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> gridList;
    
    public GameController(JPanel m, JButton s, JButton sh, JButton p, JButton pl, ArrayList<JButton> plist, ArrayList<ArrayList<JLabel>> glist){
        panel = m;
        sunBox = s;
        shovelBox = sh;
        pauseBox = p;
        plantBox = pl;
        plantButtonList = plist;
        gridList = glist;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton l : plantButtonList){
            if(e.getSource() == l){
                System.out.println("from " + plantButtonList.indexOf(l));
                break;
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
