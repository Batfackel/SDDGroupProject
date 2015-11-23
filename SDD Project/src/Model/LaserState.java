package Model;

import Controller.Main;

/**
 * used with the state design pattern. This sets the bullet to the correct laser
 * shot level relative to the ship firing it.
 *
 * @author Michael McGregor
 */
public class LaserState implements State {

    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        //System.out.println("player is in Laser state");
        bullet.setState(this, 1);
        
        try {
            switch (wls) {
                case 0:
                    synchronized (Main.gameData.friendlyBullets) {
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 20, y - 51, false));
                        break;
                    }
                case 1:
                    synchronized (Main.gameData.friendlyBullets) {
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 30, y - 51, false));
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 10, y - 51, false));
                        break;
                    }
                case 2:
                    synchronized (Main.gameData.friendlyBullets) {
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 30, y - 51, false));
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 10, y - 51, false));
                        break;
                    }
                case 3:
                    synchronized (Main.gameData.friendlyBullets) {
                        System.out.println("Laser max level");
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 25, y - 51, false));
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 5, y - 51, false));
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 45, y - 51, false));
                        Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x - 15, y - 51, false));
                        break;
                    }
                default:
                    System.out.println("Laser error");
            }
        } catch (Exception e) {
            System.out.println("error in LaserState");
        }
    }

    @Override
    public String toString() {
        return "Laser State";
    }
}
