/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Tile;
import java.util.List;

/**
 *
 * @author Bella Buyco
 */
public class Shooter extends Plant{
    private String type;
    private static int projectileCounter = 0;
    
    public Shooter(int h, int c, String t){
        super(h, c);
        type = t;
    }
    
    public void shoot(){
        //generate a projectile
        String id = type + projectileCounter;
        projectileCounter++;
        
        Projectile projectile = new Projectile(1, id, 10, type);
        Tile.addEntity(projectile, xCoord, yCoord);
        System.out.println("Shooter made Projectile."); //removable
    }
    
}
