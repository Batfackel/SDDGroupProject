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
public class LaserState implements State{

    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        System.out.println("player is in Laser state");
        bullet.setState(this, 1);    
      try {
        switch(wls) {
            case 0:
                synchronized (Main.gameData.friendlyBullets) {
                    //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                    Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 20, y - 51, false));
                    //Main.gameData.figures.add(new Launcher( x + 20, y - 51));
                    break;
                }
            case 1:
                Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 30, y - 51, false));
                Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 10, y - 51, false));
                break;
            case 2:
                Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 30, y - 51, false));
                Main.gameData.friendlyBullets.add(new LaserBulletBaseLevel(x + 10, y - 51, false));
//                Main.gameData.bullets.add(new LightningShot(x + 25, y + 25));
                break;
            case 3:
                System.out.println("Laser max level");
                break;
            default:
                System.out.println("Laser error");
        }
      }catch(Exception e) {
          System.out.println("error in LaserState");
      }
    }
    
    
    public String toString() {
        return "Laser State";
    }    
    
}
