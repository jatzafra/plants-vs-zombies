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
    private static ArrayList<Plant> plantList = new ArrayList<>();
    private static ArrayList<Zombie> zombieList = new ArrayList<>();
    private static ArrayList<Projectile> projectileList = new ArrayList<>();
    
    static{
        tileArray = new ArrayList[Tile.xLength][Tile.yLength];
        for(int x = 0; x < Tile.xLength; x++){
            for(int y = 0; y < Tile.yLength; y++){
                tileArray[x][y] = new ArrayList<>();
            }
        }
    }
    
    public static void addEntity(Entity e, int x, int y){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            Tile.getEntities(x, y).add(e);

            int z = Tile.getEntities(x, y).indexOf(e);
            
            e.setCoords(x, y, z);
            
            if(e instanceof Plant){
                plantList.add((Plant) e);
            } else if(e instanceof Zombie){
                zombieList.add((Zombie) e);
            } else if(e instanceof Projectile){
                projectileList.add((Projectile) e);
            }
        }
    }
    
    public static void removeEntity(Entity e, int x, int y){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            if(Tile.getEntities(x, y) != null && Tile.getEntities(x, y).contains(e)){
                Tile.getEntities(x, y).remove(e);
                
                e.setCoords(-1, -1, -1); // Signifies that Entity e is removed from tileArray entirely
                
                // Update 'zCoord' values of Entities that shifted downwards due to removal
                for(int i = 0; i < Tile.getEntities(x, y).size(); i++){
                    Tile.getEntities(x, y).get(i).setZ(i);
                }
                
                if(e instanceof Plant){
                    plantList.remove((Plant) e);
                } else if(e instanceof Zombie){
                    zombieList.remove((Zombie) e);
                } else if(e instanceof Projectile){
                    projectileList.remove((Projectile) e);
                }
            }
        }
    }
    
    public static ArrayList<Entity> getEntities(int x, int y){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength) {
            return tileArray[x][y];
        }
        return null;
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
    
    public static Zombie getFirstZombieInTile(int x, int y){ 
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
    public static ArrayList<Zombie> getAllZombiesInTile(int x, int y){ 
        ArrayList<Entity> entities = getEntities(x, y);
        ArrayList<Zombie> zombies = new ArrayList<>();
        if(entities != null) {
            for(Entity e : entities){
                if(e instanceof Zombie){
                    zombies.add((Zombie) e);
                    // returns ArrayList of all Zombies in given tile
                }
            }
            return zombies;
        }
        return new ArrayList<>(); //empty ArrayList
    }
    
    public static void moveAllZombies() throws GameOverException{
        for(int i = zombieList.size() - 1; i >= 0; i--){ /* Iterates through list in reverse order 
                                                            to avoid index-shifting problems */
            zombieList.get(i).move();
        }
    }
    public static void moveAllProjectiles() throws GameOverException{
        for(int i = projectileList.size() - 1; i >= 0; i--){ /* Iterates through list in reverse order 
                                                                to avoid index-shifting problems */
            projectileList.get(i).move();
        }
    }
    public static void hitAllProjectiles(){
        for(int i = projectileList.size() - 1; i >= 0; i--){ /* Iterates through list in reverse order 
                                                                to avoid index-shifting problems */
            projectileList.get(i).hit();
        }
    }
}
