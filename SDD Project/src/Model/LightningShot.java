package Model;

import Controller.Main;
import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author Michael McGregor
 */
public class LightningShot extends Bullet{    
    Ellipse2D e1;    
    Image shockImage;
    float x, y;
    int state = STATE_TRAVELING;
    double radians;
    private boolean isEnemy, hit;    
    BufferedImage bufferedShockImage;
    
    public LightningShot(float x, float y, boolean enemy) {
        this.x = x;
        this.y = y;
        this.isEnemy = enemy;
        this.name = "Lightning Shot";
        this.e1 = new Ellipse2D.Float();                
        this.hit = false;                                         
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        shockImage = GameData.flyweightItems.setShotImage(this);
        bufferedShockImage = (BufferedImage) shockImage;
        //bufferedShockImage = bufferedShockImage.getSubimage(0, 0, 40, 100);        
        this.radians = 45;

       setLauncherHitBox();         
    }
    
    @Override
    public void setTurn(int x1, int y1, int x2, int y2) {
        double temp1 = (double)y2 - (double)y1;
        double temp2 = (double)x2 - (double)x1;        
        double in = temp1 / temp2;
        //double degrees = Math.toDegrees(Math.atan2(temp1, temp2));        
        double degrees = Math.toDegrees(Math.atan(in));
                //double degrees = Math.toDegrees(Math.atan((x2 - x1) / (y2 - y1)));
        this.radians = Math.toRadians(degrees - 90);        
    }       
    
    @Override
    void setHit() {
        this.hit = true;
    }
    
    private void setLauncherHitBox() {
        Ship ship = Main.gameData.ships.get(0);
        e1.setFrame(ship.getX() - 25, ship.getY() - 25, 100, 100);
    }
    
    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;     
        Ship ship = Main.gameData.ships.get(0);
        if (this.hit == true) {
        double locationX = 50;
        double locationY = 50;
        AffineTransform tx = AffineTransform.getRotateInstance(this.radians, locationX, locationY);                
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);                
        g2d.drawImage(op.filter(bufferedShockImage, null), (int)ship.getX() - 35, (int)ship.getY() - 35, null);        
        this.state = STATE_DONE;
           }
        g2d.draw(e1);
    }   
    
    @Override
    public void update() {
        setLauncherHitBox();        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ellipse2D getHitCircle() {
        return this.e1;
    }

    @Override
    public Rectangle getRectangle() {
         return new Rectangle((int)this.x, (int)this.y, 30, 30);
    }

    @Override
    public void renderToolTips(Graphics g) {        
        g.drawString("Tesla Coil", (int)getX() + 25, (int)getY());
        g.drawString("This is extrememly experimental and isn't realible", (int)getX() + 25, (int)getY() + 15);
    }

}
