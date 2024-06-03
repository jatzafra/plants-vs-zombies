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
    private int absoluteX, absoluteY;
    private String type;
    private int hp;
    private int atk;
    private Plant target;
    private JLabel zombieLabel;
    protected static ArrayList<Zombie> usedZombies = new ArrayList<>();
    
    public Zombie(String t, int h, int a, float s, String f, int sw, int sh, int maxF){
        super(s, f, sw, sh, maxF);
        type = t;
        hp = h;
        atk = a;
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
    public JLabel getZombieLabel(){
        return zombieLabel;
    }
    public void setZombieLabel(JLabel l){
        zombieLabel = l;
    }
    public int getHP(){
        return hp;
    }
    public void setHP(int h){
        hp = h;
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
