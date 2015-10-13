package Model;

import Controller.EnemyFlyWeightFactory;
import Controller.EnemyFlyweight;
import View.GamePanel;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class GameData {
   
// USE Strategy pattern    
    static final int STATE_EXPLOSIOIN_1 = 1;
    static final int STATE_EXPLOSIOIN_2 = 2;
    static final int STATE_EXPLOSIOIN_3 = 3;
    static final int STATE_EXPLOSIOIN_4 = 4;
    static final int STATE_EXPLOSIOIN_5 = 5;
    static final int STATE_EXPLOSIOIN_6 = 6;
    static final int STATE_EXPLOSIOIN_7 = 7;
    static final int STATE_EXPLOSIOIN_8 = 8;
    static final int STATE_EXPLOSIOIN_9 = 9;
    static final int STATE_EXPLOSIOIN_10 = 10;
    static final int STATE_EXPLOSIOIN_11 = 11;
    static final int STATE_EXPLOSIOIN_12 = 12;
    static final int STATE_EXPLOSIOIN_13 = 13;
    static final int STATE_EXPLOSIOIN_14 = 14;
    static final int STATE_EXPLOSIOIN_15 = 15;
    static final int STATE_EXPLOSIOIN_16 = 16;

    
    public List<Bullet> bullets; // 10.6.15
    public List<GameFigure> figures;
    public List<Item> items;
    public List<Ship> ships, enemyShips; 
    private final ShipFactory shipMaker = new ShipFactory();
    private EnemyFactory enemyMaker = new EnemyFactory();
    private WeaponPowerFactory weaponMaker = new WeaponPowerFactory();  
    private Ship incomingShip;
    private int BASE_LEVEL = -1, counter = 0;
    private EnemyFlyWeightFactory flyweightFactory;
    public static EnemyFlyweight flyweightItems;
    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        ships = Collections.synchronizedList(new ArrayList<Ship>());
        items = Collections.synchronizedList(new ArrayList<Item>());
        enemyShips = Collections.synchronizedList(new ArrayList<Ship>());
        flyweightFactory = new EnemyFlyWeightFactory();
        flyweightItems = flyweightFactory.getFlyweight();
        bullets = Collections.synchronizedList(new ArrayList<Bullet>());

        //create ships for collision test
        //9/10/2015
//-----------------------------------------------------------------------------        
        
        //incomingShip = shipMaker.getShip("defaultShip",300,350);
        // ships.add(incomingShip);      
        ships.add((Ship)shipMaker.getShip("defaultShip",450,450));
        //represent weapon power-up items
        //figures.add(new Launcher(100, 200));    
        // testing items and new item mechanics
        items.add((Item)weaponMaker.getWeapon("KINETIC", 250, 200));
        items.add((Item)weaponMaker.getWeapon("KINETIC", 250, 180));
        items.add((Item)weaponMaker.getWeapon("KINETIC", 250, 1600));
        items.add((Item)weaponMaker.getWeapon("KINETIC", 250, 220));
        items.add((Item)weaponMaker.getWeapon("KINETIC", 250, 240));
        items.add((Item)weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item)weaponMaker.getWeapon("MISSILE", 100, 200));
        

        //represent weapon power-up items
        //figures.add(new Launcher(100, 200));    
        /*figures.add(new Launcher(250, 200));
        figures.add(new Launcher(400, 200));
        figures.add(new Launcher(100, 200));  */
        //figures.add((GameFigure) enemyMaker.getEnemyShip("defaultship", 20, 20));
        Ship[] enemyFormation = enemyMaker.getEnemyShipFormation("defaultship", 200, 250);
        for(int i = 0; i < enemyFormation.length; i++) {
            enemyShips.add((Ship)enemyFormation[i]);
        }
//-----------------------------------------------------------------------------
//----------------------------------------------------------------------
         
      //System.out.println("@@GAME DATA CONSTRUCTO@@");

    }

    private float randomize(float in, int offset) {
        float min = in, max = in + offset;        
        Random rand = new Random();
        float number = rand.nextFloat() * (max - min) + min;
        
        return number;
    }
    
    public void update() {
//-----------------------------------------------------------------------------
// a little collision test for the playable ship and another instance of the ship
// when the ship collides the weapon level state will increment
// the player ship's weapon level state 9/15/2015
// uses the figures arraylist until an item class is created                
//-----------------------------------------------------------------------------                     
              
        //TempShip ship = (TempShip) this.figures.get(0);
        Ship currentShip = (Ship) this.ships.get(0);
        //set to 4 for the time being, make a new arraylist for the enemies        
       // TempShip ship = (TempShip) this.figures.get(0);                
              
        try {
            for (int i = 0; i < this.figures.size(); i++) {
                if (this.figures.get(i) instanceof Ship) {
                    Ship asdf = (Ship) this.figures.get(i);
                
                

                  if (currentShip.getShipHitBox().intersects(asdf.getShipHitBox())) {
                    
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                     /*START EXPLOSION TEST*/
                        currentShip.setState(4);
//=======================/*END EXPLOSION TEST*/
                      //  Ship currentShip = (Ship) this.ships.get(0);
                       
                       
                      //   Main.controller = new KeyController(currentShip);
                         //System.out.println("Ship state is " + currentShip.getState());
                    //asdf.x = 100000;                    
                    //ship.setShipState(STATE_DONE);
                    synchronized (figures) {
                        this.figures.remove(asdf);
                    }
                    //currentShip.setLevelState(currentShip.getLevelState());
                  }
                }           
            }
 
            // checks for collision between items and the ship. If collision is 
            // detected then it either changes the ships weapon in increments the 
            // weapon level 9/23/15
            for (int i = 0; i < this.items.size(); i++) {
                //Rectangle[] hit = currentShip.getShipHitBox();
                Rectangle hit = currentShip.getShipHitBox();
                //System.out.println(this.items.size());
                Item item = (Item) this.items.get(i);                                
                
                if (hit.intersects(item.getRectangle1())) {          
                    int itemReference = item.getItemType();
                    int shipWeaponReference = currentShip.getWeaponState();
                    if(itemReference == shipWeaponReference) 
                        currentShip.setLevelState(currentShip.getLevelState());
                    else if(itemReference >= 0 && itemReference <= 2) {
                        currentShip.setWeaponState(itemReference);
                        currentShip.setLevelState(BASE_LEVEL);
                       
                    }                        
                    this.items.remove(item);                              
                }
            }
            
            for (int i = 0; i < this.bullets.size(); i++) {
                KineticBulletBaseLevel bullet = (KineticBulletBaseLevel) bullets.get(i);
               
            }
            
            //check if a enemy collieded with a player ship or is off the screen
            for (int i = 0; i < this.enemyShips.size(); i++) {
                if(!enemyShips.isEmpty()) {
                    EnemyShip eShip = (EnemyShip) enemyShips.get(i); 
                    //System.out.println("Enemy Ship " + eShip.getShipType() + " rectangle corners x:" + eShip.getX() + " y:" + eShip.getY() + " bottom right x:" + eShip.getX() + (int)eShip.shipWidth + " y:" + eShip.getY() + (int)eShip.shipHeight);
                    //System.out.println("Player ship rectangle corners x:" + currentShip.getX() + " y:" + currentShip.getY());
                    
                    //if (eShip.getShipHitBox().intersects(currentShip.getShipHitBox())) {          
                    
                    if (currentShip.getShipHitBox().intersects(eShip.getShipHitBox())) {
                        synchronized (enemyShips) {
//                            GamePanel.level.save.getloadedScores().lastElement().setScore(GamePanel.level.save.getloadedScores().lastElement().getScore() + eShip.getScore());
                            this.enemyShips.remove(eShip);   
                        }
                    }

                   if(eShip.getShipState() == 0) {
                      synchronized (enemyShips) {                      
                            this.enemyShips.remove(eShip);   
                        } 
                   }
                }
            }
            //used for spawning enemies at set interval
//            if(counter == 100) {
//                counter = 0;
//            }
//            else {
//                Ship[] enemyFormation = enemyMaker.getEnemyShipFormation("defaultship", 200, -250);
//                for(int i = 0; i < enemyFormation.length; i++) {
//                    enemyShips.add(enemyFormation[i]);
//                }
//            }           
              //System.out.println("weapon state is " + currentShip.getWeaponState());

            }
         catch (Exception e) {
            System.out.println(e.toString());
        }

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
        
        List<GameFigure> removeGameFigures = new ArrayList<GameFigure>();
        GameFigure f;        
        
        synchronized (figures) {                                                        
            
            for (int i = 0; i < figures.size(); i++) {               
                f = figures.get(i);
                f.update();
                if (f.getState() == GameFigure.STATE_DONE) {
                    removeGameFigures.add(f);
                }
            }
            figures.removeAll(removeGameFigures);
        }
    
//        careful of deleting something and causing an out of bounds error
        List<Ship> removeShips = new ArrayList<Ship>();
        Ship s;        
       
        synchronized (ships) {                                                        
            
            for (int i = 0; i < ships.size(); i++) {               
                s = ships.get(i);
                s.update();
//                if (s.getState() == Ship.STATE_FINISHED) {
//                    removeShips.add(s);
//                }
            }
            ships.removeAll(removeShips);
        }
        
        // added new items list to find and remove objects 9/23/15
        List<Item> removeItems = new ArrayList<Item>();
        Item it;        
       
        synchronized (items) {                                                     
            
            for (int i = 0; i < items.size(); i++) {               
                it = items.get(i);
                it.update();
                if (it.getState() == Item.STATE_DONE)
                    removeItems.add(it);
            }
            items.removeAll(removeItems);
          }
        
        List<Bullet> removeBullets = new ArrayList<Bullet>();
        Bullet bt;  
        
        synchronized (bullets) {                                                     
            
            for (int i = 0; i < bullets.size(); i++) {               
                bt = bullets.get(i);
                bt.update();
                if (bt.getState() == Item.STATE_DONE)
                    removeBullets.add(bt);
            }
            bullets.removeAll(removeItems);
          }
        
        List<Ship> removeEnemies = new ArrayList<Ship>();
        Ship eShip;
        
        synchronized (enemyShips) {                                                     
            
            for (int i = 0; i < enemyShips.size(); i++) {               
                eShip = enemyShips.get(i);
                eShip.update();  //this update needs to be called in GameData to call class update (I believe)
                if (eShip.getState() == Item.STATE_DONE)
                    removeEnemies.add(eShip);
            }
            enemyShips.removeAll(removeItems);
          }
    }
        
       

//Will's Note:  This is probably not needed due to not being able to access Image files from this class.
    //  Is this true anyone?
    //??????????????????????????????????????????????????????????????????????????????????????????????????
//    public Image getImage(String fileName) {
//       Image image = null;
//       try {
//           image = ImageIO.read(new File(fileName));
//       } catch (Exception ioe) {
//           System.out.println("Error: Cannot open image:" + fileName);
//           JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
//       }
//       return image;
//    }
    
    public void spawnEnemiesForTest() {
        figures.add((GameFigure) enemyMaker.getEnemyShip("defaultship", 20, 20));
        Ship[] enemyFormation = enemyMaker.getEnemyShipFormation("defaultship", 200, -250);
        for(int i = 0; i < enemyFormation.length; i++) {
            synchronized(figures) {
                enemyShips.add(enemyFormation[i]);
            }
            
        }
    }

    private EnemyFlyWeightFactory EnemyFlyweightItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
