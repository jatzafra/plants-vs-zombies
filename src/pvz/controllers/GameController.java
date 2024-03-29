/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import pvz.screens.Frame;
import pvz.classes.Tile;
import pvz.classes.Plant;
import pvz.classes.Bomb;
import pvz.classes.Defense;
import pvz.classes.Shooter;
import pvz.classes.SunProducer;

import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
    private JButton shovelBox, pauseBox, plantBox;
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
        selectedPlant = null;
        
        if(e.getSource() == pauseBox){
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "pausePanel");
        }
        
        for(JButton l : plantButtonList){
            if(e.getSource() == l){
//                System.out.println("from " + plantButtonList.indexOf(l));
                int index = plantButtonList.indexOf(l);
                selectedPlant = (Plant) Plant.getUsedPlants().get(index);
                
                break;
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int y = 0; y < gridList.size(); y++){
            for(int x = 0; x < gridList.get(y).size(); x++){
                if(e.getSource() == gridList.get(y).get(x)){
//                    System.out.println("clicked on gridList from " + y + ", " + x);
                    if(selectedPlant != null){
                        if(selectedPlant instanceof SunProducer){
                            SunProducer selected = (SunProducer) selectedPlant;
                            SunProducer newP = new SunProducer(selected.getHP(), selected.getSunCost(), selected.getSunProduced(), selected.getImgFilename());
                            Tile.addEntity(newP, x, y);
                        } else if(selectedPlant instanceof Shooter){
                            Shooter selected = (Shooter) selectedPlant;
                            Shooter newP = new Shooter(selected.getHP(), selected.getSunCost(), selected.getType(), selected.getImgFilename());
                            Tile.addEntity(newP, x, y);
                        } else if(selectedPlant instanceof Defense){
                            Defense selected = (Defense) selectedPlant;
                            Defense newP = new Defense(selected.getHP(), selected.getSunCost(), selected.getImgFilename());
                            Tile.addEntity(newP, x, y);
                        } else if(selectedPlant instanceof Bomb){
                            Bomb selected = (Bomb) selectedPlant;
                            Bomb newP = new Bomb(selected.getHP(), selected.getSunCost(), selected.getChargeUp(), selected.getActive(), selected.getType(), selected.getImgFilename());
                            Tile.addEntity(newP, x, y);
                        }
                        JLabel label = gridList.get(y).get(x);
                        label.setIcon(getScaledIcon(new ImageIcon(getClass().getResource("../imgs/" + selectedPlant.getImgFilename())), 80, 100));
                        
                    }
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
    
    private ImageIcon getScaledIcon(ImageIcon srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg. getImage(), 0, 0, w, h, null);
        g2.dispose();
        
        return new ImageIcon(resizedImg);
    }
}
