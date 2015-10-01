
package Controller;

import Model.Missile;
import Model.Ship;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController implements MouseListener{
      private Ship mainShip;
    //KeyController(){this.ship = null;}//Will Added constructor 9/16/2015
    public MouseController(Ship ship) {
        this.mainShip = (Ship) ship;
       // this.ship =  ship;
    }
    
     @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //----------------------------------------------------------------------
        //changes the types of bullet shot. This changes the weapon type when 
        //the ship weapon state changes - 9/10/2015
        //----------------------------------------------------------------------
        Color color;
        /*
        double r = Math.random();
        if (r < 0.25) {
            color = Color.red;
        } else if (r < 0.5) {
            color = Color.blue;
        } else if (r < 0.75) {
            color = Color.gray;
        } else {
            color = Color.green;
        }
        */       
        System.out.println("this is the state -------- " + mainShip.getLevelState());
        //switch(launcher.getLevelState()){            
        switch(mainShip.getLevelState()) {
            case 0: color = Color.gray;
                break;
            case 1: color = Color.blue;
                break;
            case 2: color = Color.green;
                break;
            case 3: color = Color.red;
                break;
            default: color = Color.yellow;
        }
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //Missile f = new Missile(launcher.getXofMissileShoot(), launcher.getYofMissileShoot(), color);
        Missile f = new Missile(mainShip.getXofMissileShoot(), mainShip.getYofMissileShoot(), color);
        f.setTarget(x, y);
        int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
        f.setExplosionMaxSize(size);
         synchronized (Main.gameData.figures) {
            Main.gameData.figures.add(f);
        }
    }
      @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    //move into controller that handles player input
    
    //initial main not needed
    /*
    public static void main(String[] args) {
        JFrame game = new Main();
        //game.setTitle("Beggar's Canyon");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
    */
}

