package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 * This is a general purpose item class. Feel free to build use this with child
 * classes to make new items for the game
 *
 * @author Michael McGregor
 */
class Item implements GameFigure, AbstractItem {

    private float x, y;
    private final float movementX, movementY;
    protected int itemType;
    private final Image itemImage1, itemImage2;
    private Rectangle r1;
    private int state = STATE_TRAVELING, timer;
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
        this.timer = 1;

        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");

        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though       
        itemImage1 = GameData.flyweightItems.setItemImage(this, "full");
        itemImage2 = GameData.flyweightItems.setItemImage(this, "trans");
        setRectangle(); // initialize the hit box when object is created for testing
    }

    @Override
    public void render(Graphics g) {
        if (timer < 3 || timer > 5) {
            g.drawImage(itemImage1, (int) x, (int) y, (int) x + 40, (int) y + 40, this.picX1, this.picX2, this.picY1, this.picY2, null, null);
        } else {
            g.drawImage(itemImage2, (int) x, (int) y, (int) x + 40, (int) y + 40, this.picX1, this.picX2, this.picY1, this.picY2, null, null);
        }
        //g.setColor(Color.red);
        //g.drawRect((int) this.x + 10, (int) this.y + 10, 15, 15);
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
        this.r1 = new Rectangle((int) this.x + 10, (int) this.y + 10, 15, 15);
    }

    public Rectangle getRectangle1() {
        return this.r1;
    }

    @Override
    public int getItemType() {
        return this.itemType;
    }

    @Override
    public void update() {
        setRectangle();
        timeout();
        this.x += this.movementX;
        this.y += this.movementY;
        if (this.x > 850 || this.y > 1050) {
            this.state = STATE_DONE;
        }
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void setItem(int item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void timeout() {
        timer++;
        if (timer == 10) {
            timer = 1;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return this.getRectangle1();
    }

    @Override
    public void renderToolTips(Graphics g) {
        g.drawString(getText(), (int) x, (int) y);
    }

    protected String getText() {
        throw new UnsupportedOperationException("Items"); //To change body of generated methods, choose Tools | Templates.
    }
}
