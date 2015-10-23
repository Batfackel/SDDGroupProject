/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Main;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author atm15_000
 */
class SpawnShot extends TimerTask {
    private Timer timers[];
    private Timer timer;
    private Ship ship;
    
    int x, y, shotType;
        public SpawnShot(int i, int x, int y) {
            ship = Main.gameData.ships.get(0);
            timers = new Timer[32];
            timer = new Timer();
            this.shotType = i;
            this.x = x;
            this.y = y;
        }
        public void run() {
            //this.x = ship.getX();
            //System.out.println("Time's up!");
            synchronized (Main.gameData.bullets) {
                if (this.shotType == 0)
                    Main.gameData.bullets.add((Bullet)new KineticBulletBaseLevel(this.x, this.y));               
                else if (this.shotType == 1)
                    Main.gameData.bullets.add((Bullet)new KineticBulletRightShot(this.x, this.y));               
                else if (this.shotType == 2)
                    Main.gameData.bullets.add((Bullet)new KineticBulletLeftShot(this.x, this.y));               
            }
            try {
            //timers[this.count].cancel();            
            timer.cancel(); //Terminate the timer thread            
            }catch(Exception e) {
                System.out.println("error at " + this.shotType);
            }
        }
    
}
