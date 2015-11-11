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
    //private Timer timers[];
    private Timer timer;
    private Ship ship;
    
    int x, y, shotType;
        public SpawnShot(int i, int x, int y) {
            ship = Main.gameData.ships.get(0);
            //timers = new Timer[32];
            timer = new Timer();
            this.shotType = i;
            this.x = x;
            this.y = y;
        }
        public void run() {
            //this.x = ship.getX();
            //System.out.println("Time's up!");
            
            //added a variable to bullets to determine friend or foe, false == friendly and true == enemy
            synchronized (Main.gameData.friendlyBullets) {
                if (this.shotType == 0)
                    Main.gameData.friendlyBullets.add((Bullet)new KineticBulletBaseLevel(this.x, this.y, false));               
                else if (this.shotType == 1)
                    Main.gameData.friendlyBullets.add((Bullet)new KineticBulletRightShot(this.x, this.y, false));               
                else if (this.shotType == 2)
                    Main.gameData.friendlyBullets.add((Bullet)new KineticBulletLeftShot(this.x, this.y, false));  
                else if (this.shotType == 5)
                    Main.gameData.friendlyBullets.add((Bullet)new MissileSparkleDust(this.x, this.y, false));
                else if (this.shotType == 10)
                    Main.gameData.enemyBullets.add((Bullet)new KineticBulletBaseLevel(this.x, this.y, true));
                else if (this.shotType == 11)
                    Main.gameData.enemyBullets.add((Bullet)new KineticBulletBaseLevel(this.x, this.y, true));
                else if (this.shotType == 12)
                    Main.gameData.enemyBullets.add((Bullet)new KineticBulletBaseLevel(this.x, this.y, true));
            }
            try {
            //timers[this.count].cancel();            
            timer.cancel(); //Terminate the timer thread            
            }catch(Exception e) {
                System.out.println("error at " + this.shotType);
            }
        }
}
