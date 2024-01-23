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
        u = chargeUp;
        a = active;
        t = type;
    }
    
    public void explode(){
        // insert code here
    }
}
