/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Plant;

/**
 *
 * @author Bella Buyco
 */
public class Defense extends Plant{
    
    public Defense(int h, int c, int sw, int sh, int maxF){
        super(h, c, sw, sh, maxF);
    }
    public Defense(int h, int c, String f, int sw, int sh, int maxF){
        super(h, c, f, sw, sh, maxF);
    }
}
