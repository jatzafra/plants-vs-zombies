/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Lenovo
 */
public class Zombie extends Entity {
    private String type;
    private int hp;
    private int atk;
    private Plant target;
    private int moveInterval;
    private JLabel zombieLabel;
    protected static ArrayList<Zombie> usedZombies = new ArrayList<>();
    
    public Zombie(String t, int h, int a, double s, String f, int sw, int sh, int maxF){
        super(s, f, sw, sh, maxF);
        type = t;
        hp = h;
        atk = a;
    }
    
    public JLabel getZombieLabel(){
        return zombieLabel;
    }
    public void setZombieLabel(JLabel l){
        zombieLabel = l;
    }
    public void setMoveInterval(int i){
        moveInterval = i;
    }
    public void incMoveInterval(){
        moveInterval++;
    }
    public int getHP(){
        return hp;
    }
    public void setHP(int h){
        hp = h;
    }
    public int getMoveInterval(){
        return moveInterval;
    }
    
    public void targetPlant(){
        Plant p = Tile.getPlant(xCoord, yCoord);
        if(p != null){
            target = p;
        }
    }
    
    public void eatPlant(){
//        if(target != null && target.getHP() > 0){
//            if(target.getHP() > atk){
//                target.setHP(target.getHP() - atk);
//            }
//            else{
//                //target Plant dies
//                target.setHP(0);
//                Tile.removeEntity(target, xCoord, yCoord);
//                System.out.println("Zombie has eaten plant."); //removable
//            }
//        }
    }
    
    public static void addUsedZombies(Zombie z){
        usedZombies.add(z);
    }
    
    public static ArrayList getUsedZombies(){
        return usedZombies;
    }
}
