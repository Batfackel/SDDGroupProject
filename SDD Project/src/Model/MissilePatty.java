/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author atm15_000
 */
public class MissilePatty extends Bullet{
    Rectangle r1, r2;
    Image launcherImage;
    float viX, viY, dX, dY, width1 = 110, height1 = 125, dist, targetx, targety, speed, sep;
    int state = STATE_TRAVELING, pos, count;
    private boolean isEnemy;    
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
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        launcherImage = getImage(imagePath + separator + "images" + separator
                + "mines.png");
        

        //setRectangle(); // initialize the hit box when object is created for testing   

       setLauncherHitBox();       
    }
    
    private int randomize() {
        Random rand = new Random();
        int min = -10, max = 10, number = 0;
        while (number < 2 && number > -2)
            number = rand.nextInt((max - min)) + min;

        return number;
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
        this.r1 = new Rectangle((int) this.viX, (int) this.viY, 20, 20);  
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
        g.drawImage(launcherImage, (int)this.viX, (int)this.viY, (int)this.viX + 25, (int)this.viY + 25, 0, 0, 20, 20, null);
        //----------------------------------------------------------------------
        //set up and display hit boxes for the launcher objects
        //used for dubugging 9/10/2015
        //----------------------------------------------------------------------
        g.setColor(Color.yellow);        
        g.drawRect((int) this.viX, (int) this.viY, 20, 20);        
        setLauncherHitBox();        
        //----------------------------------------------------------------------
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
                //if (dist > 15)
                //dist -= 5;
                //this.viX += pos;
        }                    
        //enemy shot movement
        else            
            this.viY += 4;
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

    public Rectangle getRectangle() {
        return this.getHitBox();
    }

    @Override
    public void renderToolTips(Graphics g) {
        g.drawString("Patty", (int)getX() + 25, (int)getY());
        g.drawString("Mines with the time", (int)getX() + 25, (int)getY() + 15);        
    }
}