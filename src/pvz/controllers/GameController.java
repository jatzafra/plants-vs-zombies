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
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pvz.classes.Projectile;
import pvz.classes.SpriteSheet;
import pvz.classes.Zombie;

/**
 *
 * @author Lenovo
 */
public class GameController implements ActionListener, MouseListener{
    private Frame frame;
    private JPanel panel;
    private JButton shovelBox, pauseBox;
    private ArrayList<JButton> plantButtonList = new ArrayList<>();
    private ArrayList<JPanel> rowList = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> gridList;
    
    private Plant selectedPlant, newPlant;
    private SpriteSheet newPlantSprite, newProjectileSprite, newZombieSprite;
    private boolean unpaused, shovelActive = false;
    private int selectedX = -1, selectedY = -1;
    
    private long lastFrame;
    private double timePerFrame;
    private long lastUpdate;
    private double timePerUpdate;
    
    private boolean test = true;
    
    public GameController(Frame f, JPanel m, JButton s, JButton p, ArrayList<JButton> plist, ArrayList<JPanel> rlist, ArrayList<ArrayList<JLabel>> glist){
        frame = f;
        panel = m;
        shovelBox = s;
        pauseBox = p;
        plantButtonList = plist;
        rowList = rlist;
        gridList = glist;
        unpaused = false;
        timePerFrame = 1000000000.0 / 120.0; //120 per sec
        timePerUpdate = 1000000000.0 / 60.0; //60 per sec
    }
    
    public void loopGame(){
        while(true){
            if(System.nanoTime() >= 2000000000.0 && test){
                test = false;
                Zombie z = (Zombie) Zombie.getUsedZombies().get(2);
                Tile.addAbsoluteEntity(z, 1, 1100);
                
                newZombieSprite = z.getSpriteSheet();
                BufferedImage grabbedImg = newZombieSprite.grabImage(1, 1, z.getSpriteWidth(), z.getSpriteHeight());
                BufferedImage resizedImg = newZombieSprite.resizeImage(135, 180,grabbedImg);
                
                JLabel zLabel = new JLabel();
                zLabel.setIcon(new ImageIcon(resizedImg));
                z.setZombieLabel(zLabel);
                rowList.get(1).add(zLabel);
                zLabel.setBounds(z.getAbsoluteX(), -47, 180, 250);
                newZombieSprite = null;
                
                Zombie z1 = (Zombie) Zombie.getUsedZombies().get(1);
                Tile.addAbsoluteEntity(z1, 3, 1100);
                
                newZombieSprite = z1.getSpriteSheet();
                BufferedImage grabbedImg1 = newZombieSprite.grabImage(1, 1, z1.getSpriteWidth(), z1.getSpriteHeight());
                BufferedImage resizedImg1 = newZombieSprite.resizeImage(135, 180,grabbedImg1);
                
                JLabel zLabel1 = new JLabel();
                zLabel1.setIcon(new ImageIcon(resizedImg1));
                z1.setZombieLabel(zLabel1);
                rowList.get(3).add(zLabel1);
                zLabel1.setBounds(z1.getAbsoluteX(), -47, 180, 250);
                newZombieSprite = null;
                
                Zombie z2 = (Zombie) Zombie.getUsedZombies().get(0);
                Tile.addAbsoluteEntity(z2, 2, 1100);
                
                newZombieSprite = z2.getSpriteSheet();
                BufferedImage grabbedImg2 = newZombieSprite.grabImage(1, 1, z.getSpriteWidth(), z.getSpriteHeight());
                BufferedImage resizedImg2 = newZombieSprite.resizeImage(135, 180,grabbedImg2);
                
                JLabel zLabel2 = new JLabel();
                zLabel2.setIcon(new ImageIcon(resizedImg2));
                z2.setZombieLabel(zLabel2);
                rowList.get(2).add(zLabel2);
                zLabel2.setBounds(z2.getAbsoluteX(), -47, 180, 250);
                newZombieSprite = null;
            }
            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                lastUpdate = System.nanoTime();
                updateGame();
            }
            if(System.nanoTime() - lastFrame >= timePerFrame){
                lastFrame = System.nanoTime();
                nextFrame();
            }
        }
    }
    
    public void updateGame(){
        if(selectedX >= 0 && selectedY >= 0){
            if(shovelActive == true && Tile.getPlant(selectedY, selectedX) != null){
                gridList.get(selectedY).get(selectedX).setIcon(null); //view
                Tile.removeGridEntity(selectedY, selectedX); //model
                
                shovelActive = false;
                selectedX = -1; selectedY = -1;
            }
            if(newPlant != null){
                Tile.addGridEntity(newPlant, selectedY, selectedX);
                
                BufferedImage grabbedImg = newPlantSprite.grabImage(1, 1, newPlant.getSpriteWidth(), newPlant.getSpriteHeight());
                BufferedImage resizedImg = newPlantSprite.resizeImage(75, 100,grabbedImg);

                JLabel label = gridList.get(selectedY).get(selectedX);
                label.setIcon(new ImageIcon(resizedImg));
                label.repaint();
                
                System.out.println("y: " + newPlant.getAbsoluteY() + " x: " + newPlant.getAbsoluteX());
                
                newPlant = null;
                selectedX = -1; selectedY = -1;
            }
        }
        for(Zombie z : Tile.getZombieList()){
            int maxMoveInterval = 30;
            
            if(z.getMoveInterval() < maxMoveInterval){
                z.incMoveInterval();
            } else{
                z.setMoveInterval(0);
                int moveBy = (int) (110 / (z.getSpeed() * 2));
                z.setAbsoluteX(z.getAbsoluteX() + moveBy);
            }
        }
        for(Projectile pr : Tile.getProjectileList()){
            int maxMoveInterval = 6;
            
            if(pr.getMoveInterval() < maxMoveInterval){
                pr.incMoveInterval();
            } else{
                pr.setMoveInterval(0);
                int moveBy = (int) (110 / pr.getSpeed() / 20);
                pr.setAbsoluteX(pr.getAbsoluteX() + moveBy);
            }
        }
        for(Plant p : Tile.getPlantList()){
            if(p instanceof Shooter){
                Shooter s = (Shooter) p;
                int maxShootInterval = 90;
                
                if(s.getShootInterval() < maxShootInterval){
                    s.incShootInterval();
                } else{
                    s.setShootInterval(0);
                    s.shoot();
                }
            }
        }
    }
    public void nextFrame(){
        for(Plant p : Tile.getPlantList()){
            int maxFrameInterval = 18; // standard frame interval
            
            // special frame intervals
            if(p instanceof Defense){
                maxFrameInterval = 30;
            }
            
            if(p.getFrameInterval() < maxFrameInterval){ // plant's frames update after every 18 frames
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
        for(Zombie z : Tile.getZombieList()){
            int maxFrameInterval = 36;
            
            if(z.getFrameInterval() < maxFrameInterval){
                z.incFrameInterval();
            } else{
                z.setFrameInterval(0);
                z.incAnimFrame();
                
                BufferedImage grabbedImg = z.getSpriteSheet().grabImage(z.getAnimFrame(), 1, z.getSpriteWidth(), z.getSpriteHeight());
                BufferedImage resizedImg = z.getSpriteSheet().resizeImage(135, 180,grabbedImg);
                ImageIcon img = new ImageIcon(resizedImg);
                JLabel label = z.getZombieLabel();
                label.setIcon(img);
                label.setBounds(z.getAbsoluteX(),-47, 180, 250);
            }
        }
        for(Projectile pr : Tile.getProjectileList()){
            int maxFrameInterval = 6;
            
            if(pr.getFrameInterval() < maxFrameInterval){
                pr.incFrameInterval();
            } else{
                pr.setFrameInterval(0);
                pr.incAnimFrame();
                
                BufferedImage grabbedImg = pr.getSpriteSheet().grabImage(pr.getAnimFrame(), 1, pr.getSpriteWidth(), pr.getSpriteHeight());
                BufferedImage resizedImg = pr.getSpriteSheet().resizeImage(60, 33,grabbedImg);
                ImageIcon img = new ImageIcon(resizedImg);
                JLabel label = pr.getProjectileLabel();
                label.setIcon(img);
                label.setBounds(pr.getAbsoluteX(), 75, 60, 33);
            }
        }
    }
    
    public void resetGameScreen(){ // does NOT reset Tile instance
        
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
        for(Zombie z : Tile.getZombieList()){
            JLabel label = z.getZombieLabel();
            label.setIcon(null);
            rowList.get(z.getAbsoluteY()).remove(label);
        }
        
    }
    
    
    public ArrayList getRowList(){
        return rowList;
    }
    public void addToRowList(int y, JLabel l){
        rowList.get(y).add(l);
    }
    
    public void setUnpaused(boolean u){
        unpaused = u;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedPlant = null;
        shovelActive = false;
        selectedX = -1; selectedY = -1;
        
        if(e.getSource() == shovelBox){
            shovelActive = true;
        }
        
        if(e.getSource() == pauseBox){
            unpaused = false;
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
                    selectedX = x; selectedY = y;
                    
                    if(shovelActive == true && Tile.getPlant(y, x) == null){
                        shovelActive = false;
                    }
                    
                    if(selectedPlant != null && Tile.getPlant(y, x) == null){
                        if(selectedPlant instanceof SunProducer){
                            SunProducer s = (SunProducer) selectedPlant;
                            SunProducer newP = new SunProducer(s.getHP(), s.getSunCost(), s.getSunProduced(), s.getImgFilename(), 
                                                               s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
//                            Tile.addEntity(newP, y, x);
                            newPlant = newP;
                        } else if(selectedPlant instanceof Shooter){
                            Shooter s = (Shooter) selectedPlant;
                            Shooter newP = new Shooter(s.getHP(), s.getSunCost(), s.getType(), 
                                                       s.getImgFilename(), s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
//                            Tile.addEntity(newP, y, x);
                            newPlant = newP;
                        } else if(selectedPlant instanceof Defense){
                            Defense s = (Defense) selectedPlant;
                            Defense newP = new Defense(s.getHP(), s.getSunCost(), s.getImgFilename(), 
                                                       s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
//                            Tile.addEntity(newP, y, x);
                            newPlant = newP;
                        } else if(selectedPlant instanceof Bomb){
                            Bomb s = (Bomb) selectedPlant;
                            Bomb newP = new Bomb(s.getHP(), s.getSunCost(), s.getChargeUp(), s.getActive(), 
                                                 s.getType(), s.getImgFilename(), s.getSpriteWidth(), s.getSpriteHeight(), s.getMaxAnimFrame());
                            newP.setSpriteSheet(s.getSpriteSheet());
//                            Tile.addEntity(newP, y, x);
                            newPlant = newP;
                        }
                        newPlantSprite = selectedPlant.getSpriteSheet();
                    }
                    
                    selectedPlant = null;
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
