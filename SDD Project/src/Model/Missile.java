package Model;


import static Model.Item.getImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.vecmath.Vector2f;
import javax.imageio.ImageIO;
import java.io.File;

public class Missile extends Ellipse2D.Float implements GameFigure {
    Image currentImage; 
    static int SIZE = 2;
    Color color;
    Point2D.Float target;
    private int state = GameFigure.STATE_TRAVELING;
    private static final int UNIT_TRAVEL_DISTANCE = 4;
    private int explosionSize = SIZE;
    private int explosionMaxSize;
    String imagePath = System.getProperty("user.dir");
    String separator = System.getProperty("file.separator");
    
    public Missile(float x, float y, Color color) {
        setFrameFromCenter(x, y, x + SIZE, y + SIZE);
        this.color = color;
        currentImage = getImage(imagePath + separator + "images" + separator + "missile.jpg");
    }

    public void setTarget(float x, float y) {
        target = new Point2D.Float(x, y);
    }
    
    public void setExplosionMaxSize(int size) {
        explosionMaxSize = size;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int)super.x, (int)super.y, (int)super.width, (int)super.height);
    }

    @Override
    public void update() {
        updateState();
        if (state == STATE_TRAVELING) {
            updateLocation();
        } else if (state == STATE_EXPLODING) {
            updateSize();
        }
    }

    // Vector arithmetic
    // A: current position
    // B: target position
    // d: distance to travel along the line from A to B
    //     A_moved = A + |B - A| * d where |  | represents 'norm'
    public void updateLocation() {
        Vector2f currentLoc = new Vector2f((float) getCenterX(), (float) getCenterY());
        Vector2f update = new Vector2f(target.x, target.y);
        update.sub(currentLoc); // B - A
        update.normalize(); // |B - A|
        update.scale(UNIT_TRAVEL_DISTANCE); // |B - A| x dist
        currentLoc.add(update); // A + |B - A| x d

        setFrameFromCenter(currentLoc.x, currentLoc.y,
                currentLoc.x + SIZE, currentLoc.y + SIZE);
    }

    public void updateSize() {
        double x = target.getX();
        double y = target.getY();
        explosionSize += 2;
        setFrameFromCenter(x, y, x + explosionSize, y + explosionSize);
    }

    public void updateState() {
        if (state == STATE_TRAVELING) {
            double distance = target.distance(getCenterX(), getCenterY());
            boolean targetReached = distance <= 2.0 ? true : false;
            if (targetReached) {
                state = STATE_EXPLODING;
            }
        } else if (state == STATE_EXPLODING) {
            if (explosionSize >= explosionMaxSize) {
                state = STATE_DONE;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public int getState() {
        return state;
    }

}
