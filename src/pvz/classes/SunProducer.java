/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;
/**
 * Plant subclass that produces sun
 * @author Lenovo
 */
public class SunProducer extends Plant{
    /**
     * the amount of sun a SunProducer generates
     */
    private int sunProduced;
    
    /**
     * constructor class of SunProducer
     * @param h hit points of SunProducer
     * @param c sun cost of SunProducer
     * @param s speed of SunProducer
     * @param sw sprite width of SunProducer
     * @param sh sprite height of SunProducer
     * @param maxF max frame in sprite sheet of SunProducer
     */
    public SunProducer(int h, int c, int s, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
        sunProduced = s;
    }
    /**
     * constructor class of SunProducer
     * @param h hit points of SunProducer
     * @param c sun cost of SunProducer
     * @param s speed of SunProducer
     * @param f image filename of SunProducer
     * @param sw sprite width of SunProducer
     * @param sh sprite height of SunProducer
     * @param maxF max frame in sprite sheet of SunProducer
     */
    public SunProducer(int h, int c, int s, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
        sunProduced = s;
    }
    
    /**
     * increase sun based on sunProduced
     */
    public void generateSun(){
        sun += sunProduced;
    }
    /**
     * return sunProduced by SunProducer
     * @return sunProduced field
     */
    public int getSunProduced(){
        return sunProduced;
    }
}
