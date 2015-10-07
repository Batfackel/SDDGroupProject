/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ship;
import java.awt.Image;

/**
 *
 * @author ryan
 */
public class EnemyExplosion implements ExplosionStrategy{
    
    @Override
    public Image setExplosionImage(Ship ship) {
        //get images from the flyweight so we don't have to create a ton of images in memory
        EnemyFlyWeightFactory factory = new EnemyFlyWeightFactory();
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
                //ship doing a-ok check in the flyweight pattern to get the image
                break;
        }
        return currentImage;
    }
    
}
