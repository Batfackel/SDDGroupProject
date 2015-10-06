package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Launcher implements Ship, GameFigure, ShipState {
    
    Rectangle r1, r2;
    Image launcherImage;
    float x, y, width1 = 110, height1 = 125;
    int levelState = -1;

    private int state = STATE_TRAVELING;
    //HUD hud; 
    

    //private int state = GameFigure.STATE_TRAVELING;


    public Launcher(float x, float y) {
      
        this.x = x;
        this.y = y;
        this.levelState = BASE_LEVEL;
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
                + "TestShip.png");

        //setRectangle(); // initialize the hit box when object is created for testing   

       setLauncherHitBox(); // initialize the hit box when object is created for testing

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
    //"* 3" is to make up for the health bar length. 
    // public static int maxHealth = 100 ;
     /*int health = maxHealth;*/
//     int currentHealth = maxHealth;
      
    
    // Missile shoot location
    public float getXofMissileShoot() {
        return x+30;
    }
    
    public float getYofMissileShoot() {
        return y+20;
    }

    @Override
    public void render(Graphics g) {  
        g.drawImage(launcherImage, (int)x, (int)y, null);
        
        //----------------------------------------------------------------------
        //set up and display hit boxes for the launcher objects
        //used for dubugging 9/10/2015
        //----------------------------------------------------------------------
        g.setColor(Color.yellow);
        g.drawRect((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);
        g.setColor(Color.BLUE);
        setLauncherHitBox();        
        g.setColor(Color.BLUE);     
        //----------------------------------------------------------------------
        
    }
    
    //----------------------------------------------------------------------
    //getters and setter for the launcher hit box
    //9/10/2015
    //----------------------------------------------------------------------
    // simple hit box for the launcher object
    private void setLauncherHitBox() {
        this.r1 = new Rectangle((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);        
    }
    // get ht box
    public Rectangle getShipHitBox(){
        return this.r1;
    }
    //----------------------------------------------------------------------
    //This will be used by the ship class to get and set the weapon level
    //state. 9/10/2015
    //----------------------------------------------------------------------
    // get and set the weapon level state
    @Override
    public void setLevelState(int i) {
        this.levelState = i;
    }
    
    @Override
    public int getLevelState() {
        return this.levelState;
    }
    
    //----------------------------------------------------------------------
    @Override
    public void update() 
    {   
    setLauncherHitBox();        
    }
    @Override
    public int getState() {
        return state;
    }
   
    public void useItem(){
        state = GameFigure.STATE_DONE;
    }

    @Override
    public void setRateOfSpeed(int newSpeed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addArmour(int armourToAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWeaponState(int newWeaponState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addWeaponLevel(int weaponPower) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShipState(int newShipState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShipHitBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getShipState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setShipType(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWeaponState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
