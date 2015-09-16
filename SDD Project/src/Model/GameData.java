import Model.Level;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameData {

    final List<GameFigure> figures;

    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        
        //create ships for collision test
        //9/10/2015
//-----------------------------------------------------------------------------        
        //player ship
        //figures.add(new Launcher(350, 500));                                     
        figures.add(new TempShip(500,500));
  
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
// when the ship collides the weapon level state will increment
// the player ship's weapon level state 9/15/2015
// uses the figures arraylist until an item class is created                
//-----------------------------------------------------------------------------                     
        TempShip ship = (TempShip) this.figures.get(0);
              
        try {
            for (int i = 1; i < this.figures.size(); i++) {

                Rectangle[] hit = ship.getHitBox();
                Launcher asdf = (Launcher) this.figures.get(i);

                if (hit[0].intersects(asdf.getRectangle1())) {
                    //asdf.x = 100000;                    
                    //ship.setShipState(STATE_DONE);
                    this.figures.remove(asdf);
                    ship.setLevelState(ship.getLevelState());
                }
            }
        } catch (java.lang.ClassCastException e) {
            System.out.println("missile");
        }
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
        
        List<GameFigure> remove = new ArrayList<GameFigure>();
        GameFigure f;        
        
        synchronized (figures) {                                                        
            
            for (int i = 0; i < figures.size(); i++) {               
                f = figures.get(i);
                f.update();
                if (f.getState() == GameFigure.STATE_DONE) {
                    remove.add(f);
                }
            }
            figures.removeAll(remove);
        }
    }
}
