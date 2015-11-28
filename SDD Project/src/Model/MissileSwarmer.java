package Model;

import Controller.Main;
import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Michael McGregor
 */
public class MissileSwarmer extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float x, y, pos, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING;
    private final boolean isEnemy;    
    double angleToTarget;
    
    private final int speeed, turn;
    private double vx = 0, vy = 0;
    private double vel;
    private final float offset;
    int count;
    
    
    public MissileSwarmer(float x, float y, boolean enemy) {
        this.pos = this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Missile Base Level";        
        this.dist = 2;        
        this.speeed = 20;
        this.turn = 6;
        this.offset = this.x;
        this.count = 0;         
       
       double target = 9999;
       //pick target
       for (int i = 0; i < Main.gameData.enemyShips.size(); i++) {
           Ship eShip = Main.gameData.enemyShips.get(i);
           if (eShip.getX() > 0 && eShip.getY() > 0) {
           double temp = Math.sqrt(Math.pow((eShip.getX() - this.x), 2) + Math.pow((eShip.getY() - this.y), 2));
           if (temp < target) {
               this.targetx = eShip.getX();
               this.targety = eShip.getY();
               target = temp;
           }
           }
       }
        
        itemImage1 = GameData.flyweightItems.setShotImage(this);

       setLauncherHitBox();       
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
        g.drawImage(itemImage1, (int)this.x, (int)this.y, (int)this.x + 20, (int)this.y + 20, 21, 5, 38, 22, null);
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();           
        //friendly shot movement
        if (isEnemy == false) {            
            
            state = STATE_TRAVELING;
            if (state == STATE_TRAVELING) {
                float dx = targetx - this.x;
                float dy = targety - this.y;

                double dist = Math.sqrt((dx * dx) + (dy * dy));

                dx /= dist;
                dy /= dist;

                vx += dx * turn;
                vy += dy * turn;

                vel = Math.sqrt((vx * vx) + (vy * vy));

                if (vel > speeed) {
                    vx = (vx * speeed) / vel;
                    vy = (vy * speeed) / vel;
                }

                this.x += vx;
                this.y += vy;

            }
            
            if (count > 50)
                state = STATE_DONE;
            else count++;
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
        g.drawString("Swarmers", (int)getX() + 25, (int)getY());
        g.drawString("Tracking missiles that stick around", (int)getX() + 25, (int)getY() + 15);
    }
}

