
package Controller;
import Model.Context;
import Model.KineticState;
import Model.LaserState;
import Model.Missile;
import Model.MissileState;
import Model.Ship;
import Model.Sounds;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController implements MouseListener{
    //stuff for state design patters
    private Context bullet;
    private KineticState kinetic;
    private LaserState laser;
    private MissileState missile;    
    
      private Ship mainShip;
    //KeyController(){this.ship = null;}//Will Added constructor 9/16/2015
    public MouseController(Ship ship) {
        this.mainShip = (Ship) ship;
       // this.ship =  ship;
        this.bullet = new Context();
        this.kinetic = new KineticState();
        this.laser = new LaserState();
        this.missile = new MissileState();        
    }
     public void setShip(Ship ship){
        
        this.mainShip = ship;
        
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
        Sounds.sound2.play();
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
        /*                      10.6.15
        
        System.out.println("current level of the weapon: " + mainShip.getLevelState());
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
        */
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        /*                              10.6.16
        
        //Missile f = new Missile(launcher.getXofMissileShoot(), launcher.getYofMissileShoot(), color);               
        Missile f = new Missile(mainShip.getXofMissileShoot(), mainShip.getYofMissileShoot(), color);
        f.setTarget(x, y);
        int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
        f.setExplosionMaxSize(size);
         synchronized (Main.gameData.figures) {
            Main.gameData.figures.add(f);
        }
        */
        
        //----------------------------------------------------------------------
         //new weapons
         //any new weapon types added to the game will have to be registered here 
         //so that the weaponState of the ship can determine what kind of bullet to shoot
         //This is the "main" for the state design pattern. 10.6.15
        //----------------------------------------------------------------------
        System.out.println("current level of the weapon: " + mainShip.getLevelState());
        switch(mainShip.getWeaponState()) {
            case 0: 
                this.bullet.setState(kinetic, mainShip.getLevelState());
                System.out.println(this.bullet.getState().toString());
                this.bullet.fire(mainShip.getX(), mainShip.getY());
                break;
            case 1:
                this.bullet.setState(laser, mainShip.getLevelState());
                System.out.println(this.bullet.getState().toString());
                this.bullet.fire(mainShip.getX(), mainShip.getY());
                break;
            case 2:
                this.bullet.setState(missile, mainShip.getLevelState());
                System.out.println(this.bullet.getState().toString());
                this.bullet.fire(mainShip.getX(), mainShip.getY());
                break;
            default:System.out.println("error in weapon architecture");
        }                     
        //---------------------------------------------------------------------- 
        
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
   
}

