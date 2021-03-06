package Model;

import Controller.Main;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * used with the state design pattern. This sets the bullet to the correct
 * missile shot level relative to the ship firing it. This class is a little
 * different than the other two state classes because this utilizes timers to
 * shoot multiple shots in a burst mode.
 *
 * The timers use the SpawnShot class.
 *
 * @author Michael McGregor
 */
public class KineticState implements State {

    Timer timer, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    Timer[] timers = new Timer[64];
    int timeElapsed;

    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        //System.out.println("player is in kinetic state");
        bullet.setState(this, 0);
        
        try {
            switch (wls) {
                case 0:
                    timeElapsed = 0;
                    t1 = new Timer();
                    t2 = new Timer();
                    t3 = new Timer();
                    t1.schedule(new SpawnShot(0, x + xCenter, y), timeElapsed);
                    timeElapsed += 175;
                    t2.schedule(new SpawnShot(0, x + xCenter, y), timeElapsed);
                    timeElapsed += 175;
                    t3.schedule(new SpawnShot(0, x + xCenter, y), timeElapsed);
                    break;
                case 1:
                    //System.out.println("kinetic level 2");                    
                    timeElapsed = 0;
                    t1 = new Timer();
                    t2 = new Timer();
                    t3 = new Timer();
                    t4 = new Timer();
                    t5 = new Timer();
                    t6 = new Timer();
                    t1.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t4.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    timeElapsed += 175;
                    t2.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t5.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    timeElapsed += 175;
                    t3.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t6.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    break;
                case 2:
                    //System.out.println("kinetic level 3");                    
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
                    t1.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t4.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    timeElapsed += 175;
                    t2.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t5.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    t7.schedule(new SpawnShot(1, x + xRightOffset, y), timeElapsed);
                    t8.schedule(new SpawnShot(2, x - xLeftOffset, y), timeElapsed);
                    timeElapsed += 175;
                    t3.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t6.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    t9.schedule(new SpawnShot(1, x + xRightOffset, y), timeElapsed);
                    t10.schedule(new SpawnShot(2, x - xLeftOffset, y), timeElapsed);
                    break;
                case 3:
                    //System.out.println("kinetic max level");                    
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

                    t1.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t2.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    timeElapsed += 175;
                    t3.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t4.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    t5.schedule(new SpawnShot(1, x + xRightOffset, y), timeElapsed);
                    t6.schedule(new SpawnShot(1, x + xRightOffset + 15, y + 25), timeElapsed);
                    t8.schedule(new SpawnShot(2, x - xLeftOffset, y), timeElapsed);
                    t9.schedule(new SpawnShot(2, x - xLeftOffset - 15, y + 25), timeElapsed);
                    timeElapsed += 175;
                    t11.schedule(new SpawnShot(0, x - xLeftOffset, y), timeElapsed);
                    t12.schedule(new SpawnShot(0, x + xRightOffset, y), timeElapsed);
                    t13.schedule(new SpawnShot(1, x + xRightOffset, y), timeElapsed);
                    t14.schedule(new SpawnShot(1, x + xRightOffset + 15, y + 25), timeElapsed);
                    t15.schedule(new SpawnShot(2, x - xLeftOffset, y), timeElapsed);
                    t16.schedule(new SpawnShot(2, x - xLeftOffset - 15, y + 25), timeElapsed);
                    timeElapsed += 175;
                    t7.schedule(new SpawnShot(2, x - xLeftOffset, y), timeElapsed);
                    t10.schedule(new SpawnShot(1, x + xRightOffset, y), timeElapsed);
                    break;
                case 10:
                    //used by enemies to go and shoot at the player
                    synchronized (Main.gameData.enemyBullets) {
                        //----------------
                        //test stuff
                        //spawn the enemy shots, 10 - from up to down, 11 & 12 shoot sidways
                        //enemy bullet movements are defined in the update method of the bullet classes. 
                        //Feel free to change them if you want.
                        //----------------
                        timeElapsed = 0;
                        t1 = new Timer();
                        t2 = new Timer();
                        t3 = new Timer();
                        t1.schedule(new SpawnShot(10, x, y), timeElapsed);
                        t2.schedule(new SpawnShot(11, x, y), timeElapsed);
                        t3.schedule(new SpawnShot(12, x, y), timeElapsed);
                        //----------------
                        break;
                    }
                default:
                    System.out.println("kinetic error");
            }
        } catch (Exception ex) {
            Logger.getLogger(KineticState.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "Kinetic State";
    }

}
