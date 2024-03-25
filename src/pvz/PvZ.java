/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pvz;

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
        Frame frame = new Frame();
        
        /*
        //Scenario 1
        SunProducer sunflower = new SunProducer(300, 50, 50);
        Tile.addEntity(sunflower, 0, 0);
        sunflower.generateSun();
        System.out.println("Sun: " + Plant.getSun());
        sunflower.generateSun();
        System.out.println("Sun: " + Plant.getSun());
        sunflower.generateSun();
        System.out.println("Sun: " + Plant.getSun());
        System.out.println("scenario 1 end");
        
        //Scenario 2
        Shooter peashooter = new Shooter(350, 100, "straight");
        Zombie normal = new Zombie("normal", 50, 50, -2);
        
        Tile.addEntity(peashooter, 3, 3);
        Tile.addEntity(normal, 6, 3);
        
        while(peashooter.getHP() > 0 && normal.getHP() > 0){
            peashooter.shoot();
            Tile.hitAllProjectiles();
            Tile.moveAllProjectiles();
            Tile.hitAllProjectiles();
            Tile.moveAllZombies();
            Tile.hitAllProjectiles();
            
            System.out.println("normal zombie Coords: " + normal.getX() + ", " + normal.getY());
            System.out.println("normal zombie HP: " + normal.getHP());
        }
        System.out.println("scenario 2 end");
        
        //Scenario 3
        Defense wallnut = new Defense(3000, 50);
        Zombie buckethead = new Zombie("buckethead", 500, 50, -2);
        
        Tile.addEntity(wallnut, 4, 4);
        Tile.addEntity(buckethead, 4, 4);
        
        buckethead.targetPlant();
        
        while(wallnut.getHP() > 0){
            buckethead.eatPlant();
            System.out.println("wallnut HP: " + wallnut.getHP());
        }
        System.out.println("scenario 3 end");
        */
    }
    
}
