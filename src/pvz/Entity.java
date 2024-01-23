/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Lenovo
 */
public abstract class Entity {
    protected int speed;
    protected int xCoord;
    protected int yCoord;
    
    public Entity(int s){
        speed = s;
    }
}
