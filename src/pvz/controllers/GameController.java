/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import pvz.screens.Frame;
import pvz.classes.Plant;

import java.awt.CardLayout;
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
    private Frame frame;
    private JPanel panel;
    private JButton sunBox, shovelBox, pauseBox, plantBox;
    private ArrayList<JButton> plantButtonList = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> gridList;
    
    private Plant selectedPlant;
    
    public GameController(Frame f, JPanel m, JButton s, JButton p, JButton pl, ArrayList<JButton> plist, ArrayList<ArrayList<JLabel>> glist){
        frame = f;
        panel = m;
        shovelBox = s;
        pauseBox = p;
        plantBox = pl;
        plantButtonList = plist;
        gridList = glist;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pauseBox){
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "pausePanel");
        }
        
        for(JButton l : plantButtonList){
            if(e.getSource() == l){
                System.out.println("from " + plantButtonList.indexOf(l));
                break;
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int y = 0; y < gridList.size(); y++){
            for(int x = 0; x < gridList.get(y).size(); x++){
                if(e.getSource() == gridList.get(y).get(x)){
                    System.out.println("clicked on gridList from " + y + ", " + x);
                }
            }
        }
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
