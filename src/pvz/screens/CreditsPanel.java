/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class CreditsPanel extends JPanel implements ActionListener{
    
    // - - - - - - - Declare Components - - - - - - - 
    JButton back, source;
    JLabel credits;
    
    public CreditsPanel(JButton s){
        this.setLayout(new BorderLayout());
        
        // - - - - - - - FlowLayout Subpanel North - - - - - - -
        
        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
        
        back = new JButton("Back");
        source = s;
        
        back.addActionListener(this);
        back.setFont(new Font("Dialog", Font.PLAIN, 15));
        back.setPreferredSize(new Dimension(150, 40));
        back.setFocusable(false);
        
        // - - - - - - - BoxLayout Subpanel Center - - - - - - -
        
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        
        credits = new JLabel();
        credits.setText("made by badong buyco zafra");
        credits.setFont(new Font("Dialog", Font.PLAIN, 50));
        credits.setAlignmentX(JLabel.CENTER_ALIGNMENT);
       
        // - - - - - - - Add Components in Subpanels - - - - - - -
        
        flowPanel.add(back);
        
        boxPanel.add(Box.createVerticalGlue());
        boxPanel.add(credits);
        boxPanel.add(Box.createVerticalGlue());
        
        // - - - - - - - Add Subpanels in Panel - - - - - - -
        
        this.add(flowPanel, BorderLayout.NORTH);
        this.add(boxPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        source.setEnabled(true);
        this.dispose(); //doesn't work on my end fsr
    }
}
