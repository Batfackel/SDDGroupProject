/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
class KineticBulletRightShot extends Bullet{

    Rectangle r1, r2;
    Image itemImage1;
    float x, y, width1 = 110, height1 = 125;
    int state = STATE_TRAVELING;
    private final boolean isEnemy;
    
    public KineticBulletRightShot(float x, float y, boolean enemy) {
        this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Kinetic Right Shot";
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
        this.r1 = new Rectangle((int) this.x, (int) this.y, 15, 15);  
    }
        
    @Override
    public void render(Graphics g) {
        int width = itemImage1.getWidth(null);
        int height = itemImage1.getHeight(null);
        g.drawImage(itemImage1, (int)this.x, (int)this.y, (int)this.x + 15, (int)this.y + 15, 2, 0, 9, 11, null);        
        setLauncherHitBox();        
    }

    @Override
    public void update() {
        setLauncherHitBox();        
        //friendly shot movement
        if (isEnemy == false) {
            this.y -= 7;
            this.x += 3;
        }
        //enemy shot movement
        else {
            this.y += 7;
            this.x += 3;
        }
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
        throw new UnsupportedOperationException("A kinetic based projectile bullet.\nThe shot will shoot at a diagnol."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public Rectangle getRectangle() {
        return this.getHitBox();
    }

    @Override
    public void renderToolTips(Graphics g) {
        g.drawString("Kinetic based projectile bullet", (int)getX() + 25, (int)getY());
        g.drawString("Shot from the right of the vehicle", (int)getX() + 25, (int)getY() + 15);
    }
}
