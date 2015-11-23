package Controller;

import static Controller.Main.gameData;
import Model.Context;
import Model.GameData;
import Model.KineticBulletBaseLevel;
import Model.KineticState;
import Model.LaserState;
import Model.Level;
import Model.MissileState;
import Model.Ship;
import Model.ShipFactory;
import Model.Sound;
import static Model.Sound.shot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {
    public static Context bullet;         //stuff for state design pattern
    public static KineticState kinetic;   //stuff for state design pattern
    private LaserState laser;       //stuff for state design pattern
    private MissileState missile;   //stuff for state design pattern
    private Ship mainShip;
    private GameData data;
    private Main main;
    private ShipFactory shipMaker = new ShipFactory(); 
    private Ship newShip;
    private Sound mute;
    //KeyController(){this.ship = null;}//Will Added constructor 9/16/2015
    //there are two constructors here
    public KeyController(Ship ship, GameData gameData) {
        this.mainShip = (Ship)ship;
        this.data = gameData;                   //need to create objects of the different bullet states
        this.bullet = new Context();        //object of context. Context creates bullet types
        this.kinetic = new KineticState();  //object of KineticState
        this.laser = new LaserState();      //object of LaserState
        this.missile = new MissileState();  //object of MissileState
    }
    
    
    public KeyController(Ship ship, Main main) {
        this.mainShip = (Ship) ship;
        this.main = (Main) main;                //need to create objects of the different bullet states
        this.bullet = new Context();        //object of context. Context creates bullet types
        this.kinetic = new KineticState();  //object of KineticState
        this.laser = new LaserState();      //object of LaserState
        this.missile = new MissileState();  //object of MissileState
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
            case KeyEvent.VK_D:
                newShip = shipMaker.getShip("defaultship",mainShip.getX(),mainShip.getY());
                gameData.ships.remove(0);
                gameData.ships.add(0,newShip);
                this.setShip(newShip);
                main.mouseController.setShip(newShip);
                break;            
            case KeyEvent.VK_V:
                newShip = shipMaker.getShip("shipv",mainShip.getX(),mainShip.getY());
                gameData.ships.remove(0);
                gameData.ships.add(0,newShip);
                this.setShip(newShip);
                main.mouseController.setShip(newShip);
                break;
              case KeyEvent.VK_W:
                newShip = shipMaker.getShip("shipw",mainShip.getX(),mainShip.getY());
                gameData.ships.remove(0);
                gameData.ships.add(0,newShip);
                this.setShip(newShip);
                main.mouseController.setShip(newShip);
                break;              
            case KeyEvent.VK_X:
                newShip = shipMaker.getShip("shipx",mainShip.getX(),mainShip.getY());
                gameData.ships.remove(0);
                gameData.ships.add(0,newShip);
                this.setShip(newShip);
                main.mouseController.setShip(newShip);
                break;
            case KeyEvent.VK_Y:
                newShip = shipMaker.getShip("shipy",mainShip.getX(),mainShip.getY());
                gameData.ships.remove(0);
                gameData.ships.add(0,newShip);
                this.setShip(newShip);
                main.mouseController.setShip(newShip);
                break;   
            case KeyEvent.VK_Z:
                newShip = shipMaker.getShip("shipz",mainShip.getX(),mainShip.getY());
                gameData.ships.remove(0);
                gameData.ships.add(0,newShip);
                this.setShip(newShip);
                main.mouseController.setShip(newShip);
                break;                
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
          case KeyEvent.VK_M: 
              boolean temp = Level.doNotTransition;
                if(temp) {
                    Level.doNotTransition = false;
                }
                else {
                    Level.doNotTransition = true;
                }
          case KeyEvent.VK_P:
              Sound.sound1.mute();
           
//            case KeyEvent.VK_1:
//                ship.setRateOfSpeed(5);
//                break;
//            case KeyEvent.VK_2:
//                ship.setRateOfSpeed(8);
//                break;
//            case KeyEvent.VK_3:
//                ship.setRateOfSpeed(12);
//                break;
//            case KeyEvent.VK_4:
//                ship.setRateOfSpeed(15);
//                break;
//            case KeyEvent.VK_5:
//                ship.setRateOfSpeed(18);
//                break;
//            case KeyEvent.VK_6:
//                ship.setRateOfSpeed(21);
//                break;


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
                /*
                On space bar click a bullet object will be spawned at a designated position.
                To acomplish this goal a State desgin pattern is used to determine what type of 
                bullet to spawn in based up what the ships weapon type is. The current gun type 
                is being stored in the ship objects themselves. More notes will be supplied below. 
                */
            case KeyEvent.VK_SPACE:
                //Sound.shot.play();
                /*
                This stuff is from the old missile that was being used as a placeholder
                The logic may still be valuable at some point so I just commented it out.
                */
                //KineticBulletBaseItem f = new KineticBulletBaseItem(ship.getXofMissileShoot(), ship.getYofMissileShoot(), color);
                //f.setTarget(x, y);
                //int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
                //f.setExplosionMaxSize(size);
                
                // used for debugging
                System.out.println("current level of the weapon: " + mainShip.getLevelState());
                
                /*
                Upon space bar click the weapon type that is stored in the ship object is returned. 
                That value declared in the interface and is being stored as an integer.
                The integer is used to select the case. More can be added as needed.
                Note: I'm only commenting one case, the others work exactly the same.
                */
                switch (mainShip.getWeaponState()) {
                    case 0: //kinetic
                        /*
                        In order for the State design pattern to spawn the right object it spawns in
                        a "bullet" which is a object of Context. Context holds the information about
                        what kind of bullet to generate. By calling setState the type of bullet
                        is being declared so,
                        
                        setState("bulletType", "shipWeaponLevel") --> setState(kinetic, mainShip.getLevelState())
                        
                        Above the state of context is changed to Kinetic and with the ships current weapon level.                        
                        */
                        this.bullet.setState(kinetic, mainShip.getLevelState());                        
                        //System.out.println(this.bullet.getState().toString());  //used for debugging
                        /*
                        Once the bullet state is set using Context methods this command is executed to
                        actually spawn in a bullet. fire(x, y) is a method stored in context. The method in
                        context calls another method to generate the correct type of bullet. 
                        
                        fire("shipX", "shipY") --> fire(mainShip.getX(), mainShip.getY())
                        
                        This above code generates a bullet object at the ships x and y location.
                        */
                        this.bullet.fire(mainShip.getX(), mainShip.getY());
                        Sound.shot.play();
                        break;
                    case 1: //laser
                        this.bullet.setState(laser, mainShip.getLevelState());
                        //System.out.println(this.bullet.getState().toString());
                        this.bullet.fire(mainShip.getX(), mainShip.getY());
                        Sound.shot3.play();
                        break;
                    case 2: //missile
                        this.bullet.setState(missile, mainShip.getLevelState());
                        //System.out.println(this.bullet.getState().toString());
                        this.bullet.fire(mainShip.getX(), mainShip.getY());
                        Sound.shot2.play();
                        break;
                    default: //error
                        System.out.println("error in weapon architecture");
                }
            break;
            case KeyEvent.VK_J:
                Main.gamePanel.level.currentSave.setScore(150);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

   
}
