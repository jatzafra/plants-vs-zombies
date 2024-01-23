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
    Timer chargeUp = new Timer();
    private int timeInterval = 10 * 1000;
    
    public void generateSun(){
        sun += 50;
    }
}
