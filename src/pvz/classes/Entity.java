/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Tile;
import pvz.classes.Zombie;
import pvz.exceptions.GameOverException;
import pvz.screens.GamePanel;

/**
 *
 * @author Julian Zafra
 */
public abstract class Entity {
    /**
     * this class creates an instance of an Entity which can be a Plant, Projectile, or Zombie
     */
    
    /**
     * int values referring to pixel by pixel measurements
     * absoluteY and yCoord are very similar 
     */
    private int absoluteX, absoluteY;
    /**
     * refers to the coordinates of an Entity with respect to the grid
     */
    protected int xCoord, yCoord;
    /**
     * refers to the speed at which Entity traverses the grid
     */
    protected double speed; // squares per second (has direction [+/-])
//    protected String id;
    
    /**
     * refers to the file name for the sprite
     */
    protected String imgFilename;
    /**
     * a spriteSheet for the animations of the different Entities
     */
    protected SpriteSheet spriteSheet;
    /**
     * the following set the height and width of the Entity sprites
     */
    protected int spriteWidth;
    protected int spriteHeight;
    /**
     * max sprites in a spritesheet 
     */
    protected int maxAnimFrame;
    /**
     * refers to a specific frame of animation from the spriteSheet
     */
    protected int animFrame;
    /**
     *  interval of frames between each frame change
     */
    protected int frameInterval; // contains frames elapsed after animFrame is updated
    /**
     * creates an instance of a gamePanel
     */
    private static GamePanel gamePanel;
    
    /**
     * constructor methods for Entity
     */
    public Entity(double s, int sw, int sh, int maxF){
        speed = s;
        spriteWidth = sw;
        spriteHeight = sh;
        maxAnimFrame = maxF;
        animFrame = 1;
        frameInterval = 0;
    }
    
    public Entity(double s, String f, int sw, int sh, int maxF){
        speed = s;
        imgFilename = f;
        spriteWidth = sw;
        spriteHeight = sh;
        maxAnimFrame = maxF;
        animFrame = 1;
        frameInterval = 0;
    }
    
    /**
     * sets the gamePanel 
     * @return null
     */
    public static void setGamePanel(GamePanel gp){
        gamePanel = gp;
    }
    /**
     * returns the gamePanel
     * @return gamePanel
     */
    public static GamePanel getGamePanel(){
        return gamePanel;
    }
    /**
     * sets the x coordinate of the Entity
     * @param x
     * @return null
     */
    public void setX(int x){
        xCoord = x;
    }
    /**
     * sets the y coordinate of the Entity
     * @param y
     * @return null
     */
    public void setY(int y){
        yCoord = y;
    }
    /**
     * sets the x and y coordinates of an Entity
     * @param x, y
     * @return null
     */
    public void setCoords(int y, int x){
        xCoord = x;
        yCoord = y;
    }
    /**
     * sets the speed of the Entity
     * @param s
     * @return null
     */
    public void setSpeed(int s){
        speed = s;
    }
    /**
     * sets the SpriteSheet of the Entity
     * @param s
     * @return null
     */
    public void setSpriteSheet(SpriteSheet s){
        spriteSheet = s;
    }
    /**
     * sets the width of the Entity's sprite
     * @param w
     * @return null
     */
    public void setSpriteWidth(int w){
        spriteWidth = w;
    }
    /**
     * sets the height of the Entity's sprite
     * @param h
     * @return null
     */
    public void setSpriteHeight(int h){
        spriteWidth = h;
    }
    /**
     * sets the animation frame of the Entity
     * @param f
     * @return null
     */
    public void setAnimFrame(int f){
        animFrame = f;
    }
    /**
     * increases the animation frame of the Entity if it is less than the max animation frame
     * else, the animation frame will be = 1
     * @return null
     */
    public void incAnimFrame(){ // when greater than or equal to max sprite frames in spritesheet, sets back to 1
        if(animFrame < maxAnimFrame){
            animFrame++;
        }
        else{
            animFrame = 1;
        }
    }
    /**
     * sets the frameInterval of the Entity
     * @param i
     * @return null
     */
    public void setFrameInterval(int i){
        frameInterval = i;
    }
    /**
     * increases the frameInterval of an Entity
     * @return null
     */
    public void incFrameInterval(){
        frameInterval++;
    }
    /**
     * sets the value of the maxAnimFrame of an Entity
     * @param mf
     * @return null
     */
    public void setMaxAnimFrame(int mf){
        maxAnimFrame = mf;
    }
    /**
     * gets an Entity's speed
     * @return speed
     */
    public double getSpeed(){
        return speed;
    }
    /**
     * gets an Entity's x coordinate
     * @return xCoord
     */
    public int getX(){
        return xCoord;
    }
    /**
     * gets an Entity's y coordinate
     * @return yCoord
     */
    public int getY(){
        return yCoord;
    }
    /**
     * gets an Entity's absoluteX value
     * @return absoluteX
     */
    public int getAbsoluteX(){
        return absoluteX;
    }
    /**
     * gets an Entity's absoluteY value
     * @return absoluteY
     */
    public int getAbsoluteY(){
        return absoluteY;
    }
    /**
     * sets an Entity's absoluteX value
     * @param x
     * @return null
     */
    public void setAbsoluteX(int x){
        absoluteX = x;
    }
    /**
     * sets an Entity's absoluteY value
     * @param y
     * @return null
     */
    public void setAbsoluteY(int y){
        absoluteY = y;
    }
    /**
     * sets an Entity's absolute coordinate values
     * @param x, y
     * @return null
     */
    public void setAbsoluteCoords(int y, int x){
        absoluteY = y;
        absoluteX = x;
    }
    /**
     * gets the Entity's imgFileName
     * @return imgFileName
     */
    public String getImgFilename(){
        return imgFilename;
    }
    /**
     * gets the Entity's SpriteSheet
     * @return spriteSheet
     */
    public SpriteSheet getSpriteSheet(){
        return spriteSheet;
    }
    /**
     * gets the Entity's sprite width
     * @return spriteWidth
     */
    public int getSpriteWidth(){
        return spriteWidth;
    }
    /**
     * gets the Entity's sprite height
     * @return spriteHeight
     */
    public int getSpriteHeight(){
        return spriteHeight;
    }
    /**
     * gets the Entity's animation frame
     * @return animFrame
     */
    public int getAnimFrame(){
        return animFrame;
    }
    /**
     * gets the Entity's frame interval
     * @return frameInterval
     */
    public int getFrameInterval(){
        return frameInterval;
    }
    /**
     * gets the max animation frame of the Entity
     * @return maxAnimFrame
     */
    public int getMaxAnimFrame(){
        return maxAnimFrame;
    }
    
    /**
     * method that allows an Entity to move across the tiles of the lawn
     * @throws GameOverException 
     */
    public void move() throws GameOverException{
        if(speed < 0){
//            if(this instanceof Zombie && xCoord == 0){
//                System.out.println("GAMEOVER");
//                throw new GameOverException();
//            }
//            
//            int oldXCoord = xCoord, oldYCoord = yCoord;
//            int newXCoord = xCoord - 1, newYCoord = yCoord;
//            
//            Tile.removeEntity(this, xCoord, yCoord);
//            Tile.addEntity(this, newXCoord, newYCoord);
//            
//            // Update 'zCoord' values of Entities that shifted downwards due to removal
//            for(int i = 0; i < Tile.getEntities(oldXCoord, oldYCoord).size(); i++){
//                Tile.getEntities(oldXCoord, oldYCoord).get(i).setZ(i);
//            }
            
        } else if(speed > 0){
            
//            int oldXCoord = xCoord, oldYCoord = yCoord;
//            int newXCoord = xCoord + 1, newYCoord = yCoord;
//            
//            Tile.removeEntity(this, xCoord, yCoord);
//            Tile.addEntity(this, newXCoord, newYCoord);
//            
//            // Update 'zCoord' values of Entities that shifted downwards due to removal
//            for(int i = 0; i < Tile.getEntities(oldXCoord, oldYCoord).size(); i++){
//                Tile.getEntities(oldXCoord, oldYCoord).get(i).setZ(i);
//            }
        }
    }
    
}
