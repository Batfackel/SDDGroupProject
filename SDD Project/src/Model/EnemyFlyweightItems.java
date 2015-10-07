/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EnemyFlyweight;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ryan
 */
public class EnemyFlyweightItems implements EnemyFlyweight {
    Image defaultImage, redFighterImage, alienImage, blueFighterImage, purpleFighterImage,
            explosionImage1, explosionImage2, explosionImage3, explosionImage4, explosionImage5, 
            explosionImage6, explosionImage7, explosionImage8, explosionImage9, image;
    String shipType;
    
    
    public EnemyFlyweightItems() {
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        defaultImage = getImage(imagePath + separator + "images" + separator + "Enemies" + separator + "defaultEnemyShip.png");
        redFighterImage = getImage(imagePath + separator + "images" + separator + "Enemies" + separator + "redFighter.png");
        alienImage = getImage(imagePath + separator + "images" + separator + "Enemies" + separator + "alien1.png");
        blueFighterImage = getImage(imagePath + separator + "images" + separator + "Enemies" + separator + "blueFighter.png");
        purpleFighterImage = getImage(imagePath + separator + "images" + separator + "Enemies" + separator + "purpleFighter.png");
        
    }
    
    @Override
    public Image setImage(Ship ship) {
        //get images from the flyweight so we don't have to create a ton of images in memory
        if(ship instanceof DefaultEnemyShip) {
            switch(ship.getShipState()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    //ship needs to be removed because it is off screen
                    break;
                case 10:
                    //ship doing a-ok 
                    switch(ship.getShipType()) {
                        case "alien1":
                            image = alienImage;
                            break;
                        case "redFighter":
                            image = redFighterImage;
                            break;
                        case "purpleFighter":
                            image = purpleFighterImage;
                            break;
                        case "blueFighter":
                            image = purpleFighterImage;
                            break;
                        case "defaultEnemyShip":
                            image = defaultImage;
                        default:
                            //player ships can go in here or can increase the shiptype switch to accomodate the other ships
                    }
                    break;
            }
        }
        return image;
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
}
