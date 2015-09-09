
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Launcher implements GameFigure {
    
    
    float x, y;

    public Launcher(float x, float y) {
        this.x = x;
        this.y = y;
        
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
        //g.drawImage(launcherImage, (int)x, (int)y, null);
    }

    @Override
    public void update() 
    {
    //y-=1;
    }
    @Override
    public int getState() {
        return STATE_TRAVELING;
    }
}
