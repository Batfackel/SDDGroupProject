package Model;

import Controller.Main;
import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_INIT_LEFT;
import static Model.GameFigure.STATE_INIT_RIGHT;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael McGregor
 */
public class MissileBulletSparklers extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float x, y, pos, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING;
    private final boolean isEnemy;    
    private final float offset;
    
    
    public MissileBulletSparklers(float x, float y, boolean enemy, int num) {        
        this.pos = this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Missile Base Level";        
        this.dist = 2;                
        this.offset = this.x;        
                
       if (num == 1)
        state = STATE_INIT_LEFT;
       else
        state = STATE_INIT_RIGHT;                
        
        itemImage1 = GameData.flyweightItems.setShotImage(this);

       setLauncherHitBox();       
    }   
    
    private void setLauncherHitBox() {
        this.r1 = new Rectangle((int) this.x, (int) this.y, 10, 10);  
    }
    
    public Rectangle getHitBox(){
        return this.r1;
    }
    
    @Override
    public Ellipse2D getHitCircle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void render(Graphics g) {
        int width = itemImage1.getWidth(null);
        int height = itemImage1.getHeight(null);
        g.drawImage(itemImage1, (int)this.x, (int)this.y, (int)this.x + 20, (int)this.y + 20, 21, 5, 38, 22, null);
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();           
        //friendly shot movement
        if (isEnemy == false) {            
            
            if (state == STATE_INIT_LEFT) {
                this.x-=3;
                if (this.x < offset - 30)
                    state = STATE_TRAVELING;
            } else if (state == STATE_INIT_RIGHT) {
                this.x += 3;
                if (this.x > offset + 30) {
                    state = STATE_TRAVELING;
                }
            } else if (state == STATE_TRAVELING) {                
                this.y -= dist;                                
                
                if (dist > 40) {
                    if (dist % 2 == 0)
                        Main.gameData.friendlyBullets.add((Bullet)new MissileSparkleDust(x, y + 80, false));
                }
                
                if (dist < 60)
                dist += 10;
            }                
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
        g.drawString("Sparklers", (int)getX() + 25, (int)getY());
        g.drawString("Leaves deadly shrapenel in its wake", (int)getX() + 25, (int)getY() + 15);

    }
}
