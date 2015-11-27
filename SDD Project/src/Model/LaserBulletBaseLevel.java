package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Michael McGregor
 */
public class LaserBulletBaseLevel extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float x, y;
    private final boolean isEnemy;
    
    public LaserBulletBaseLevel(float x, float y, boolean enemy) {
        this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Laser Base Shot";        
        
        itemImage1 = GameData.flyweightItems.setShotImage(this);

       setLauncherHitBox();
    }
    
    private void setLauncherHitBox() {
        this.r1 = new Rectangle((int) this.x, (int) this.y, 10, 10);  
    }           
    
    @Override
    public void render(Graphics g) {
        int width = itemImage1.getWidth(null);
        int height = itemImage1.getHeight(null);
        g.drawImage(itemImage1, (int)this.x, (int)this.y, (int)this.x + 20, (int)this.y + 35, 5, 5, 18, 40, null);        
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();   
        //friendly shot movement
        if (isEnemy == false)
            this.y -= 15;
        //enemy shot movement
        else
            this.y += 15;
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
    public Rectangle getHitBox() {
        return this.r1;
    }

    @Override
    public Ellipse2D getHitCircle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Rectangle getRectangle() {
        return this.getHitBox();
    }

    @Override
    public void renderToolTips(Graphics g) {        
        g.drawString("Laser weapons are a new addition to the military's arsenal", (int)getX() + 25, (int)getY());
        g.drawString("They shoot in a continuous beam.", (int)getX() + 25, (int)getY() + 15);
    }
}
