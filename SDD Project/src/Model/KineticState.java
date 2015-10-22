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
public class KineticState implements State{

    private Ship ship;
    
    @Override
    public void fire(Context bullet, int wls, int x, int y) {
        System.out.println("player is in kinetic state");
        bullet.setState(this, 0);
        switch(wls) {
            case 0:
                synchronized (Main.gameData.bullets) {
                    //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                    Main.gameData.bullets.add((Bullet)new KineticBulletBaseLevel(x + 20, y - 51));
                    //Main.gameData.figures.add(new Launcher( x + 20, y - 51));
                    break;
                }
            case 1:
                System.out.println("kinetic level 2");
                break;
            case 2:
                System.out.println("kinetic level 3");
                break;
            case 3:
                System.out.println("kinetic max level");
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
        
        
    }
    
    public String toString() {
        return "Kinetic State";
    }    


    
}
