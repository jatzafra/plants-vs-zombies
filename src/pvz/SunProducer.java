/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Bella Buyco
 */
 

public class SunProducer extends Plant{
    private int sunProduced;
    
    public SunProducer(int h, int c, int s){
        super(h, c);
        sunProduced = s;
    }
    
    public void generateSun(){
        sun += sunProduced;
    }
}
