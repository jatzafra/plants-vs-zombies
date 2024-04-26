/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Bella Buyco
 */
public abstract class Plant extends Entity{
    protected int hp;
    protected int sunCost;
    protected String imgFilename;
    protected SpriteSheet spriteSheet;
    protected int spriteWidth;
    protected int spriteHeight;
    protected static int sun = 0;
    protected static ArrayList<Plant> usedPlants = new ArrayList<>();
    
    public Plant(int h, int c, int sw, int sh){
        super(0);
        hp = h;
        sunCost = c;
        spriteWidth = sw;
        spriteHeight = sh;
    }
    public Plant(int h, int c, String f, int sw, int sh){
        super(0);
        hp = h;
        sunCost = c;
        imgFilename = f;
        spriteWidth = sw;
        spriteHeight = sh;
    }
    
    public int getHP(){
        return hp;
    }    
    public int getSunCost(){
        return sunCost;
    }    
    public String getImgFilename(){
        return imgFilename;
    }
    public SpriteSheet getSpriteSheet(){
        return spriteSheet;
    }
    public int getSpriteWidth(){
        return spriteWidth;
    }
    public int getSpriteHeight(){
        return spriteHeight;
    }
    public static int getSun(){
        return sun;
    }    
    public static ArrayList getUsedPlants(){
        return usedPlants;
    }
    public void setHP(int h){
        hp = h;
    }    
    public void setSunCost(int c){
        sunCost = c;
    }    
    public void setImgFilename(String f){
        imgFilename = f;
    }
    public void setSun(int s){
        sun = s;
    }
    public void setSpriteSheet(SpriteSheet s){
        spriteSheet = s;
    }
    public void setSpriteWidth(int w){
        spriteWidth = w;
    }
    public void setSpriteHeight(int h){
        spriteWidth = h;
    }
    public static void addUsedPlants(Plant p){
        usedPlants.add(p);
    }
}
