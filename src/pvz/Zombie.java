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
    
    public Zombie(String t, int h, int a, int s){
        super(s);
        type = t;
        hp = h;
        atk = a;
    }
    
    public void eatPlant(){
        
    }
}
