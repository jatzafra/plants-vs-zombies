/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Plant;

/**
 * a class that creates a Bomb type of Plant
 * @author Bella Buyco
 */
public class Bomb extends Plant{
    /**
     * refers to the type of Bomb it is (instant or requires chargeUp)
     */
    private String type;
    /**
     * no. of integer seconds before Bomb is active
     */
    private int chargeUp;
    /**
     * boolean value referring to whether the Bomb can be detonated or not
     */
    private boolean active;
    
    /**
     * constructor method for Bomb class
     * @param h hit points for Bomb
     * @param c sun cost of Bomb
     * @param u chargeUp of Bomb
     * @param a active value of Bomb
     * @param t type of Bomb
     * @param sw sprite width of Bomb
     * @param sh sprite height of Bomb
     * @param maxF max frame animations of Bomb
     */
    public Bomb(int h, int c, int u, boolean a, String t, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
        chargeUp = u;
        active = a;
        type = t;
    }
    /**
     * constructor method for Bomb class
     * @param h hit points for Bomb
     * @param c sun cost of Bomb
     * @param u chargeUp of Bomb
     * @param a active value of Bomb
     * @param t type of Bomb
     * @param f image file name for Bomb's sprites
     * @param sw sprite width of Bomb
     * @param sh sprite height of Bomb
     * @param maxF max frame animations of Bomb
     */
    public Bomb(int h, int c, int u, boolean a, String t, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
        chargeUp = u;
        active = a;
        type = t;
    }
    
    
    /**
     * this method makes "active" true if the Bomb is an insta type or if there is a nearby Zombie
     */
    public void activate(){
//        if(Tile.getFirstZombieInTile(this.getX(), this.getY()) != null || type == "insta"){
//            active = true;
//        }
    }
    
    /**
     * this method allows the Bomb to detonate and kill all zombies within a range if it is active
     */
    public void explode(){ 
//        if(active){
//            for(Zombie z : Tile.getAllZombiesInTile(this.getX(), this.getY())) {
//                z.setHP(0);
//                Tile.removeEntity(z, z.getX(), z.getY());
//            }
//            Tile.removeEntity(this, this.getX(), this.getY());
//        }
    } 
    
    /**
     * gets the chargeUp value of the Bomb
     * @return chargeUp
     */
    public int getChargeUp(){
        return chargeUp;
    }
    
    /**
     * gets the value of "active" field 
     * @return active
     */
    public boolean getActive(){
        return active;
    }
    
    /**
     * gets the type of the Bomb
     * @return type
     */
    public String getType(){
        return type;
    }
}