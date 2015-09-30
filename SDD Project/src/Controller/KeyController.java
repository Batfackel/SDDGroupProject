package Controller;

import Model.GameData;
import Model.Ship;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {
    
    private Ship ship;
    private GameData data;
    //KeyController(){this.ship = null;}//Will Added constructor 9/16/2015
    public KeyController(Ship ship, GameData gameData) {
        this.ship = (Ship) ship;
        this.data = gameData;
       // this.ship =  ship;
    }
    
    public KeyController(Ship ship) {
        this.ship = (Ship) ship;
    }
    
    public void setGameData(GameData gameData) {
        this.data = gameData;
    }
    
    public void setShip(Ship ship){
        
        this.ship = ship;
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                ship.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                ship.moveRight();                
                break;
            case KeyEvent.VK_UP:
                ship.moveUp();              
                break;
            case KeyEvent.VK_DOWN:
                ship.moveDown(); 
                break;
            case KeyEvent.VK_1:
                ship.setRateOfSpeed(5);
                ship.setShipType(1);
                break;
            case KeyEvent.VK_2:
                ship.setRateOfSpeed(8);
                ship.setShipType(2);
                break;
            case KeyEvent.VK_3:
                ship.setRateOfSpeed(12);
                ship.setShipType(3);
                break;
            case KeyEvent.VK_4:
                ship.setRateOfSpeed(15);
                ship.setShipType(4);
                break;
            case KeyEvent.VK_5:
                ship.setRateOfSpeed(18);
                ship.setShipType(5);
                break;
            case KeyEvent.VK_6:
                ship.setRateOfSpeed(21);
                ship.setShipType(6);
                break;
            case KeyEvent.VK_S:
                data.spawnEnemiesForTest();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
