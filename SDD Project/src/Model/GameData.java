package Model;

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

    String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
    String separator = System.getProperty("file.separator");
    public final Image explosionSpriteSheet = getImage(imagePath + separator + "images" + 
            separator +"explosionsheet.png");
    
    public List<GameFigure> figures;
    public List<Item> items;
    public List<Ship> ships, enemyShips; 
    private ShipFactory shipMaker = new ShipFactory();
    private EnemyFactory enemyMaker = new EnemyFactory();
    private WeaponPowerFactory weaponMaker = new WeaponPowerFactory();  
    private Ship incomingShip;
    private int BASE_LEVEL = -1;
    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        ships = Collections.synchronizedList(new ArrayList<Ship>());
        items = Collections.synchronizedList(new ArrayList<Item>());
        enemyShips = Collections.synchronizedList(new ArrayList<Ship>());

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
        
//         enemyShips.add((Ship)enemyMaker.getEnemyShip("defaultship", 200, 200));

        //represent weapon power-up items
        //figures.add(new Launcher(100, 200));    
        /*figures.add(new Launcher(250, 200));
        figures.add(new Launcher(400, 200));
        figures.add(new Launcher(100, 200));  */
        figures.add((GameFigure) enemyMaker.getEnemyShip("defaultship", 20, 20));
        Ship[] enemyFormation = enemyMaker.getEnemyShipFormation("defaultship", 200, -250);
        for(int i = 0; i < enemyFormation.length; i++) {
            figures.add((GameFigure)enemyFormation[i]);
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

                //Rectangle[] hit = ship.getHitBox();
                Rectangle hit = currentShip.getShipHitBox();
                
                if (this.figures.get(i) instanceof Ship) {
                    Ship asdf = (Ship) this.figures.get(i);
                
                

                  if (hit.intersects(asdf.getShipHitBox())) {
                    
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    items.add((Item)weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                    
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
              System.out.println("weapon state is " + currentShip.getWeaponState());
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
    
    
        List<Ship> removeShips = new ArrayList<Ship>();
        Ship s;        
       
        synchronized (ships) {                                                        
            
            for (int i = 0; i < ships.size(); i++) {               
                s = ships.get(i);
                s.update();
                if (s.getState() == Ship.STATE_FINISHED) {
                    removeShips.add(s);
                }
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
          }
	  items.removeAll(removeItems);
       }   

//        synchronized (enemyShips) {                                                        
//            
//            for (int i = 0; i < enemyShips.size(); i++) {               
//                s = enemyShips.get(i);
//                s.update();
//                if (s.getState() == Ship.STATE_FINISHED) {
//                    removeShips.add(s);
//                }
//            }
//            enemyShips.removeAll(removeShips);
//        }
//       }

    public Image getImage(String fileName) {
       Image image = null;
       try {
           image = ImageIO.read(new File(fileName));
       } catch (Exception ioe) {
           System.out.println("Error: Cannot open image:" + fileName);
           JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
       }
       return image;
    }
    
    
}
