/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Tile {
    private static int xLength = 9;
    private static int yLength = 5;
            
    private static ArrayList<Entity>[][] tileArray;
    
    static{
        tileArray = new ArrayList[Tile.xLength][Tile.yLength];
    }
    
    public static void addEntity(Entity e, int x, int y){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            Tile.getEntities(x, y).add(e);

            int z = Tile.getEntities(x, y).indexOf(e);
            
            e.setCoords(x, y, z);
        }
    }
    public static ArrayList<Entity> getEntities(int x, int y){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength) {
            return tileArray[x][y];
        }
        return null;
    }
    
    public static void removeEntity(Entity e, int x, int y){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            if(Tile.getEntities(x, y) != null && Tile.getEntities(x, y).contains(e)){
                Tile.getEntities(x, y).remove(e);
                e.setCoords(-1, -1, -1); // Signifies that Entity e is removed from tileArray entirely
            }
        }
    }
    public static Plant getPlant(int x, int y){
        ArrayList<Entity> entities = getEntities(x, y);
        if(entities != null) {
            for(Entity e : entities){
                if(e instanceof Plant){
                    return(Plant) e;
                }
            }
        }
        return null;
    }
    public static Zombie getFirstZombie(int x, int y){ 
        ArrayList<Entity> entities = getEntities(x, y);
        if(entities != null) {
            for(Entity e : entities){
                if(e instanceof Zombie){
                    return (Zombie) e;
                    // returns first Zombie found in ArrayList
                    // also Zombie with lowest index in that ArrayList
                }
            }
        }
        return null;
    }
    public static ArrayList<Zombie> getAllZombies(int x, int y){ 
        ArrayList<Entity> entities = getEntities(x, y);
        ArrayList<Zombie> zombies = null;
        if(entities != null) {
            for(Entity e : entities){
                if(e instanceof Zombie){
                    zombies.add((Zombie) e);
                    // returns ArrayList of all Zombies in given tile
                }
            }
            return zombies;
        }
        return null;
    }
    
}
