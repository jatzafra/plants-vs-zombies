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
    protected int speed, xCoord, yCoord, zCoord;
    
    public Entity(int s){
        speed = s;
    }
    
    public void setX(int x){
        xCoord = x;
    }
    public void setY(int y){
        yCoord = y;
    }
    public void setZ(int z){
        zCoord = z;
    }
    
    public void setCoords(int x, int y, int z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    
    public int getX(){
        return xCoord;
    }
    public int getY(){
        return yCoord;
    }
    public int getZ(){
        return zCoord;
    }
}
