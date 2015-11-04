package Model;

import Controller.Main;
import Controller.SaveData;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ryan
 */
public class Level {

    
    private Image backgroundImage, clouds, clouds2, transitionImage, level2Image;
    private BufferedImage background;
    private static int height, width, size, x, y;
    private boolean needToDispose;
    private boolean levelComplete = false;
    public static SaveData saveData;
    public static Score currentSave;
    public Level() {
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        x = 0;
        switch (size) {
        default: backgroundImage = importImage(imagePath + separator + "images" + separator
                + "tile sets" + separator + "test tile set.png");
                clouds = importImage(imagePath + separator + "images" + separator + "tile sets" + separator + "cloudsmerged.png");
                clouds2 = importImage(imagePath + separator + "images" + separator + "tile sets" + separator + "cloudsmerged2.png");
                transitionImage = importImage(imagePath + separator + "images" + separator + "tile sets" + separator + "transition.png");
                level2Image = importImage(imagePath + separator + "images" + separator + "tile sets" + separator + "level 2.png");
                backgroundImage = clouds2;
                currentSave = new Score();
                x = 0;
                y = -2840;
                height = 800;
                width = 600;
                break;
        }
        //save = new SaveData(true);
        
        //call the save.SaveData() when the game ends(player death or closing)
    }
    
    public Level(int level) {
        
    }
    
    public static Image importImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }
    
    public void scrollLevel() {
        //move the image down
        this.y += 10;
    }
    
    public void render(Graphics g) {
        if(currentSave.getScore() >= 100) {
           Main.gamePanel.pauseGame();
           levelComplete = true;
           //clear all of the figures on the panel currently
           Main.gameData.clearData();
           //display the image for the transition
           backgroundImage = transitionImage;
           g.drawImage(backgroundImage, 0, 0, null);
        }
        
        if(levelComplete) {
            //change the background image for the level and use that instead
            levelComplete = false;
            currentSave.setScore(0);
            backgroundImage = level2Image;
        }
        else {
            g.drawImage(backgroundImage, x, y, null);
            if(this.y >= 10) {
                g.drawImage(backgroundImage, x, y-3840, null);
                if(y == 3840) {
                    y = -2840;
                }
            }
            scrollLevel();     
        }
    }
    
    public Image getImage() {
        return backgroundImage;
    }
    
    /**
     * @return the height
     */
    public static int returnHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public static int returnWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int returnSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * @return the startPositon
     */
    public static int getStartPosition() {
        return x;
    }

    /**
     * @param aStartPositon the startPositon to set
     */
    public static void setStartPositon(int aStartPosition) {
        x = aStartPosition;
    }
    
    /**
     * @return the y
     */
    public static int getY() {
        return y;
    }

    /**
     * @param aY the y to set
     */
    public static void setY(int aY) {
        y = aY;
    }
    
}
