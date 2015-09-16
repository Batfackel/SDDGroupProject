import Model.Ship;
import Model.ShipFactory;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameData {

    final List<GameFigure> figures;
    final List<Ship> ships;
    private ShipFactory shipMaker;
    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        ships = Collections.synchronizedList(new ArrayList<Ship>());
        //create ships for collision test
        //9/10/2015
//-----------------------------------------------------------------------------        
        //player ship
        //figures.add(new Launcher(350, 500));                                     
 //       figures.add(new TempShip(500,500));
 
        ships.add(shipMaker.getShip(0, 350, 350));
        //represent weapon power-up items
        //figures.add(new Launcher(100, 200));           
        figures.add(new Launcher(250, 200));
        figures.add(new Launcher(400, 200));
        figures.add(new Launcher(100, 200));           
//-----------------------------------------------------------------------------
//----------------------------------------------------------------------
         
      //System.out.println("@@GAME DATA CONSTRUCTO@@");

    }

    public void update() {
//-----------------------------------------------------------------------------
// a little collision test for the playable ship and another instance of the ship
// when the ship collides the weapon state boolean will be true and increment
// the player ship's weapon level state 9/10/2015
//-----------------------------------------------------------------------------                     
        //TempShip ship = (TempShip) this.figures.get(0);
        Ship currentShip = (Ship) this.ships.get(0);
        //set to 4 for the time being, make a new arraylist for the enemies
        for (int i = 1; i < 4; i++) {

                //Rectangle[] hit = ship.getHitBox();
                Rectangle[] hit = currentShip.getShipHitBox();
                Launcher asdf = (Launcher) this.figures.get(i);
                
                if (hit[0].intersects(asdf.getLauncherHitBox()) ){
                    asdf.x = 100000;                    
                    //ship.setLevelState(ship.getLevelState());
                    currentShip.setLevelState(currentShip.getLevelState());
                }            
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
       }
    
}
