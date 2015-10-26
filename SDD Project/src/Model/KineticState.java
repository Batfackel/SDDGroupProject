/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Main;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *used with the state design pattern
 *
 * @author atm15_000
 */
public class KineticState implements State{

    private Ship ship;
    Timer timer, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    Timer[] timers = new Timer[64];
    int timeElapsed;
    
    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        System.out.println("player is in kinetic state");
        bullet.setState(this, 0);          
        try {
        switch(wls) {
            case 0:                            
                //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                //Main.gameData.bullets.add((Bullet)new KineticBulletBaseLevel(x + 20, y - 51));
                timeElapsed = 0;               
                t1 = new Timer();
                t2 = new Timer();
                t3 = new Timer();
                t1.schedule(new SpawnShot(0, x + xCenter, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t2.schedule(new SpawnShot(0, x + xCenter, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t3.schedule(new SpawnShot(0, x + xCenter, y - yOffset), timeElapsed);                
                break;                                                        
            case 1:
                //System.out.println("kinetic level 2");
                //Main.gameData.bullets.add((Bullet)new KineticBulletLevel1(x + 20, y - 51));
                timeElapsed = 0;               
                t1 = new Timer();
                t2 = new Timer();
                t3 = new Timer();
                t4 = new Timer();
                t5 = new Timer();
                t6 = new Timer();               
                t1.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t4.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t2.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t5.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t3.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t6.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                break;
            case 2:
                //System.out.println("kinetic level 3");
                //Main.gameData.bullets.add((Bullet)new KineticBulletLevel2(x + 20, y - 51));
                timeElapsed = 0;               
                t1 = new Timer();
                t2 = new Timer();
                t3 = new Timer();
                t4 = new Timer();
                t5 = new Timer();
                t6 = new Timer();               
                t7 = new Timer();
                t8 = new Timer();
                t9 = new Timer();
                t10 = new Timer();                
                t1.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t4.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t2.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t5.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                t7.schedule(new SpawnShot(1, x + xRightOffset, y - yOffset), timeElapsed);
                t8.schedule(new SpawnShot(2, x - xLeftOffset, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t3.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t6.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                t9.schedule(new SpawnShot(1, x + xRightOffset, y - yOffset), timeElapsed);
                t10.schedule(new SpawnShot(2, x - xLeftOffset, y - yOffset), timeElapsed);
                break;
            case 3:
                //System.out.println("kinetic max level");
                //Main.gameData.bullets.add((Bullet)new KineticBulletMaxLevel(x + 20, y - 51));
                timeElapsed = 0;               
                t1 = new Timer();
                t2 = new Timer();
                t3 = new Timer();
                t4 = new Timer();
                t5 = new Timer();
                t6 = new Timer();               
                t7 = new Timer();
                t8 = new Timer();
                t9 = new Timer();
                t10 = new Timer();
                t11 = new Timer();
                t12 = new Timer();
                t13 = new Timer();
                t14 = new Timer();
                t15 = new Timer();
                t16 = new Timer();                
                t1.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t2.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                timeElapsed += 175;
                t3.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t4.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                t5.schedule(new SpawnShot(1, x + xRightOffset, y - yOffset), timeElapsed);
                t6.schedule(new SpawnShot(1, x + xRightOffset + 20, y - yOffset + 25), timeElapsed);
                t8.schedule(new SpawnShot(2, x - xLeftOffset, y - yOffset), timeElapsed);
                t9.schedule(new SpawnShot(2, x - xLeftOffset - 20, y - yOffset + 25), timeElapsed);                
                timeElapsed += 175;
                t11.schedule(new SpawnShot(0, x - xLeftOffset, y - yOffset), timeElapsed);
                t12.schedule(new SpawnShot(0, x + xRightOffset, y - yOffset), timeElapsed);
                t13.schedule(new SpawnShot(1, x + xRightOffset, y - yOffset), timeElapsed);
                t14.schedule(new SpawnShot(1, x + xRightOffset + 20, y - yOffset + 25), timeElapsed);                
                t15.schedule(new SpawnShot(2, x - xLeftOffset, y - yOffset), timeElapsed);
                t16.schedule(new SpawnShot(2, x - xLeftOffset - 20, y - yOffset + 25), timeElapsed);                
                timeElapsed += 175;
                t7.schedule(new SpawnShot(2, x - xLeftOffset, y - yOffset), timeElapsed);
                t10.schedule(new SpawnShot(1, x + xRightOffset, y - yOffset), timeElapsed);
                break;
            case 10:
                synchronized (Main.gameData.bullets) {
                    //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                    Main.gameData.bullets.add((Bullet)new KineticBulletBaseLevel(x + 20, y + 51));
                    //Main.gameData.figures.add(new Launcher( x + 20, y - 51));
                    break;
                }
            default:
                System.out.println("kinetic error");                
        }
        
                } catch (Exception ex) {
                Logger.getLogger(KineticState.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
    public String toString() {
        return "Kinetic State";
    }    
 
}
