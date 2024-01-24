/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Lenovo
 */
public abstract class Entity {
    protected int speed, xCoord, yCoord, zCoord;
    
    public Entity(int s){
        speed = s;
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
    
    public int getX(){
        return xCoord;
    }
    public int getY(){
        return yCoord;
    }
    public int getZ(){
        return zCoord;
    }
    
    public void move() throws GameOverException{
        if(speed < 0){
            if(this instanceof Zombie && xCoord == 0){
                System.out.println("GAMEOVER");
                throw new GameOverException;
            }
            
            int oldXCoord = xCoord, oldYCoord = yCoord;
            int newXCoord = xCoord--, newYCoord = yCoord;
            
            Tile.removeEntity(this, xCoord, yCoord);
            Tile.addEntity(this, newXCoord, newYCoord);
            
            // Update 'zCoord' values of Entities that shifted downwards due to removal
            for(int i = 0; i < Tile.getEntities(oldXCoord, oldYCoord).size(); i++){
                Tile.getEntities(oldXCoord, oldYCoord).get(i).setZ(i);
            }
            
        } else if(speed > 0){
            
            int oldXCoord = xCoord, oldYCoord = yCoord;
            int newXCoord = xCoord++, newYCoord = yCoord;
            
            Tile.removeEntity(this, xCoord, yCoord);
            Tile.addEntity(this, newXCoord, newYCoord);
            
            // Update 'zCoord' values of Entities that shifted downwards due to removal
            for(int i = 0; i < Tile.getEntities(oldXCoord, oldYCoord).size(); i++){
                Tile.getEntities(oldXCoord, oldYCoord).get(i).setZ(i);
            }
        }
    }
}
