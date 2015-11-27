package Model;

import Controller.Main;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Michael McGregor
 */
public class MissileBulletBaseLevel extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float x, y, pos, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING;
    private final boolean isEnemy;    
    double angleToTarget;
    
    private final int speeed, turn;    
    private final float offset;
    
    
    public MissileBulletBaseLevel(float x, float y, boolean enemy, int num) {
        this.pos = this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Missile Base Level";        
        this.dist = 2;        
        this.speeed = 20;
        this.turn = 6;
        this.offset = this.x;
                
       if (num == 1)
        state = STATE_INIT_LEFT;
       else
        state = STATE_INIT_RIGHT;   
       
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
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        
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
                if (dist < 25)
                dist += 7;
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
        g.drawString("These missiles are common among military craft.", (int)getX() + 25, (int)getY());
        g.drawString("They have minor tracking abilities.", (int)getX() + 25, (int)getY() + 15);
    }
}
