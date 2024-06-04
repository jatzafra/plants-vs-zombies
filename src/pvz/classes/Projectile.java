/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.util.ArrayList;
import javax.swing.JLabel;
import pvz.classes.Tile;
import pvz.classes.Zombie;

/**
 *
 * @author Bella Buyco
 */
public class Projectile extends Entity {
    private String type;
    private int attack;
    private Entity target;
    private JLabel projectileLabel;
    private int moveInterval;
    protected static ArrayList<Projectile> usedProjectiles = new ArrayList<>();
    
    // - - - - - - - *TEMPORARY* - - - - - - - 
    public Projectile(double s, int a, String t){
        super(s, "../imgs/wireframe.jpg", 25, 25, 1);
        attack = a;
        type = t;
    }
    
    public Projectile(double s, int a, String t, String f, int sw, int sh, int maxF){
        super(s, f, sw, sh, maxF);
        attack = a;
        type = t;
    }
    
    public String getType(){
        return type;
    }
    public int getAttack(){
        return attack;
    }
    
    public JLabel getProjectileLabel(){
        return projectileLabel;
    }
    public void setProjectileLabel(JLabel l){
        projectileLabel = l;
    }
    public void setMoveInterval(int i){
        moveInterval = i;
    }
    public void incMoveInterval(){
        moveInterval++;
    }
    public int getMoveInterval(){
        return moveInterval;
    }
    public static void addUsedProjectiles(Projectile p){
        usedProjectiles.add(p);
    }
    
    public static ArrayList getUsedProjectiles(){
        return usedProjectiles;
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
