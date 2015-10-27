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
            explosionImage11, explosionImage12, 
            balancedShipImage,balancedShipImageDamaged, balancedShipImageRight,
            balancedShipImageRightDamaged, balancedShipImageLeft,balancedShipImageLeftDamaged,
            speederShipImage, speederShipImageRight, speederShipImageLeft,
            heavyShipImage, heavyShipImageRight, heavyShipImageLeft,
            sniperShipImage, sniperShipImageRight, sniperShipImageLeft,
            battleShipImage, battleShipImageRight, battleShipImageLeft,
            fighterShipImage, fighterShipImageRight, fighterShipImageLeft,
            image;
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
        balancedShipImage = getImage(imagePath + separator + "images" + separator + "raider.png");
        balancedShipImageLeft = getImage(imagePath + separator + "images" + separator + "raider_left.png");
        balancedShipImageRight = getImage(imagePath + separator + "images" + separator + "raider_right.png");
        balancedShipImageDamaged = getImage(imagePath + separator + "images" + separator + "raiderDamaged.png");
        balancedShipImageLeftDamaged = getImage(imagePath + separator + "images" + separator + "raider_leftDamaged.png");
        balancedShipImageRightDamaged = getImage(imagePath + separator + "images" + separator + "raider_rightDamaged.png");
        
        speederShipImage = getImage(imagePath + separator + "images" + separator + "violet.png");
        speederShipImageLeft = getImage(imagePath + separator + "images" + separator + "violet_left.png");
        speederShipImageRight = getImage(imagePath + separator + "images" + separator + "violet_right.png");
        
        heavyShipImage = getImage(imagePath + separator + "images" + separator + "death.png");
        heavyShipImageLeft = getImage(imagePath + separator + "images" + separator + "death_left.png");
        heavyShipImageRight = getImage(imagePath + separator + "images" + separator + "death_right.png");

        sniperShipImage = getImage(imagePath + separator + "images" + separator + "shadow.png");
        sniperShipImageLeft = getImage(imagePath + separator + "images" + separator + "shadow_left.png");
        sniperShipImageRight = getImage(imagePath + separator + "images" + separator + "shadow_right.png");

        battleShipImage = getImage(imagePath + separator + "images" + separator + "sun.png");
        battleShipImageLeft = getImage(imagePath + separator + "images" + separator + "sun_left.png");
        battleShipImageRight = getImage(imagePath + separator + "images" + separator + "sun_right.png");

        fighterShipImage = getImage(imagePath + separator + "images" + separator + "pine.png");
        fighterShipImageLeft = getImage(imagePath + separator + "images" + separator + "pine_left.png");
        fighterShipImageRight = getImage(imagePath + separator + "images" + separator + "pine_right.png");

    }

   
    public Image setShipImage(Ship ship) {
        try {
            //get images from the flyweight so we don't have to create a ton of images in memory
            if (ship instanceof EnemyShip) {
                switch (ship.getShipState()) {
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
                        switch (ship.getShipType()) {
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
                                break;

                            default:
                            //player ships can go in here or can increase the shiptype switch to accomodate the other ships
                        }
                        break;
                }

            }
            else if (ship instanceof NewShip) {
                //if (ship instanceof NewShip) {
                switch (ship.getShipState()) {
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
                        switch (ship.getShipType()) {

                            case "defaultShip": {

                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {
                                       image = balancedShipImage;
                                       
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        
                                        image = balancedShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                       
                                        image = balancedShipImageRight;
                                        break;
                                    }
                                     case Ship.STATE_DAMAGED: {
                                       image = balancedShipImageDamaged;
                                       
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT_DAMAGED: {
                                        
                                        image = balancedShipImageLeftDamaged;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT_DAMAGED: {
                                       
                                        image = balancedShipImageRightDamaged;
                                        break;
                                    }
                                    
                                     default:{
                                        image = balancedShipImage;
                                        break;
                                     }
                                }

                                break;
                            }
                            case "shipw": {
                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {
                                        image = speederShipImage;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        image = speederShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                        image = speederShipImageRight;
                                        break;
                                    }
                                    default:
                                        image = balancedShipImage;
                                }
                                break;
                            }
                            case "shipv": {
                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {
                                        image = sniperShipImage;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        image = sniperShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                        image = sniperShipImageRight;
                                        break;
                                    }
                                    default:
                                        image = balancedShipImage;
                                }

                                break;
                            }
                            case "shipx": {
                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {
                                        image = heavyShipImage;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        image = heavyShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                        
                                        image = heavyShipImageRight;
                                        break;
                                    }
                                    
                                    default:
                                        image = balancedShipImage;
                                }

                                break;
                            }
                            case "shipy": {
                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {
                                        image = battleShipImage;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        image = battleShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                        image = battleShipImageRight;
                                        break;
                                    }
                                    default:
                                        image = balancedShipImage;
                                }

                                break;
                            }
                            case "shipz": {
                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {

                                        image = fighterShipImage;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        image = fighterShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                        image = fighterShipImageRight;
                                        break;
                                    }
                                    default:
                                        image = balancedShipImage;
                                }

                                break;
                            }
                            default: {
                                switch (ship.getState()) {
                                    case Ship.STATE_OK: {
                                        image = balancedShipImage;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_LEFT: {
                                        image = balancedShipImageLeft;
                                        break;
                                    }
                                    case Ship.STATE_TURNING_RIGHT: {
                                        image = balancedShipImageRight;
                                        break;
                                    }
                                    default:
                                        image = balancedShipImage;
                                }

                                break;
                            }
                            //player ships can go in here or can increase the shiptype switch to accomodate the other ships
                        }
                        break;
                }
            //}
            }
            
        } catch (Exception ieo) {
            System.out.println("no image");
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

    @Override
        public Image setBulletImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}    