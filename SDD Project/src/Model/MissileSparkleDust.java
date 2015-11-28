package Model;

import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author Michael McGregor
 */
public class MissileSparkleDust extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float x, y, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING, pos;
    private final boolean isEnemy;    
    double angleToTarget;    
    
    public MissileSparkleDust(float x, float y, boolean enemy) {
        this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Missile Base Level"; 
        this.dist = 25;
                  
        this.pos = this.randomize();        
        itemImage1 = GameData.flyweightItems.setShotImage(this);

       setLauncherHitBox();       
    }
    
    private int randomize() {
        Random rand = new Random();
        int min = -10, max = 10, number = 0;
        while (number < 2 && number > -2)
            number = rand.nextInt((max - min)) + min;

        return number;
    }    
    
    private void setLauncherHitBox() {
        this.r1 = new Rectangle((int) this.x, (int) this.y, 10, 10);  
    }
    
    @Override
    public Rectangle getHitBox(){
        return this.r1;
    }
    
    @Override
    public Ellipse2D getHitCircle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void render(Graphics g) {          
        g.drawImage(itemImage1, (int)this.x, (int)this.y, (int)this.x + 10, (int)this.y + 10, 18, 21, 26, 29, null);
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();           
        //friendly shot movement
        if (isEnemy == false) {                            
                this.y -= dist;
                if (dist > 15)
                dist -= 5;
                this.x += pos;
        }                    
        //enemy shot movement
        else            
            this.y += 4;
    }

    @Override
    public int getState() {
        return state;
        
    }

    @Override
    void setState() {
        state = STATE_DONE;
    }

    @Override
    float getX() {
        return this.x;
    }
    
    @Override
    float getY() {
        return this.y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Rectangle getRectangle() {
        return this.getHitBox();
    }

    @Override
    public void renderToolTips(Graphics g) {
        g.drawString("Dust", (int)getX() + 25, (int)getY());
        g.drawString("Created from the Sparkler rockets and deadly", (int)getX() + 25, (int)getY() + 15);
    }
}

