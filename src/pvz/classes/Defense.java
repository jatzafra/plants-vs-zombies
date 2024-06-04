/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Plant;

/**
 *
 * @author Bella Buyco
 * a class that creates an instance of a Defense type of Plant
 */
public class Defense extends Plant{
    /**
     * constructor method for the Defense class
     */
    public Defense(int h, int c, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
    }
    /**
     * constructor method for the Defense class with f input
     */
    public Defense(int h, int c, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
    }
}
