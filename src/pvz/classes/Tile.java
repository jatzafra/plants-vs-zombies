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
            
    private static Entity[][] tileArray = new Entity [Tile.yLength][Tile.xLength];;
    private static ArrayList<Entity> absoluteEntityList = new ArrayList<>();
    private static ArrayList<Plant> plantList = new ArrayList<>();
    private static ArrayList<Zombie> zombieList = new ArrayList<>();
    private static ArrayList<Projectile> projectileList = new ArrayList<>();
    
    
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
    
    public static Entity getGridEntity(int y, int x){
        if(x >= 0 && x < xLength && y >= 0 && y < yLength) {
            return tileArray[y][x];
        }
        return null;
    }
    
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
    public static void removeAbsoluteEntity(Entity e){
        if(e instanceof Projectile){
            Projectile p = (Projectile) e;
            Tile.removeProjectile(p);
        } else if(e instanceof Zombie){
            Zombie z = (Zombie) e;
            Tile.removeZombie(z);
        }
    }
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
    
    public static Entity getProjectile(int y, int x){
        for(Projectile p : projectileList){
            if(p.getAbsoluteX() == x && p.getAbsoluteY() == y){
                return p;
            }
        }
        return null;
    }
    public static Entity getZombie(int y, int x){
        for(Projectile p : projectileList){
            if(p.getAbsoluteX() == x && p.getAbsoluteY() == y){
                return p;
            }
        }
        return null;
    }
    
    
    public static Plant getPlant(int y, int x){
        if(Tile.getGridEntity(y, x) != null) {
            return (Plant) tileArray[y][x];
        }
        return null;
    }
    
    public static Zombie getFirstZombieInTile(int y, int x){ 
//        ArrayList<Entity> entities = getGridEntity(y, x);
//        if(entities != null) {
//            for(Entity e : entities){
//                if(e instanceof Zombie){
//                    return (Zombie) e;
//                    // returns first Zombie found in ArrayList
//                    // also Zombie with lowest index in that ArrayList
//                }
//            }
//        }
        return null;
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
    
    public static ArrayList<Plant> getPlantList(){
        return plantList;
    }
    public static ArrayList<Zombie> getZombieList(){
        return zombieList;
    }
    public static ArrayList<Projectile> getProjectileList(){
        return projectileList;
    }
}
