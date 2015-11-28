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
public class MissilePatty extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float viX, viY, dX, dY, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING, pos, count;
    private final boolean isEnemy;    
    double angleToTarget;    
    
    public MissilePatty(float viX, float viY, float dX, float dY, boolean enemy) {
        this.viX = viX;
        this.viY = viY;
        this.dX = dX;
        this.dY = dY;
        this.isEnemy = enemy;
        this.name = "Missile Base Level"; 
        this.dist = 25;
        this.count = 0;
                  
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
        this.r1 = new Rectangle((int) this.viX, (int) this.viY, 20, 20);  
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
        g.drawImage(itemImage1, (int)this.viX, (int)this.viY, (int)this.viX + 25, (int)this.viY + 25, 0, 0, 20, 20, null);
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();           
        //friendly shot movement
        if (isEnemy == false) {                            
                this.viY -= (viY - dY) * .06; //dist, dY - viY
                this.viX -= (viX - dX) * .06;
                
                if (count > 100)
                    state = STATE_DONE;
                else count++;
        }                    
        //enemy shot movement
        else            
            this.viY += 4;
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
        return this.viX;
    }
    
    @Override
    float getY() {
        return this.viY;
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
        g.drawString("Patty", (int)getX() + 25, (int)getY());
        g.drawString("Mines with the time", (int)getX() + 25, (int)getY() + 15);        
    }
}
