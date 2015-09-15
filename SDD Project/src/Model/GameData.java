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
        figures.add(new Launcher(100, 200));           
        figures.add(new Launcher(250, 200));
        figures.add(new Launcher(400, 200));
        figures.add(new Launcher(1000, 2000));           
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
        //for (int i = 0; i< figures.size(); i++) {                            
        
// Idealy this would be in a loop but for the sake of testing I did this.        
<<<<<<< HEAD
//-----------------------------------------------------------------------------
        //Launcher test = (Launcher) this.figures.get(0);
        Launcher enemy1 = (Launcher) this.figures.get(1);
        Launcher enemy2 = (Launcher) this.figures.get(2);
        Launcher enemy3 = (Launcher) this.figures.get(3);
=======
        TempShip ship = (TempShip) this.figures.get(0);
        Launcher test = (Launcher) this.figures.get(1);
        Launcher enemy1 = (Launcher) this.figures.get(2);
        Launcher enemy2 = (Launcher) this.figures.get(3);
        Launcher enemy3 = (Launcher) this.figures.get(4);
>>>>>>> origin/master
              
        boolean levelCheck = false;
        for (int i = 1; i < figures.size(); i++) {

                
            //this would crash the game becuse I was testing stuff that wasn't created
            //Launcher enemy = (Launcher) this.figures.get(i);
                         
            if (test.getRectangle1().intersects(enemy1.getRectangle1())) {
                System.out.println("intersections");
                enemy1.x = 100000;
                levelCheck = true;                
            }
            else if (test.getRectangle1().intersects(enemy2.getRectangle1())) {
                enemy2.x = 100000;
                levelCheck = true;
            }                
            else if (test.getRectangle1().intersects(enemy3.getRectangle1())) {
                enemy3.x = 100000;
                levelCheck = true;
            }
    }
        if (levelCheck == true) {
            test.levelState++;
            levelCheck = false;
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
