/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;

/**
 *
 * @author Will
 */
import java.awt.Graphics;
import java.awt.Rectangle;
public interface Ship {
    static final int STATE_OK = 1;
    static final int STATE_EXPLODING = 2;
    static final int STATE_FINISHED = 0;

    public void setRateOfSpeed(int newSpeed);

    public void addArmour(int armourToAdd);

    public void setWeaponState(int newWeaponState);

    public void addWeaponLevel(int weaponPower);

    public void setShipState(int newShipState);

    public void setShipHitBox();
    
    public int getShipState();
    
    public Rectangle getShipHitBox();

    public Image getImage(String fileName);

    public void update();

    public int getState();

    public void render(Graphics g);
    
    //---------------------------------Weapon Stuff
    public void setLevelState(int i);
    public int getLevelState();

    public void moveLeft();

    public void moveRight();

    public void moveUp();
    
    public void moveDown();

    public void setShipType(int i);
    // Missile shoot location
    public float getXofMissileShoot();
    public float getYofMissileShoot();
 

  
}