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
public interface ExplosionStrategy {
    
    Image currentImage = null;
    
    public Image setExplosionImage(Ship ship);
    
}
