/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * this class creates an instance of an Entity called a Plant
 * @author Bella Buyco
 */
public abstract class Plant extends Entity{
    /**
     * an int referring to how much health or hp the Plant has
     */
    protected int hp;
    /**
     * how much sun it costs to use the Plant
     */
    protected int sunCost;
    /**
     * static value wherein sun = 0
     */
    protected static int sun = 0;
    /**
     * an arrayList of the used Plants
     */
    protected static ArrayList<Plant> usedPlants = new ArrayList<>();
    
    /**
     * constructor method for Plant
     * @param h hit points for Plant
     * @param c sun cost of Plant
     * @param sw sprite width of Plant
     * @param sh sprite height of Plant
     * @param maxF max animation frames of Plant
     */
    public Plant(int h, int c, int sw, int sh, int maxF){
        super(0, sw, sh, maxF);
        hp = h;
        sunCost = c;
    }
    /**
     * constructor method for Plant
     * @param h hit points of Plant
     * @param c sun cost of Plant
     * @param f image file name for Plant sprite
     * @param sw sprite width of Plant
     * @param sh sprite height of Plant
     * @param maxF max animation frame of Plant
     */
    public Plant(int h, int c, String f, int sw, int sh, int maxF){
        super(0, f, sw, sh, maxF);
        hp = h;
        sunCost = c;
    }
        
    /**
     * sets the hp of a Plant
     * @param h new hp of Plant
     */
    public void setHP(int h){
        hp = h;
    }    
    /**
     * sets the sunCost of a Plant
     * @param c new sunCost of Plant
     */
    public void setSunCost(int c){
        sunCost = c;
    }
    /**
     * sets the sun value
     * @param s new sun value
     */
    public void setSun(int s){
        sun = s;
    }
    /**
     * adds a Plant to usedPlants arrayList
     * @param p Plant to add
     */
    public static void addUsedPlants(Plant p){
        usedPlants.add(p);
    } 
    /**
     * gets the hp of Plant
     * @return hp
     */
    public int getHP(){
        return hp;
    }    
    /**
     * gets the sunCost of Plant
     * @return sunCost
     */
    public int getSunCost(){
        return sunCost;
    }    
    /**
     * gets the sun value
     * @return sun
     */
    public static int getSun(){
        return sun;
    }    
    /**
     * gets the arrayList of usedPlants
     * @return usedPlants
     */
    public static ArrayList getUsedPlants(){
        return usedPlants;
    }
}
