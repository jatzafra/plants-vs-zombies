/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Plant;
import pvz.classes.Tile;
import pvz.classes.Zombie;

/**
 *
 * @author Bella Buyco
 */
public class Bomb extends Plant{
    private String type;
    private int chargeUp;
    private boolean active;
    
    public Bomb(int h, int c, int u, boolean a, String t, int sw, int sh){
        super(h, c, sw, sh);
        chargeUp = u;
        active = a;
        type = t;
    }
    public Bomb(int h, int c, int u, boolean a, String t, String f, int sw, int sh){
        super(h, c, f, sw, sh);
        chargeUp = u;
        active = a;
        type = t;
    }
    
    public void activate(){
        if(Tile.getFirstZombieInTile(this.getX(), this.getY()) != null || type == "insta"){
            active = true;
        }
    }
    
    public void explode(){ 
        if(active){
            for(Zombie z : Tile.getAllZombiesInTile(this.getX(), this.getY())) {
                z.setHP(0);
                Tile.removeEntity(z, z.getX(), z.getY());
            }
            Tile.removeEntity(this, this.getX(), this.getY());
        }
    } 
    
    public int getChargeUp(){
        return chargeUp;
    }
    public boolean getActive(){
        return active;
    }
    public String getType(){
        return type;
    }
}