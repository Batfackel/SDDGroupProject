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
            explosionImage6, explosionImage7, explosionImage8, explosionImage9, explosionImage10,
            explosionImage11, explosionImage12, image;
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
        explosionImage1 = getImage(imagePath + separator + "images" + separator + "explosion1.png");
        explosionImage2 = getImage(imagePath + separator + "images" + separator + "explosion2.png");
        explosionImage3 = getImage(imagePath + separator + "images" + separator + "explosion3.png");
        explosionImage4 = getImage(imagePath + separator + "images" + separator + "explosion4.png");
        explosionImage5 = getImage(imagePath + separator + "images" + separator + "explosion5.png");
        explosionImage6 = getImage(imagePath + separator + "images" + separator + "explosion6.png");
        explosionImage7 = getImage(imagePath + separator + "images" + separator + "explosion7.png");
        explosionImage8 = getImage(imagePath + separator + "images" + separator + "explosion8.png");
        explosionImage9 = getImage(imagePath + separator + "images" + separator + "explosion9.png");
        explosionImage10 = getImage(imagePath + separator + "images" + separator + "explosion10.png");
        explosionImage11 = getImage(imagePath + separator + "images" + separator + "explosion11.png");
        explosionImage12 = getImage(imagePath + separator + "images" + separator + "explosion12.png");
    }
    
    @Override
    public Image setImage(Ship ship) {
        //get images from the flyweight so we don't have to create a ton of images in memory
        if(ship instanceof EnemyShip) {
            switch(ship.getShipState()) {
                case 1:
                    image = explosionImage1;
                    break;
                case 2:
                    image = explosionImage2;
                    break;
                case 3:
                    image = explosionImage3;
                    break;
                case 4:
                    image = explosionImage4;
                    break;
                case 5:
                    image = explosionImage5;
                    break;
                case 6:
                    image = explosionImage6;
                    break;
                case 7:
                    image = explosionImage7;
                    break;
                case 8:
                    image = explosionImage8;
                    break;
                case 9:
                    image = explosionImage9;
                    break;
                case 0:
                    //ship needs to be removed because it is off screen
                    image = null;
                    break;
                case 10:
                    image = explosionImage10;
                    break;
                case 11:
                    image = explosionImage11;
                    break;
                case 12:
                    image = explosionImage12;
                    break;
                case 13:
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
                            image = blueFighterImage;
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
