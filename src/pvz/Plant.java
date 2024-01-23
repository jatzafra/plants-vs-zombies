/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Bella Buyco
 */
public abstract class Plant extends Entity{
    protected int hp;
    protected int sunCost;
    protected static int sun = 0;
    
    public Plant(int h, int c){
        super(0);
        hp = h;
        sunCost = c;
    }
}
