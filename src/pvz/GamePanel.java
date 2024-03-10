/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class GamePanel extends JPanel implements ActionListener{
    // - - - - - - - Declare Components - - - - - - - 
    JButton sunBox, shovelBox, pauseBox;
    JButton plantBox1, plantBox2, plantBox3, plantBox4, plantBox5, plantBox6, plantBox7, plantBox8, plantBox9;
    
    //TEMPORARY COMPONENTS
    ImageIcon wireframeIcon = new ImageIcon(GamePanel.class.getResource("wireframe.jpg"));
    
    Image wireframeImg = wireframeIcon.getImage();
    Image modifiedWireframeImg = wireframeImg.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
    
    ImageIcon modifiedWireframeIcon = new ImageIcon(modifiedWireframeImg);
    
    GamePanel(){
        this.setLayout(new BorderLayout());
        
        // - - - - - - - BoxLayout Subpanel North - - - - - - -
        
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.X_AXIS));
        
        sunBox = new JButton(modifiedWireframeIcon);
        
        plantBox1 = new JButton(modifiedWireframeIcon);
        plantBox2 = new JButton(modifiedWireframeIcon);
        plantBox3 = new JButton(modifiedWireframeIcon);
        plantBox4 = new JButton(modifiedWireframeIcon);
        plantBox5 = new JButton(modifiedWireframeIcon);
        plantBox6 = new JButton(modifiedWireframeIcon);
        plantBox7 = new JButton(modifiedWireframeIcon);
        plantBox8 = new JButton(modifiedWireframeIcon);
        plantBox9 = new JButton(modifiedWireframeIcon);
        
        shovelBox = new JButton(modifiedWireframeIcon);
        pauseBox = new JButton(modifiedWireframeIcon);
        
        
        // - - - - - - -  - - - - - - -
        
        
        
        // - - - - - - - Add Components in Subpanels - - - - - - -
        
        boxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        boxPanel.add(sunBox);
        boxPanel.add(plantBox1);
        boxPanel.add(plantBox2);
        boxPanel.add(plantBox3);
        boxPanel.add(plantBox4);
        boxPanel.add(plantBox5);
        boxPanel.add(plantBox6);
        boxPanel.add(plantBox7);
        boxPanel.add(plantBox8);
        boxPanel.add(plantBox9);
        
        boxPanel.add(Box.createHorizontalGlue());
        
        boxPanel.add(shovelBox);
        boxPanel.add(pauseBox);
        boxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
            
        // - - - - - - - Add Subpanels in Panel - - - - - - -
        
        this.add(boxPanel, BorderLayout.NORTH);
    }
    
    public void actionPerformed(ActionEvent e){
    }
}
