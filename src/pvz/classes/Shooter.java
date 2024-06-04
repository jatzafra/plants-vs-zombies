/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.awt.image.BufferedImage;
import pvz.classes.Tile;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import pvz.controllers.GameController;

/**
 *
 * @author Bella Buyco
 */
public class Shooter extends Plant{
    /**
     * this class creates a Shooter type of Plant
     */
    
    /**
     * refers to the type of Shooter it is (lobbed or straight)
     */
    private String type;
    /**
     * static projectile counter set to 0
     */
    private static int projectileCounter = 0;
    /**
     * creates a game controller
     */
    private GameController controller;
    /**
     * interval between shots of Projectile set to 0
     */
    private int shootInterval = 0;
    
    /**
     * constructor methods for Shooter class
     */
    public Shooter(int h, int c, String t, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
        type = t;
    }
    public Shooter(int h, int c, String t, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
        type = t;
    }
    
    /**
     * allows the Shooter Plant to shoot at nearest Zombie in its row
     * @return null
     */
    public void shoot(){
        if(this.detect()){
            Projectile selectedProjectile = null;
            if(this.getType() == "peashooter"){
                selectedProjectile = (Projectile) Projectile.getUsedProjectiles().get(0);
            }
            
            Projectile pr = new Projectile(selectedProjectile.getSpeed(), selectedProjectile.getAttack(), selectedProjectile.getType(), 
                                           selectedProjectile.getImgFilename(), selectedProjectile.getSpriteWidth(), 
                                           selectedProjectile.getSpriteHeight(), selectedProjectile.getMaxAnimFrame());
            
            pr.setSpriteSheet(selectedProjectile.getSpriteSheet());
            Tile.addAbsoluteEntity(pr, this.getAbsoluteY(), this.getAbsoluteX());
            
            SpriteSheet newProjectileSprite = selectedProjectile.getSpriteSheet();
            BufferedImage grabbedImg = newProjectileSprite.grabImage(1, 1, pr.getSpriteWidth(), pr.getSpriteHeight());
            BufferedImage resizedImg = newProjectileSprite.resizeImage(60, 33,grabbedImg);

            JLabel prLabel = new JLabel();
            prLabel.setIcon(new ImageIcon(resizedImg));
            pr.setProjectileLabel(prLabel);
            Entity.getGamePanel().getController().addToRowList(pr.getAbsoluteY(), prLabel);
            prLabel.setBounds(pr.getAbsoluteX() + 15, 75, 60, 33);
            
            newProjectileSprite = null;
            
            selectedProjectile = null;
        }
    }
    /**
     * detects if there are nearby zombies in the row
     * @return null
     */
    public boolean detect(){
        for(Zombie z : Tile.getZombieList()){
            if(z.getAbsoluteX() >= this.getAbsoluteX() && z.getAbsoluteY() == this.getAbsoluteY()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * gets the Shooter type
     * @return type
     */
    public String getType(){
        return type;
    }
    /**
     * gets the shootInterval
     * @return shootInterval
     */
    public int getShootInterval(){
        return shootInterval;
    }
    /**
     * sets the shootInterval
     * @param i 
     */
    public void setShootInterval(int i){
        shootInterval = i;
    }
    /**
     * increases the shootInterval
     */
    public void incShootInterval(){
        shootInterval++;
    }
    
}
