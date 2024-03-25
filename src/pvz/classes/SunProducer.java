/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

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
    public SunProducer(int h, int c, int s, String f){
        super(h, c, f);
        sunProduced = s;
    }
    
    public void generateSun(){
        sun += sunProduced;
    }
    
    public int getSunProduced(){
        return sunProduced;
    }
}
