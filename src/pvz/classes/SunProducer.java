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
    
    public SunProducer(int h, int c, int s, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
        sunProduced = s;
    }
    public SunProducer(int h, int c, int s, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
        sunProduced = s;
    }
    
    public void generateSun(){
        sun += sunProduced;
    }
    
    public int getSunProduced(){
        return sunProduced;
    }
}
