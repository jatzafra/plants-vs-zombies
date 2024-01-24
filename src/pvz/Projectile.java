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
    
    public Projectile(int s, int a, String t){
        super(s);
        atk = a;
        type = t;
    }
    
    public void hit(){ //unfinished
        target = Tile.getFirstZombie(xCoord, yCoord);
        if(target==null){
          target.setHP -= atk;
        }
    }
}
