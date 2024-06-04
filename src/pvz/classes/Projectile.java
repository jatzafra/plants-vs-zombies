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
 * this class creates an Entity called a Projectile used to damage Zombies
 */
public class Projectile extends Entity {
    /**
     * specifies what type of Projectile it is (lobbed or straight)
     */
    private String type;
    /**
     * how much damage it deals to Zombies
     */
    private int attack;
    /**
     * what Entity it is attacking
     */
    private Entity target;
    /**
     * label containing the projectile's ImageIcon
     */
    private JLabel projectileLabel;
    /**
     * amount of updates before an object is moved
     */
    private int moveInterval;
    /**
     * an arrayList containing used projectiles
     */
    protected static ArrayList<Projectile> usedProjectiles = new ArrayList<>();
    
    // - - - - - - - *TEMPORARY* - - - - - - - 
    
    /**
     * constructor method for Projectile
     * @param s Projectile speed
     * @param a Projectile attack
     * @param t Projectile type
     */
    public Projectile(double s, int a, String t){
        super(s, "../imgs/wireframe.jpg", 25, 25, 1);
        attack = a;
        type = t;
    }
    /**
     * constructor method for Projectile
     * @param s Projectile speed
     * @param a Projectile attack
     * @param t Projectile type
     * @param f img file name for Projectile sprite
     * @param sw Projectile sprite width 
     * @param sh Projectile sprite 
     * @param maxF max animation frames for Sprite
     */
    public Projectile(double s, int a, String t, String f, int sw, int sh, int maxF){
        super(s, f, sw, sh, maxF);
        attack = a;
        type = t;
    }
    
    /**
     * gets the Projectile Type
     * @return type
     */
    public String getType(){
        return type;
    }
    /**
     * gets the Projectile Attack
     * @return attack
     */
    public int getAttack(){
        return attack;
    }
    /**
     * gets the Projectile Label
     * @return projectileLabel
     */
    public JLabel getProjectileLabel(){
        return projectileLabel;
    }
    /**
     * sets the Projectile Attack
     * @param l new Label
     */
    public void setProjectileLabel(JLabel l){
        projectileLabel = l;
    }
    /**
     * sets the moveInterval
     * @param i new moveInterval value
     */
    public void setMoveInterval(int i){
        moveInterval = i;
    }
    /**
     * increases move interval
     */
    public void incMoveInterval(){
        moveInterval++;
    }
    /**
     * gets the move interval value
     * @return moveInterval
     */
    public int getMoveInterval(){
        return moveInterval;
    }
    /**
     * adds a Projectile to usedProjectiles
     * @param p  Projectile to add to usedProjectiles
     */
    public static void addUsedProjectiles(Projectile p){
        usedProjectiles.add(p);
    }
    /**
     * gets usedProjectiles arrayList
     * @return usedProjectiles
     */
    public static ArrayList getUsedProjectiles(){
        return usedProjectiles;
    }
    
    /**
     * allows Projectile to hit a Zombie
     */
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
