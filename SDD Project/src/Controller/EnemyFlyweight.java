/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ship;
import Model.AbstractItem;
import Model.Bullet;
import Model.KineticBulletBaseLevel;
import java.awt.Image;

/**
 *
 * @author ryan
 */
public interface EnemyFlyweight {
    
    public Image setShipImage(Ship ship);
    public Image setItemImage(AbstractItem item, String desc);
    public Image setBulletImage();
    public Image setShotImage(Bullet bullet);
    
}
