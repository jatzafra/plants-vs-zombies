/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import pvz.classes.Zombie;
import pvz.exceptions.GameOverException;
import java.util.ArrayList;

/**
 * Handles fields regarding the game board itself such as adding and removing Entities
 * @author Lenovo
 */
public class Tile {
    /**
     * number of tiles in the board in the x-direction
     */
    private static int xLength = 9;
    /**
     * number of tiles in the board in the y-direction
     */
    private static int yLength = 5;
           
    /**
     * 2d array of tiles
     */
    private static Entity[][] tileArray = new Entity [Tile.yLength][Tile.xLength];;
    /**
     * list of entities bound to only absolute coordinates
     */
    private static ArrayList<Entity> absoluteEntityList = new ArrayList<>();
    /**
     * list of all existing plants
     */
    private static ArrayList<Plant> plantList = new ArrayList<>();
    /**
     * list of all existing zombies
     */
    private static ArrayList<Zombie> zombieList = new ArrayList<>();
    /**
     * list of all existing projectiles
     */
    private static ArrayList<Projectile> projectileList = new ArrayList<>();
    
    /**
     * removes all existing entities
     */
    public static void clearAllEntities(){
        for(int i = plantList.size() - 1; i >= 0; i--){ 
            Plant p = plantList.get(i);
            Tile.removeGridEntity(p);
        }
        for(int i = zombieList.size() - 1; i >= 0; i--){ 
            Zombie zombie = zombieList.get(i);
            Tile.removeZombie(zombie);
        }
        for(int i = projectileList.size() - 1; i >= 0; i--){ 
//            Projectile projectile = projectileList.get(i);
//            Tile.removeGridEntity(projectile, projectile.getY(), projectile.getX());
        }
    }
    /**
     * adds a new Entity to specified coordinates on grd
     * @param e new Entity
     * @param y y-coordinate in grid
     * @param x x-coordinate in grid
     */
    public static void addGridEntity(Entity e, int y, int x){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            tileArray[y][x] = e;
            
            e.setCoords(y, x);
            e.setAbsoluteCoords(y, x*110+50); //xCoord keeping in mind where a projectile spawns
            
            if(e instanceof Plant){
                plantList.add((Plant) e);
            } 
        }
    }
    
    /**
     * removes an Entity from grid
     * @param e Entity to be removed
     */
    public static void removeGridEntity(Entity e){
        int x = e.getX();
        int y = e.getY();
        
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            if(Tile.getGridEntity(y, x) != null && Tile.getGridEntity(y, x) == e){
                tileArray[y][x] = null;
                
                e.setCoords(-1, -1); // Signifies that Entity e is removed from tileArray entirely
                e.setAbsoluteCoords(-1000, -1000);
                
                if(e instanceof Plant){
                    plantList.remove((Plant) e);
                }
            }
        }
    }
    /**
     * removes an Entity from grid
     * @param y y-coordinate of Entity to be removed
     * @param x x-coordinate of Entity to be removed
     */
    public static void removeGridEntity(int y, int x){
        Entity e = Tile.getGridEntity(y, x);
        
        if(x >= 0 && x < xLength && y >= 0 && y < yLength){
            if(Tile.getGridEntity(y, x) != null && Tile.getGridEntity(y, x) == e){
                tileArray[y][x] = null;
                
                e.setCoords(-1, -1); // Signifies that Entity e is removed from tileArray entirely
                e.setAbsoluteCoords(-1000, -1000);
                
                if(e instanceof Plant){
                    plantList.remove((Plant) e);
                }
            }
        }
    }
    
    /**
     * returns an Entity from grid
     * @param y y-coordinate of Entity
     * @param x x-coordinate of Entity
     * @return Entity from tileArray at specified coordinates
     */
    public static Entity getGridEntity(int y, int x){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength) {
            return tileArray[y][x];
        }
        return null;
    }
    
    /**
     * adds a new Entity not bound to grid
     * @param e new Entity to be added
     * @param y row of Entity
     * @param x pixel-coordinate of Entity
     */
    public static void addAbsoluteEntity(Entity e, int y, int x){
        
        if(e instanceof Zombie){
            Zombie z = (Zombie) e;
            z.setAbsoluteCoords(y, x);
            zombieList.add(z);
            absoluteEntityList.add(z);
        } else if(e instanceof Projectile){
            Projectile p = (Projectile) e;
            p.setAbsoluteCoords(y, x);
            projectileList.add(p);
            absoluteEntityList.add(p);
        }
    }
    /**
     * removes an Entity not bound to grid
     * @param e Entity to be removed
     */
    public static void removeAbsoluteEntity(Entity e){
        if(e instanceof Projectile){
            Projectile p = (Projectile) e;
            Tile.removeProjectile(p);
        } else if(e instanceof Zombie){
            Zombie z = (Zombie) e;
            Tile.removeZombie(z);
        }
    }
    /**
     * removes a Projectile from its containing ArrayLists
     * and sets Projectile's absolute coordinates to negative integers
     * @param p Projectile to be removed
     */
    public static void removeProjectile(Projectile p){
        int x = p.getAbsoluteX();
        int y = p.getAbsoluteY();

        if(x < 0 && y < 0){
            return;
        }
        for(int i = projectileList.size() - 1; i >= 0; i--){
            Projectile projectile = projectileList.get(i);
            if(projectile == p && projectile.getAbsoluteX() == x && projectile.getAbsoluteY() == y){
                projectileList.remove(p);
                absoluteEntityList.remove(p);
                p.setAbsoluteCoords(-1000, -1000);
                break;
            }
        }
    }
    /**
     * removes a Zombie from its containing ArrayLists
     * and sets Zombie's absolute coordinates to negative intergers
     * @param z Zombie to be removed
     */
    public static void removeZombie(Zombie z){
        int x = z.getAbsoluteX();
        int y = z.getAbsoluteY();

        if(x < 0 && y < 0){
            return;
        }
        for(int i = zombieList.size() - 1; i >= 0; i--){
            Zombie zombie = zombieList.get(i);
            if(zombie == z && zombie.getAbsoluteX() == x && zombie.getAbsoluteY() == y){
                zombieList.remove(z);
                absoluteEntityList.remove(z);
                z.setAbsoluteCoords(-1000, -1000);
            }
        }
    }
    
    /**
     * returns selected Projectile
     * @param y row of Projectile
     * @param x pixel-coordinate of Projectile
     * @return selected Projectile instance
     */
    public static Projectile getProjectile(int y, int x){
        for(Projectile p : projectileList){
            if(p.getAbsoluteX() == x && p.getAbsoluteY() == y){
                return p;
            }
        }
        return null;
    }
    /**
     * returns selected Zombie
     * @param y row of Projectile
     * @param x pixel-coordinate of Projectile
     * @return selected Zombie instance
     */
    public static Zombie getZombie(int y, int x){
        for(Zombie z : zombieList){
            if(z.getAbsoluteX() == x && z.getAbsoluteY() == y){
                return z;
            }
        }
        return null;
    }
    
    /**
     * returns selected Plant
     * @param y y-coordinate of Plant in grid
     * @param x x-coordinate of Plant in grid
     * @return selected Plant instance
     */
    public static Plant getPlant(int y, int x){
        if(Tile.getGridEntity(y, x) != null) {
            return (Plant) tileArray[y][x];
        }
        return null;
    }
    /**
     * return ArrayList of plants
     * @return plantList static field
     */
    public static ArrayList<Plant> getPlantList(){
        return plantList;
    }
    /**
     * return ArrayList of zombies
     * @return zombieList static field
     */
    public static ArrayList<Zombie> getZombieList(){
        return zombieList;
    }
    /**
     * return ArrayList of projectiles
     * @return projectileList static field
     */
    public static ArrayList<Projectile> getProjectileList(){
        return projectileList;
    }
}
