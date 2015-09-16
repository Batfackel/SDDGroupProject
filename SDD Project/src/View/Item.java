
import View.AbstractItem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author atm15_000
 */
class Item implements GameFigure, AbstractItem{

    private float x, y, width1 = 110, height1 = 125;
    protected int itemType;
    Image itemImage;
    Rectangle r1, r2;
    
    public Item(float x, float y) {
        this.x = x;
        this.y = y;
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
    
        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        itemImage = getImage(imagePath + separator + "images" + separator
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
    
    @Override
    public void render(Graphics g) {
        g.drawImage(itemImage, (int)x, (int)y, null);
        g.setColor(Color.red);
        g.drawRect((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);        
    }

    //----------------------------------------------------------------------
    //getters and setter for the launcher hit box
    //9/10/2015
    //----------------------------------------------------------------------
    // simple hit box for the launcher object
    private void setRectangle() {
        this.r1 = new Rectangle((int) this.x + 5, (int) this.y + 10, (int) this.width1, (int) this.height1);        
    }
    // get ht box
    public Rectangle getRectangle1() {
        return this.r1;
    }
    //----------------------------------------------------------------------
    
    @Override
    public void update() {
        setRectangle();
    }

    @Override
    public int getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setItem(int item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void timeout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
