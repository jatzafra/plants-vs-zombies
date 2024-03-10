/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class MenuPanel extends JPanel implements ActionListener {
    
    // - - - - - - - Declare Components - - - - - - - 
    JButton credits;
    JButton easy;
    JButton normal;
    JButton hard;
    
    JTextField name;
    JButton enterName;
    
    
    MenuPanel(){
        this.setLayout(new BorderLayout());
        
        // - - - - - - - BoxLayout Subpanel East - - - - - - -
        
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setPreferredSize(new Dimension(500, 1080));
//        boxPanel.setBackground(Color.red);
        
        credits = new JButton("Credits");
        easy = new JButton("Easy Mode");
        normal = new JButton("Normal Mode");
        hard = new JButton("Hard Mode");
        
        
        credits.addActionListener(this);
        easy.addActionListener(this);
        normal.addActionListener(this);
        hard.addActionListener(this);
        
        credits.setFont(new Font("Dialog", Font.PLAIN, 60));
        easy.setFont(new Font("Dialog", Font.PLAIN, 40));
        normal.setFont(new Font("Dialog", Font.PLAIN, 40));
        hard.setFont(new Font("Dialog", Font.PLAIN, 40));
        
        credits.setAlignmentX(JButton.CENTER_ALIGNMENT);
        easy.setAlignmentX(JButton.CENTER_ALIGNMENT);
        normal.setAlignmentX(JButton.CENTER_ALIGNMENT);
        hard.setAlignmentX(JButton.CENTER_ALIGNMENT);
        
        credits.setMaximumSize(new Dimension(350, 50));
        easy.setMaximumSize(new Dimension(350, 50));
        normal.setMaximumSize(new Dimension(350, 50));
        hard.setMaximumSize(new Dimension(350, 50));
        
        credits.setFocusable(false);
        easy.setFocusable(false);
        normal.setFocusable(false);
        hard.setFocusable(false);
        
        // - - - - - - - FlowLayout Subpanel North - - - - - - -
        
        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
        
        name = new JTextField();
        enterName = new JButton("Enter Name");
        
        name.setPreferredSize(new Dimension(300, 50));
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setFont(new Font("Monospaced", Font.PLAIN, 20));
        
        enterName.addActionListener(this);
        enterName.setFont(new Font("Dialog", Font.PLAIN, 15));
        enterName.setPreferredSize(new Dimension(150, 40));
        enterName.setFocusable(false);
        
        // - - - - - - - Add Components in Subpanels - - - - - - -
        
        boxPanel.add(Box.createVerticalGlue());
        boxPanel.add(credits);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        boxPanel.add(easy);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        boxPanel.add(normal);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        boxPanel.add(hard);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        boxPanel.add(Box.createVerticalGlue());
        
        flowPanel.add (name);
        flowPanel.add(enterName);
            
        // - - - - - - - Add Subpanels in Panel - - - - - - -
        
        this.add(flowPanel, BorderLayout.NORTH);
        this.add(boxPanel, BorderLayout.EAST);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == credits){
//            credits.setEnabled(false);
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
