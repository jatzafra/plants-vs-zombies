/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pvz;

/**
 *
 * @author TRUTH
 */
public class PvZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Scenario 1
        SunProducer sunflower = SunProducer(300, 50, 50);
        sunflower.generateSun();
        
        //Scenario 2
        Shooter peashooter = new Shooter(350, 100, "straight");
        Zombie normal = new Zombie("normal", 250, 50, 2);
        
        normal.targetPlant();
        
        while(peashooter.getHP >= 0 || normal.getHP() >= 0){
            peashooter.shoot();
            normal.eatPlant();
        }
        
        //Scenario 3
        Defense wallnut = new Defense(3000, 50);
        Zombie buckethead = new Zombie("buckethead", 500, 50, 2);
        buckethead.targetPlant();
        while(wallnut.getHP() >= 0){
            buckethead.eatPlant();
        }
    }
    
}
