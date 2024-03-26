/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Zombie;
import pvz.exceptions.GameOverException;
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
        tileArray = new ArrayList[Tile.yLength][Tile.xLength];
        for(int y = 0; y < Tile.yLength; y++){
            for(int x = 0; x < Tile.xLength; x++){
                tileArray[y][x] = new ArrayList<>();
            }
        }
    }
    
    public static void clearAllEntities(){
        for(int i = plantList.size() - 1; i >= 0; i--){ 
            Plant plant = plantList.get(i);
            Tile.removeEntity(plant, plant.getY(), plant.getX());
        }
        for(int i = zombieList.size() - 1; i >= 0; i--){ 
            Zombie zombie = zombieList.get(i);
            Tile.removeEntity(zombie, zombie.getY(), zombie.getX());
        }
        for(int i = projectileList.size() - 1; i >= 0; i--){ 
            Projectile projectile = projectileList.get(i);
            Tile.removeEntity(projectile, projectile.getY(), projectile.getX());
        }
    }
    
    public static void addEntity(Entity e, int y, int x){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            Tile.getEntities(y, x).add(e);

            int z = Tile.getEntities(y, x).indexOf(e);
            
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
    
    public static void removeEntity(Entity e, int y, int x){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            if(Tile.getEntities(y, x) != null && Tile.getEntities(y, x).contains(e)){
                Tile.getEntities(y, x).remove(e);
                
                e.setCoords(-1, -1, -1); // Signifies that Entity e is removed from tileArray entirely
                
                // Update 'zCoord' values of Entities that shifted downwards due to removal
                for(int i = 0; i < Tile.getEntities(y, x).size(); i++){
                    Tile.getEntities(y, x).get(i).setZ(i);
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
    
    public static ArrayList<Entity> getEntities(int y, int x){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength) {
            return tileArray[y][x];
        }
        return null;
    }
    
    public static Plant getPlant(int y, int x){
        ArrayList<Entity> entities = getEntities(y, x);
        if(entities != null) {
            for(Entity e : entities){
                if(e instanceof Plant){
                    return(Plant) e;
                }
            }
        }
        return null;
    }
    
    public static Zombie getFirstZombieInTile(int y, int x){ 
        ArrayList<Entity> entities = getEntities(y, x);
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
    public static ArrayList<Zombie> getAllZombiesInTile(int y, int x){ 
        ArrayList<Entity> entities = getEntities(y, x);
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
    public static void shootAllShooters(){
        for(int i = plantList.size() - 1; i >= 0; i--){ 
            Plant plant = plantList.get(i);
            if(plant instanceof Shooter){
                Shooter shooter = (Shooter) plant;
                shooter.shoot();
            }
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
