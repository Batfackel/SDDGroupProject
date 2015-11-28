package Model;

import Controller.Main;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is used to spawn in kinetic shots using the timer thread.
 *
 * @author Michael McGregor
 */
class SpawnShot extends TimerTask {

    private final Timer timer;
    private final Ship ship;

    int x, y, shotType;

    public SpawnShot(int i, int x, int y) {
        ship = Main.gameData.ships.get(0);
        timer = new Timer();
        this.shotType = i;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
            //this.x = ship.getX();
        //System.out.println("Time's up!");

        //added a variable to bullets to determine friend or foe, false == friendly and true == enemy
        synchronized (Main.gameData.friendlyBullets) {
            if (this.shotType == 0) {
                Main.gameData.friendlyBullets.add((Bullet) new KineticBulletBaseLevel(this.x, this.y, false));
            } else if (this.shotType == 1) {
                Main.gameData.friendlyBullets.add((Bullet) new KineticBulletRightShot(this.x, this.y, false));
            } else if (this.shotType == 2) {
                Main.gameData.friendlyBullets.add((Bullet) new KineticBulletLeftShot(this.x, this.y, false));
            } else if (this.shotType == 5) {
                Main.gameData.friendlyBullets.add((Bullet) new MissileSparkleDust(this.x, this.y, false));
            } else if (this.shotType == 10) {
                Main.gameData.enemyBullets.add((Bullet) new KineticBulletBaseLevel(this.x, this.y, true));
            } else if (this.shotType == 11) {
                Main.gameData.enemyBullets.add((Bullet) new KineticBulletBaseLevel(this.x, this.y, true));
            } else if (this.shotType == 12) {
                Main.gameData.enemyBullets.add((Bullet) new KineticBulletBaseLevel(this.x, this.y, true));
            }
        }
        try {            
            timer.cancel(); //Terminate the timer thread            
        } catch (Exception e) {
            System.out.println("error at " + this.shotType);
        }
    }
}
