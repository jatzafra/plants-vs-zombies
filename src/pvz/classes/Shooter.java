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
    
    public Shooter(int h, int c, String t, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
        type = t;
    }
    public Shooter(int h, int c, String t, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
        type = t;
    }
    
    public void shoot(){
        //generate a projectile
        projectileCounter++;
        
        Projectile projectile = new Projectile(1, 10, type);
        Tile.addEntity(projectile, xCoord, yCoord);
        System.out.println("Shooter made Projectile."); //removable
    }
    
    public String getType(){
        return type;
    }
    
}
