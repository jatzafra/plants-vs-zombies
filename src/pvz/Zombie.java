/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Lenovo
 */
public class Zombie extends Entity {
    private String type;
    private int hp;
    private int atk;
    private Plant target;
    
    public Zombie(String t, int h, int a, int s){
        super(s);
        type = t;
        hp = h;
        atk = a;
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
        if(target != null && target.getHP() > 0){
            if(target.getHP() > atk){
                target.setHP(target.getHP() - atk);
            }
            else{
                //target Plant dies
                Tile.removeEntity(target, xCoord, yCoord);
                System.out.println("Zombie " + this + " has eaten Plant "+ target);
            }
        }
    }
}
