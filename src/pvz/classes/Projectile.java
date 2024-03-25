/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Tile;
import pvz.classes.Zombie;

/**
 *
 * @author Bella Buyco
 */
public class Projectile extends Entity {
    private String type;
    private int atk;
    private Entity target;
    
    public Projectile(int s, String i, int a, String t){
        super(s, i);
        atk = a;
        type = t;
    }
    
    public void hit(){ 
        Zombie target = Tile.getFirstZombieInTile(xCoord, yCoord);
        
        if(target != null && target.getHP() > 0){
            if(target.getHP() > atk){
                target.setHP(target.getHP() - atk);
            }
            else{
                //target Zombie dies
                target.setHP(0);
                Tile.removeEntity(target, xCoord, yCoord);
                System.out.println("Projectile has killed Zombie."); //removable
            }
            Tile.removeEntity(this, xCoord, yCoord); //removes Projectile
        }
    }
}
