/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * Subclass of Entity that attacks Plants and is attacked by Projectile
 * @author Lenovo
 */
public class Zombie extends Entity {
    /**
     * type of Zombie dictated by a string
     */
    private String type;
    /**
     * hit points of Zombie
     */
    private int hp;
    /**
     * attack damage of Zombie
     */
    private int attack;
    /**
     * current target plant of Zombie
     */
    private Plant target;
    /**
     * amount of updates before an object is moved
     */
    private int moveInterval;
    /**
     * label containing the zombie's ImageIcon
     */
    private JLabel zombieLabel;
    /**
     * ArrayList containing zombies that will be used for a certain game
     * new instances will have parameters copied from these zombies
     */
    protected static ArrayList<Zombie> usedZombies = new ArrayList<>();
    
    /**
     * constructor for Zombie
     * @param t type of Zombie
     * @param h hit points of Zombie
     * @param a attack damage of Zombie
     * @param s speed of Zombies measured in seconds per Tile (should be negative)
     * @param f image filename of Zombie containing spritesheet
     * @param sw width of sprite
     * @param sh height of sprite
     * @param maxF max frames in sprite
     */
    public Zombie(String t, int h, int a, double s, String f, int sw, int sh, int maxF){
        super(s, f, sw, sh, maxF);
        type = t;
        hp = h;
        attack = a;
    }
    
    /**
     * returns JLabel of Zombie sprite
     * @return JLabel containing Zombie sprite
     */
    public JLabel getZombieLabel(){
        return zombieLabel;
    }
    /**
     * sets Zombie's JLabel
     * @param l new JLabel
     */
    public void setZombieLabel(JLabel l){
        zombieLabel = l;
    }
    /**
     * sets Zombie's move interval
     * @param i new update count interval
     */
    public void setMoveInterval(int i){
        moveInterval = i;
    }
    /**
     * increases move interval by 1
     */
    public void incMoveInterval(){
        moveInterval++;
    }
    /**
     * returns hit points of Zombie
     * @return hit points of Zombie
     */
    public int getHP(){
        return hp;
    }
    /**
     * sets hit points of Zombie
     * @param h new hit points of Zombie
     */
    public void setHP(int h){
        hp = h;
    }
    /**
     * returns Zombie's move interval
     * @return Zombie's current move interval
     */
    public int getMoveInterval(){
        return moveInterval;
    }
    
    /**
     * add zombies to ArrayList usedZombies
     * @param z To be added and used as Zombie Instances
     */
    public static void addUsedZombies(Zombie z){
        usedZombies.add(z);
    }
    /**
     * return ArrayList of usedZombies
     * @return ArrayList of usedZombies
     */
    public static ArrayList getUsedZombies(){
        return usedZombies;
    }
}
