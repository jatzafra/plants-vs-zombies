/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Plant;

/**
 * a class that creates an instance of a Defense type of Plant
 * @author Bella Buyco
 */
public class Defense extends Plant{
    /**
     * constructor method for Defense class
     * @param h hit points for Defense
     * @param c sun cost for Defense
     * @param sw sprite width for Defense
     * @param sh sprite height for Defense
     * @param maxF max animation frames for Defense
     */
    public Defense(int h, int c, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
    }
    /**
     * constructor method for Defense class
     * @param h hit points for Defense
     * @param c sun cost for Defense
     * @param f image file name for Defense sprites
     * @param sw sprite width for Defense
     * @param sh sprite height for Defense
     * @param maxF max animation frames for Defense
     */
    public Defense(int h, int c, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
    }
}
