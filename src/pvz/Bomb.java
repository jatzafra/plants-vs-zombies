/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Bella Buyco
 */
public class Bomb extends Plant{
    private String type;
    private int chargeUp;
    private boolean active;
    
    public Bomb(int h, int c, int u, boolean a, String t){
        super(h, c);
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
            //JULIANNNN pacheck nito this one has an error for me fsr (sa line above)
        }
    } 
}