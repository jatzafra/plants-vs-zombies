/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import pvz.controllers.MenuController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pvz.controllers.ResetGameListener;

/**
 *
 * @author Lenovo
 */
public class MenuPanel extends JPanel {
    
    // - - - - - - - Declare Components - - - - - - - 
    private MenuController controller;
    private JButton enterName, credits, easy, normal, hard;
    private JTextField nameField;
    private Frame frame;
    
    public MenuPanel(Frame f){
        this.frame = f;
        
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
        
        nameField = new JTextField();
        enterName = new JButton("Enter Name");
        
        nameField.setPreferredSize(new Dimension(300, 50));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(new Font("Monospaced", Font.PLAIN, 20));
        
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
        
        flowPanel.add (nameField);
        flowPanel.add(enterName);
        
        // - - - - - - - Add Subpanels in Panel - - - - - - -
        
        this.add(flowPanel, BorderLayout.NORTH);
        this.add(boxPanel, BorderLayout.EAST);
    }
    
    
    public MenuController getController(){
        return controller;
    }
    
    public void addMenuController(){
        controller = new MenuController(this, nameField, enterName, credits, easy, normal, hard, frame);
        
        credits.addActionListener(controller);
        easy.addActionListener(controller);
        normal.addActionListener(controller);
        hard.addActionListener(controller);
        enterName.addActionListener(controller);
    }
    public void addResetGameListener(GamePanel g){
        ResetGameListener listener = new ResetGameListener(g);
        // NOT NECESSARY
//        easy.addActionListener(listener);
//        normal.addActionListener(listener);
//        hard.addActionListener(listener);
    }
    
}
