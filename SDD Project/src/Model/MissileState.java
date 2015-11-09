/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Main;

/**
 *used with the state design pattern
 * 
 * @author atm15_000
 */
public class MissileState implements State{

    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        System.out.println("player is in Missile state");
        bullet.setState(this, 2); 
     
        switch(wls) {
            case 0:
                synchronized (Main.gameData.friendlyBullets) {
                    //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletBaseLevel(x + 15, y + 15, false, 0));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletBaseLevel(x + 15, y + 15, false, 1));
                    //Main.gameData.figures.add(new Launcher( x + 20, y - 51));
                    break;
                }
            case 1:
                synchronized (Main.gameData.friendlyBullets) {
                    //System.out.println("Missile level 2");
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletSparklers(x + 15, y + 15, false, 0));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletSparklers(x + 15, y + 15, false, 1));
                    break;
                }
            case 2:
                synchronized (Main.gameData.friendlyBullets) {
                    //System.out.println("Missile level 3");
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletBaseLevel(x + 15, y + 15, false, 0));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletBaseLevel(x + 15, y + 15, false, 1));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletBaseLevel(x + 30, y + 25, false, 0));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletBaseLevel(x, y + 25, false, 1));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletSwarmMother(x + 1, y + 30, false));
                    //Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x + 15, y + 15, false));
                    //Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x + 15, y + 15, false));                    
                    break;
                }
            case 3:
                synchronized (Main.gameData.friendlyBullets) {
                    System.out.println("Missile max level");
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletSparklers(x + 30, y + 25, false, 0));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileBulletSparklers(x , y + 25, false, 1));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileLiz(x + 1, y + 15, false));
                    break;
                }
            default:
                System.out.println("Missile error");
        }
    }
    
    public String toString() {
        return "Missile State";
    }    
    
}
