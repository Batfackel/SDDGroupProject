package Model;


import java.awt.Graphics;
import java.awt.Rectangle;

public interface GameFigure {
    //is this level state in the ships or ship state in the ships
    public void render(Graphics g);
    public void update();
    public int getState();
    public Rectangle getRectangle();
    public void renderToolTips(Graphics g);
    static final int STATE_TRAVELING = 1;
    static final int STATE_EXPLODING = 2;
    static final int STATE_DONE = 0;
    static final int STATE_INIT_LEFT = 3;
    static final int STATE_INIT_RIGHT = 4;
    
} 
