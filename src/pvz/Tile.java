/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

/**
 *
 * @author Lenovo
 */
public class Tile {
    private int xLength;
    private int yLength;
    
    private Entity[][] tiles;
    
    public Tile(int x, int y){
        xLength = x;
        yLength = y;
        tiles = new Entity[x][y]; 
   }
    
    public void setEntity(Entity e, int x, int y){
        if(x >= 0 && x <= xLength && y >= 0 && y <= yLength){
            tiles[x][y] = e;
            e.setCoords(x, y);
        }
    }
    public Entity getEntity(int x, int y){
        if (x >= 0 && x < xLength && y >= 0 && y < yLength) {
            return tiles[x][y];
        }
        return null;
    }
    
}
