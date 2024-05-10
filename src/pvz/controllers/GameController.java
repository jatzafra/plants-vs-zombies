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
import pvz.classes.SpriteSheet;

/**
 *
 * @author Lenovo
 */
public class GameController implements ActionListener, MouseListener{
    private Frame frame;
    private JPanel panel;
    private JButton shovelBox, pauseBox;
    private ArrayList<JButton> plantButtonList = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> gridList;
    
    private Plant selectedPlant;
    private boolean shovelActive = false;
    
    private int frames;
    private long lastFrame;
    private double timePerFrame;
    private long lastUpdate;
    private double timePerUpdate;
    
    public GameController(Frame f, JPanel m, JButton s, JButton p, ArrayList<JButton> plist, ArrayList<ArrayList<JLabel>> glist){
        frame = f;
        panel = m;
        shovelBox = s;
        pauseBox = p;
        plantButtonList = plist;
        gridList = glist;
        timePerFrame = 1000000000.0 / 120.0; //120 per sec
        timePerUpdate = 1000000000.0 / 60.0; //60 per sec
    }
    
    public void loopGame(){
        while(true){
            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
            }
            if(System.nanoTime() - lastFrame >= timePerFrame){
                lastFrame = System.nanoTime();
                nextFrame();
            }
        }
    }
    
    public void updateGame(){
        
    }
    public void nextFrame(){
        for(Plant p : Tile.getPlantList()){
            int maxFrameInterval = 18; // standard frame interval
            
            // special frame intervals
            if(p instanceof SunProducer){
                maxFrameInterval = 30;
            }
            
            if(p.getFrameInterval() < maxFrameInterval){ // plant's frames update after every 30 frames
                p.incFrameInterval();
            } else{ 
                p.setFrameInterval(0);
                p.incAnimFrame();

                BufferedImage grabbedImg = p.getSpriteSheet().grabImage(p.getAnimFrame(), 1, p.getSpriteWidth(), p.getSpriteHeight());
                BufferedImage resizedImg = p.getSpriteSheet().resizeImage(75, 100,grabbedImg);
                ImageIcon img = new ImageIcon(resizedImg);
                JLabel label = gridList.get(p.getY()).get(p.getX());
                label.setIcon(img);
                label.repaint();
            }
        }
    }
    
    public void resetGameScreen(){ // does not reset Tile instance
        
        /* FOR PLANT INVENTORY RESET | NOT COMPLETELY FUNCTIONAL NOR NEEDED 
        for(JButton b : plantButtonList){
            int index = plantButtonList.indexOf(b);
            Plant p = (Plant) Plant.getUsedPlants().get(index);
            
            b.setIcon(getScaledIcon(new ImageIcon(getClass().getResource("../imgs/" + p.getImgFilename())), 80, 100));
        }*/
        for(int y = 0; y < gridList.size(); y++){
            for(int x = 0; x < gridList.get(y).size(); x++){
                gridList.get(y).get(x).setIcon(null);
            }
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedPlant = null;
        shovelActive = false;
        
        if(e.getSource() == shovelBox){
            shovelActive = true;
        }
        
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
                    if(shovelActive == true && Tile.getPlant(y, x) != null){
                        gridList.get(y).get(x).setIcon(null); //view
                        Tile.removeEntity(Tile.getPlant(y, x), y, x); //model
                        
                        shovelActive = false;
                        
                    } else if(selectedPlant != null && Tile.getPlant(y, x) == null){
                        if(selectedPlant instanceof SunProducer){
                            SunProducer s = (SunProducer) selectedPlant;
                            SunProducer newP = new SunProducer(s.getHP(), s.getSunCost(), s.getSunProduced(), s.getImgFilename(), 
                                                               s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
                            Tile.addEntity(newP, y, x);
                        } else if(selectedPlant instanceof Shooter){
                            Shooter s = (Shooter) selectedPlant;
                            Shooter newP = new Shooter(s.getHP(), s.getSunCost(), s.getType(), 
                                                       s.getImgFilename(), s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
                            Tile.addEntity(newP, y, x);
                        } else if(selectedPlant instanceof Defense){
                            Defense s = (Defense) selectedPlant;
                            Defense newP = new Defense(s.getHP(), s.getSunCost(), s.getImgFilename(), 
                                                       s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
                            Tile.addEntity(newP, y, x);
                        } else if(selectedPlant instanceof Bomb){
                            Bomb s = (Bomb) selectedPlant;
                            Bomb newP = new Bomb(s.getHP(), s.getSunCost(), s.getChargeUp(), s.getActive(), 
                                                 s.getType(), s.getImgFilename(), s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
                            Tile.addEntity(newP, y, x);
                        }
                        SpriteSheet selectedSheet = selectedPlant.getSpriteSheet();
                        BufferedImage grabbedImg = selectedSheet.grabImage(1, 1, selectedPlant.getSpriteWidth(), selectedPlant.getSpriteHeight());
                        BufferedImage resizedImg = selectedSheet.resizeImage(75, 100,grabbedImg);

                        JLabel label = gridList.get(y).get(x);
                        label.setIcon(new ImageIcon(resizedImg));
                        label.repaint();
                        selectedPlant = null;
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
