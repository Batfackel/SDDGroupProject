package Model;

import Controller.Main;

/**
 * used with the state design pattern. This sets the bullet to the correct
 * missile shot level relative to the ship firing it.
 *
 * @author Michael McGregor
 */
public class MissileState implements State {

    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        //System.out.println("player is in missile state");
        bullet.setState(this, 2);

        try {
            switch (wls) {
                case 0:
                    synchronized (Main.gameData.friendlyBullets) {
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletBaseLevel(x + 15, y + 15, false, 0));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletBaseLevel(x + 15, y + 15, false, 1));
                        break;
                    }
                case 1:
                    synchronized (Main.gameData.friendlyBullets) {
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletSparklers(x + 15, y + 15, false, 0));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletSparklers(x + 15, y + 15, false, 1));
                        break;
                    }
                case 2:
                    synchronized (Main.gameData.friendlyBullets) {
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletBaseLevel(x + 15, y + 15, false, 0));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletBaseLevel(x + 15, y + 15, false, 1));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletBaseLevel(x + 30, y + 25, false, 0));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletBaseLevel(x, y + 25, false, 1));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletSwarmMother(x + 1, y + 30, false));
                        break;
                    }
                case 3:
                    synchronized (Main.gameData.friendlyBullets) {
                        System.out.println("Missile max level");
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletSparklers(x + 30, y + 25, false, 0));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileBulletSparklers(x, y + 25, false, 1));
                        Main.gameData.friendlyBullets.add((Bullet) new MissileLiz(x + 1, y + 15, false));
                        break;
                    }
                default:
                    System.out.println("Missile error");
            }
        } catch (Exception e) {
            System.out.println("error in LaserState");
        }
    }

    @Override
    public String toString() {
        return "Missile State";
    }
}
