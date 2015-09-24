package Model;

import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameData {

    public List<GameFigure> figures;
    public List<Ship> ships, enemyShips;
    private ShipFactory shipMaker = new ShipFactory();
    private EnemyFactory enemyMaker = new EnemyFactory();
    private Ship incomingShip;
    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        ships = Collections.synchronizedList(new ArrayList<Ship>());
        enemyShips = Collections.synchronizedList(new ArrayList<Ship>());
        //create ships for collision test
        //9/10/2015
//-----------------------------------------------------------------------------        
        //player ship
        //figures.add(new Launcher(350, 500));                                     
 //       figures.add(new TempShip(500,500));
        //incomingShip = shipMaker.getShip("defaultShip",300,350);
       // ships.add(incomingShip);
         ships.add((Ship)shipMaker.getShip("defaultShip",450,450));
//         enemyShips.add((Ship)enemyMaker.getEnemyShip("defaultship", 200, 200));
        //represent weapon power-up items
        //figures.add(new Launcher(100, 200));    
        figures.add(new Launcher(250, 200));
        figures.add(new Launcher(400, 200));
        figures.add(new Launcher(100, 200));  
        figures.add((GameFigure) enemyMaker.getEnemyShip("defaultship", 200, 200));
//-----------------------------------------------------------------------------
//----------------------------------------------------------------------
         
      //System.out.println("@@GAME DATA CONSTRUCTO@@");

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
                Ship asdf = (Ship) this.figures.get(i);

                  if (hit.intersects(asdf.getShipHitBox())) {
                    //asdf.x = 100000;                    
                    //ship.setShipState(STATE_DONE);
                    this.figures.remove(asdf);
                    currentShip.setLevelState(currentShip.getLevelState());
                }           
    }
              
            }
         catch (java.lang.ClassCastException e) {
            System.out.println("missile");
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
       }
    
}
