/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import javax.swing.JLabel;
import pvz.classes.Tile;
import pvz.classes.Zombie;

/**
 *
 * @author Bella Buyco
 */
public class Projectile extends Entity {
    private int absoluteX, absoluteY;
    private String type;
    private int atk;
    private Entity target;
    private JLabel projectileLabel;
    
    // - - - - - - - *TEMPORARY* - - - - - - - 
    public Projectile(float s, int a, String t){
        super(s, "../imgs/wireframe.jpg", 25, 25, 1);
        atk = a;
        type = t;
    }
    
    public Projectile(float s, int a, String t, String f, int sw, int sh, int maxF){
        super(s, f, sw, sh, maxF);
        atk = a;
        type = t;
    }
    
    public int getAbsoluteX(){
        return absoluteX;
    }
    public int getAbsoluteY(){
        return absoluteY;
    }
    public void setAbsoluteX(int x){
        absoluteX = x;
    }
    public void setAbsoluteY(int y){
        absoluteY = y;
    }
    public void setAbsoluteCoords(int y, int x){
        absoluteY = y;
        absoluteX = x;
    }
    public JLabel getProjectileLabel(){
        return projectileLabel;
    }
    public void setProjectileLabel(JLabel l){
        projectileLabel = l;
    }
    
    public void hit(){ 
//        Zombie target = Tile.getFirstZombieInTile(xCoord, yCoord);
//        
//        if(target != null && target.getHP() > 0){
//            if(target.getHP() > atk){
//                target.setHP(target.getHP() - atk);
//            }
//            else{
//                //target Zombie dies
//                target.setHP(0);
//                Tile.removeEntity(target, xCoord, yCoord);
//                System.out.println("Projectile has killed Zombie."); //removable
//            }
//            Tile.removeEntity(this, xCoord, yCoord); //removes Projectile
//        }
    }
}
