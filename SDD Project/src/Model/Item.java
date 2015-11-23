package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * This is a general purpose item class. Feel free to build use this with child
 * classes to make new items for the game
 *
 * @author Michael McGregor
 */
class Item implements GameFigure, AbstractItem{

    private float x, y;
    private final float movementX, movementY;
    protected int itemType;
    Image itemImage;
    Rectangle r1;
    private int state = STATE_TRAVELING;
    private final int picX1, picX2, picY1, picY2;               
    
    public Item(float x, float y, int ref, int startX, int endX, int startY, int endY) {
        this.x = x;
        this.y = y;
        this.picX1 = startX;
        this.picX2 = endX;
        this.picY1 = startY;
        this.picY2 = endY;
        this.movementX = randomizeX();
        this.movementY = randomizeY();
        
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
                + "itemSample.png");
        //itemImage = GameData.flyweightItems.setItemImage(this);
        
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
        g.drawImage(itemImage, (int)x, (int)y, (int)x + 40, (int)y + 40, this.picX1, this.picX2, this.picY1, this.picY2, null, null);        
        g.setColor(Color.red);
        g.drawRect((int) this.x + 5, (int) this.y + 5, 28, 28);        
    }

    private float randomizeX() {
        Random rand = new Random();
        return rand.nextFloat() * (3 - (-3)) + (-3);
    }
    
    private float randomizeY() {
        Random rand = new Random();
        return rand.nextFloat() * 3;
    }
    
    private void setRectangle() {
        this.r1 = new Rectangle((int) this.x + 5, (int) this.y + 10, 28, 28);        
    }
    
    public Rectangle getRectangle1() {
        return this.r1;
    }   
    
    public int getItemType() {
        return this.itemType;
    }
    
    @Override
    public void update() {
        setRectangle();       
        this.x += this.movementX;
        this.y += this.movementY;
        if (this.x > 850 || this.y > 1050){
            System.out.println(this.x);
            this.state = STATE_DONE;
        }
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public int getItem() {
        return this.itemType;
    }

    @Override
    public void setItem(int item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void timeout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle getRectangle() {
        return this.getRectangle1();
    }

    @Override
    public void renderToolTips(Graphics g) {
        g.drawString(getText(), (int)x, (int)y);
    }

    protected String getText() {
        throw new UnsupportedOperationException("Items"); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
