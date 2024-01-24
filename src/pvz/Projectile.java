/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

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
    
    public void hit(){ //unfinished
        Zombie target = Tile.getFirstZombieInTile(xCoord, yCoord);
        
        if(target != null && target.getHP() > 0){
            if(target.getHP() > atk){
                target.setHP(target.getHP() - atk);
            }
            else{
                //target Zombie dies
                Tile.removeEntity(target, xCoord, yCoord);
                System.out.println("Projectile " + this + " has killed Zombie "+ target);
            }
        }
    }
}
