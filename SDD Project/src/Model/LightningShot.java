/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Main;
import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author atm15_000
 */
public class LightningShot extends Bullet{
        //Rectangle r1, r2;
        Ellipse2D e1, e2;
        AffineTransformOp op;
    Image shockImage;
    float x, y, width1 = 110, height1 = 125;
    int state = STATE_TRAVELING;
    int drawX, drawY;
    
    public LightningShot(float x, float y) {
        this.x = x;
        this.y = y;
        this.name = "Lightning Shot";
        this.e1 = new Ellipse2D.Float();        
        this.drawX = 300;
        this.drawY = 300;
                                 
        double rotationRequired = Math.toRadians(45);    
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        shockImage = getImage(imagePath + separator + "images" + separator+ "shocking.png");
        
        double locationX = shockImage.getWidth(null) / 2;
        double locationY = shockImage.getHeight(null) / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX);
        this.op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        //setRectangle(); // initialize the hit box when object is created for testing   

       setLauncherHitBox();
    }
    
    public Image getImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }
    
    private void setLauncherHitBox() {
        //this.r1 = new Rectangle((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);        
        //this.r1 = new Rectangle((int) this.x, (int) this.y, 10, 10);  
        e1.setFrame(this.x, this.y, this.width1, this.height1);              
        e1.setFrame(this.x, this.y, 200, 200);  
        Ship ship = Main.gameData.ships.get(0);
        e1.setFrame(ship.getX() - 80, ship.getY() - 80, 200, 200);
    }
    
    @Override
    public void render(Graphics g) {
        //int width = shockImage.getWidth(null);
        //int height = shockImage.getHeight(null);
        //g.drawImage(launcherImage, (int)x, (int)y, null);
        g.drawImage(shockImage, (int)this.x, (int)this.y, (int)this.x + 40, (int)this.y + 100, 0, 0, 40, 100, null);        
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(e1);
        g2.drawImage(op.filter((BufferedImage)shockImage, null), 200, 200, null);
        //g.drawImage(op.filter((BufferedImage)shockImage, null), 200, 200, null);
        //----------------------------------------------------------------------
        //set up and display hit boxes for the launcher objects
        //used for dubugging 9/10/2015
        //----------------------------------------------------------------------
        //g.setColor(Color.yellow);
        //g.drawRect((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);
        //g.drawRect((int) this.x, (int) this.y, 10, 10);
        //g.setColor(Color.BLUE);
        setLauncherHitBox();        
        //g.setColor(Color.BLUE);     
        //----------------------------------------------------------------------
    }

    @Override
    public void update() {
        setLauncherHitBox();        
        //this.y -= 5;
        //if (this.x < 1){
        //    System.out.println("bullet = " + this.x);
        //    this.state = STATE_DONE;
        //}
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
