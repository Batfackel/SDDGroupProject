package Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Michael McGregor
 */
public abstract class Bullet implements GameFigure{
    String name;
    int state = STATE_TRAVELING;
    abstract float getX();
    abstract float getY();
    abstract void setState();
    abstract public void render(Graphics graphics);  
    abstract public Rectangle getHitBox();     
    abstract public String getName();
    abstract public Ellipse2D getHitCircle(); 
    
    // sets the shot to enemy
    public void setIsEnemy() {
        state = 10;
    }

    void setTurn(int x1, int y1, int x2, int y2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setHit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
