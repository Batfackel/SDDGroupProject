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
public class MissileBulletSwarmMother extends Bullet{
    Rectangle r1;
    Image itemImage1;
    float x, y, pos, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING;
    private boolean isEnemy;    
    double angleToTarget;  
    private int speeed, turn;
    private float offset;
    
    
    public MissileBulletSwarmMother(float x, float y, boolean enemy) {
        this.x = x;
        this.pos = this.y = y;
        this.isEnemy = enemy;
        this.name = "Missile Base Level";        
        this.dist = 2;        
        this.speeed = 20;
        this.turn = 6;
        this.offset = this.x;
       
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
        this.r1 = new Rectangle((int) this.x + 10, (int) this.y, 20, 30);  
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
        g.drawImage(itemImage1, (int)this.x, (int)this.y, (int)this.x + 40, (int)this.y + 40, 21, 5, 38, 22, null);
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();           
        //friendly shot movement
        if (isEnemy == false) {            
            
                this.y -= dist;
                if (dist < 12)
                dist += .5;
            
                if (this.y < pos - 100) {
                    Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x, y, false));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x + 10, y, false));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x, y + 10, false));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x - 10, y, false));
                    Main.gameData.friendlyBullets.add((Bullet)new MissileSwarmer(x + 10, y + 10, false));    
                    state = STATE_DONE;                                          
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
        g.drawString("Swarm Mother", (int)getX() + 25, (int)getY());
        g.drawString("Splits into deadly swarm rockets", (int)getX() + 25, (int)getY() + 15);
    }
}
