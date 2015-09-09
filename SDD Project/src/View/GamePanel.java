
import Model.Level;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
      
    private Animator animator;
    private GameData gameData;
    // off screen rendering
    private Graphics graphics;
    private Image dbImage = null;
    private Level level;

    public GamePanel(Animator animator, GameData gameData) {
        this.animator = animator;
        this.gameData = gameData;
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");

        // put images in 'images' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "image"
        // You cannot see "images" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        level = new Level();   
        setBackground(Color.blue);
        setPreferredSize(new Dimension(getWidth(), getHeight()));
    }

    public void startGame() {
        Thread t = new Thread(animator);
        t.start();
    }

    
    /*public void Tetris()
    {
       Launcher launcher;
       //Test Area V================================================================================
       int x=0; 
        x++;
         if (x==3)
         {
        launcher = (Launcher) gameData.figures.get(0); // launcher
         System.out.println("Your dumb");
         } 
       //Test Area^================================================================================ 
    }*/
    public void gameRender() {
        if (dbImage == null) {
            dbImage = createImage(getWidth(), getHeight());
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = dbImage.getGraphics();
            }
        }
            
        graphics.clearRect(0, 0, Level.returnWidth(), Level.returnHeight());
        //draw the background image
        level.render(graphics);

        synchronized (gameData.figures) {
            GameFigure f;
            for (int i = 0; i < gameData.figures.size(); i++) {
                f = (GameFigure) gameData.figures.get(i);
                f.render(graphics);
            }
        }
        level.scrollLevel();
    }

    public void printScreen() { // use active rendering to put the buffered image on-screen
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            g.dispose();
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
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
    
    public void setGameSize(int height, int width) {
        //called and sets the size of the game so the panel knows which image to go and use
        
    }
}
