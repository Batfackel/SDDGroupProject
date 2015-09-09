
import Model.ShipState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Launcher implements GameFigure, ShipState {
    
    Rectangle r1, r2;
    Image launcherImage;
    float x, y, width1 = 110, height1 = 125;
    int levelState = -1;

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
        setRectangle(); // initialize the hit box when object is created for testing
    }
    
    public static Image getImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }

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
        
        //collision debugging---------------------------------------
        g.setColor(Color.yellow);
        g.drawRect((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);
        g.setColor(Color.BLUE);
//        g.drawRect((int) this.x + 10, (int) this.y + 40, (int) this.width2, (int) this.height2);
        setRectangle();
    }

    // simple hit box
    //-------------------------------
    private void setRectangle() {
        this.r1 = new Rectangle((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);        
    }
    
    public Rectangle getRectangle1() {
        return this.r1;
    }
    //----------------------------------
    
    @Override
    public void update() 
    {
        System.out.println(levelState); //the weapon level held in the ship object, test
    //y-=1;
    }
    @Override
    public int getState() {
        return STATE_TRAVELING;
    }
    
    
}
