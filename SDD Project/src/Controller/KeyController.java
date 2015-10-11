package Controller;

import Model.Context;
import Model.GameData;
import Model.KineticBulletBaseLevel;
import Model.KineticState;
import Model.LaserState;
import Model.Launcher;
import Model.MissileState;
import Model.Ship;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {
    //stuff for state design patters
    private Context bullet;
    private KineticState kinetic;
    private LaserState laser;
    private MissileState missile;   
    private Ship mainShip;
    private GameData data;
    //KeyController(){this.ship = null;}//Will Added constructor 9/16/2015
    //there are two constructors here
    public KeyController(Ship ship, GameData gameData) {
        this.mainShip = (Ship)ship;
        this.data = gameData;
        this.bullet = new Context();
        this.kinetic = new KineticState();
        this.laser = new LaserState();
        this.missile = new MissileState(); 
    }
    
    
    public KeyController(Ship ship) {
        this.mainShip = (Ship) ship;
        this.bullet = new Context();
        this.kinetic = new KineticState();
        this.laser = new LaserState();
        this.missile = new MissileState(); 
    }
    
    public void setGameData(GameData gameData) {
        this.data = gameData;
    }
    
    public void setShip(Ship ship){
        
        this.mainShip = ship;
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                mainShip.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                mainShip.moveRight();                
                break;
            case KeyEvent.VK_UP:
                mainShip.moveUp();              
                break;
            case KeyEvent.VK_DOWN:
                mainShip.moveDown(); 
                break;
            case KeyEvent.VK_1:
                mainShip.setRateOfSpeed(5);
//                ship.setShipType(1);
                break;
            case KeyEvent.VK_2:
                mainShip.setRateOfSpeed(8);
//                ship.setShipType(2);
                break;
            case KeyEvent.VK_3:
                mainShip.setRateOfSpeed(12);
//                ship.setShipType(3);
                break;
            case KeyEvent.VK_4:
                mainShip.setRateOfSpeed(15);
//                ship.setShipType(4);
                break;
            case KeyEvent.VK_5:
                mainShip.setRateOfSpeed(18);
//                ship.setShipType(5);
                break;
            case KeyEvent.VK_6:
                mainShip.setRateOfSpeed(21);
//                ship.setShipType(6);
                break;
            case KeyEvent.VK_S:
                data.spawnEnemiesForTest();
                break;     
            case KeyEvent.VK_SPACE:
                //KineticBulletBaseItem f = new KineticBulletBaseItem(ship.getXofMissileShoot(), ship.getYofMissileShoot(), color);
                //f.setTarget(x, y);
                //int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
                //f.setExplosionMaxSize(size);
                
                System.out.println("current level of the weapon: " + mainShip.getLevelState());
        switch(mainShip.getWeaponState()) {
            case 0: 
                this.bullet.setState(kinetic, mainShip.getLevelState());
                System.out.println(this.bullet.getState().toString());
                this.bullet.fire(mainShip.getX(), mainShip.getY());
                break;
            case 1:
                this.bullet.setState(laser, mainShip.getLevelState());
                System.out.println(this.bullet.getState().toString());
                this.bullet.fire(mainShip.getX(), mainShip.getY());
                break;
            case 2:
                this.bullet.setState(missile, mainShip.getLevelState());
                System.out.println(this.bullet.getState().toString());
                this.bullet.fire(mainShip.getX(), mainShip.getY());
                break;
            default:System.out.println("error in weapon architecture");
        }    
                
                /*synchronized (Main.gameData.figures) {
                    //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                    Main.gameData.figures.add(new Launcher( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY() - 10));
                                    
                /*synchronized (Main.gameData.figures) {
                    //Main.gameData.figures.add(new KineticBulletBaseLevel( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY()));
                    Main.gameData.figures.add(new Launcher( (float)(ship.getX() + (ship.getShipHitBox().width/2)), (float)ship.getY() - 10));
                    
                }*/
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
