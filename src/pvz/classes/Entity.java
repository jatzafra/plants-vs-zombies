/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Tile;
import pvz.classes.Zombie;
import pvz.exceptions.GameOverException;

/**
 *
 * @author Lenovo
 */
public abstract class Entity {
    protected int speed, xCoord, yCoord, zCoord;
//    protected String id;
    protected String imgFilename;
    protected SpriteSheet spriteSheet;
    protected int spriteWidth;
    protected int spriteHeight;
    protected int maxAnimFrame;
    protected int animFrame;
    protected int frameInterval; // contains frames elapsed after animFrame is updated
    
    public Entity(int s, int sw, int sh, int maxF){
        speed = s;
        spriteWidth = sw;
        spriteHeight = sh;
        maxAnimFrame = maxF;
        animFrame = 1;
        frameInterval = 0;
    }
    
    public Entity(int s, String f, int sw, int sh, int maxF){
        speed = s;
        imgFilename = f;
        spriteWidth = sw;
        spriteHeight = sh;
        maxAnimFrame = maxF;
        animFrame = 1;
        frameInterval = 0;
    }
    
    public void setX(int x){
        xCoord = x;
    }
    public void setY(int y){
        yCoord = y;
    }
    public void setZ(int z){
        zCoord = z;
    }
    public void setCoords(int x, int y, int z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
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
    public void setAnimFrame(int f){
        animFrame = f;
    }
    public void incAnimFrame(){ // when greater than or equal to max sprite frames in spritesheet, sets back to 1
        if(animFrame < maxAnimFrame){
            animFrame++;
        }
        else{
            animFrame = 1;
        }
    }
    public void setFrameInterval(int i){
        frameInterval = i;
    }
    public void incFrameInterval(){
        frameInterval++;
    }
    public void setMaxAnimFrame(int mf){
        maxAnimFrame = mf;
    }
    
    public int getX(){
        return xCoord;
    }
    public int getY(){
        return yCoord;
    }
    public int getZ(){
        return zCoord;
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
    public int getAnimFrame(){
        return animFrame;
    }
    public int getFrameInterval(){
        return frameInterval;
    }
    public int getMaxAnimFrame(){
        return maxAnimFrame;
    }
    
    public void move() throws GameOverException{
        if(speed < 0){
            if(this instanceof Zombie && xCoord == 0){
                System.out.println("GAMEOVER");
                throw new GameOverException();
            }
            
            int oldXCoord = xCoord, oldYCoord = yCoord;
            int newXCoord = xCoord - 1, newYCoord = yCoord;
            
            Tile.removeEntity(this, xCoord, yCoord);
            Tile.addEntity(this, newXCoord, newYCoord);
            
            // Update 'zCoord' values of Entities that shifted downwards due to removal
            for(int i = 0; i < Tile.getEntities(oldXCoord, oldYCoord).size(); i++){
                Tile.getEntities(oldXCoord, oldYCoord).get(i).setZ(i);
            }
            
        } else if(speed > 0){
            
            int oldXCoord = xCoord, oldYCoord = yCoord;
            int newXCoord = xCoord + 1, newYCoord = yCoord;
            
            Tile.removeEntity(this, xCoord, yCoord);
            Tile.addEntity(this, newXCoord, newYCoord);
            
            // Update 'zCoord' values of Entities that shifted downwards due to removal
            for(int i = 0; i < Tile.getEntities(oldXCoord, oldYCoord).size(); i++){
                Tile.getEntities(oldXCoord, oldYCoord).get(i).setZ(i);
            }
        }
    }
}
