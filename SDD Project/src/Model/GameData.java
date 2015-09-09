import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameData {

    final List<GameFigure> figures;

    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        
        
        figures.add(new Launcher(GamePanel.returnWidth()/2-30, GamePanel.returnHeight()-60));
         
      System.out.println("@@GAME DATA CONSTRUCTO@@");
    }

    public void update() {
        List<GameFigure> remove = new ArrayList<GameFigure>();
        GameFigure f;
        System.out.println("@@GAME DATA: UPDATE FUNCTION@@");
        synchronized (figures) {
            for (int i = 0; i < figures.size(); i++) {
               System.out.println("@@GAME DATA: Synchronized (Figures) @@");
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
