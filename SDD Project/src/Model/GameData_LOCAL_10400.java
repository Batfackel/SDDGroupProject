import Model.Level;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameData {

    final List<GameFigure> figures;

    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        
        
        figures.add(new Launcher(Level.returnWidth()/2-30, Level.returnHeight()-60));
                           
        figures.add(new Launcher(100, 100));            
    
         
        System.out.println("@@GAME DATA CONSTRUCTO@@");
    }

    public void update() {
// a little collision test for the playable ship and another instance of the ship
//---------------------------------------------        
        //for (int i = 0; i< figures.size(); i++) {
                
            Launcher test = (Launcher) this.figures.get(0);
            Launcher other = (Launcher) this.figures.get(1);
                
                
            Rectangle mytestR1 = test.getRectangle1();
            Rectangle mytestR2 = other.getRectangle1();
            if (test.getRectangle1().intersects(other.getRectangle1())) {
                System.out.println("intersections");
                other.x = 100000;
            }
    //}         
//----------------------------------------------------
            
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
