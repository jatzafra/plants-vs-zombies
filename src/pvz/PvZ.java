/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pvz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pvz.classes.*;
import pvz.screens.Frame;

/**
 *
 * @author TRUTH
 */
public class PvZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedImageLoader imgLoader = new BufferedImageLoader();
        
        SunProducer sunflower = new SunProducer(300, 50, 50, "sunflower_idle.png", 900, 1200, 12);
        Shooter peashooter = new Shooter(300, 100, "peashooter", "peashooter_idle.png", 900, 1200, 12);
        Defense walnut = new Defense(4000, 50, "wallnut_idle.png", 390, 520, 12);
        Bomb cherry = new Bomb(9999, 150, 0, true, "cherry", "cherrybomb_draft.png", 900, 1200, 1);
        
        Zombie basic = new Zombie("basic", 190, 100, -5.0, "zombie_walk.png", 900, 1200, 8);
        Zombie conehead = new Zombie("conehead", 560, 100, -5.0, "conehead_walk.png", 900, 1200, 8);
        Zombie buckethead = new Zombie("buckethead", 1290, 100, -5.0, "buckethead_walk.png", 900, 1200, 8);
        
        Projectile pea = new Projectile((float) 0.11, 20, "peashooter", "pea.png", 600, 330, 3);
        
        Plant.addUsedPlants(sunflower);
        Plant.addUsedPlants(peashooter);
        Plant.addUsedPlants(walnut);
        Plant.addUsedPlants(cherry);
        
        Zombie.addUsedZombies(basic);
        Zombie.addUsedZombies(conehead);
        Zombie.addUsedZombies(buckethead);
        
        Projectile.addUsedProjectiles(pea);
        
        for(Object o : Plant.getUsedPlants()){
            Plant p = (Plant) o;
            
            try {
                SpriteSheet sheet = new SpriteSheet(imgLoader.loadImage("/imgs/" + p.getImgFilename()));
                int width, height;
                p.setSpriteSheet(sheet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(Object o : Zombie.getUsedZombies()){
            Zombie z = (Zombie) o;
            
            try {
                SpriteSheet sheet = new SpriteSheet(imgLoader.loadImage("/imgs/" + z.getImgFilename()));
                int width, height;
                z.setSpriteSheet(sheet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(Object o : Projectile.getUsedProjectiles()){
            Projectile pr = (Projectile) o;
            
            try {
                SpriteSheet sheet = new SpriteSheet(imgLoader.loadImage("/imgs/" + pr.getImgFilename()));
                int width, height;
                pr.setSpriteSheet(sheet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        Frame frame = new Frame();
        
    }
    
}
