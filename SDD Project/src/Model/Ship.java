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
    static final int STATE_TURNING_LEFT = 2;
    static final int STATE_TURNING_RIGHT = 3;
    static final int STATE_EXPLODING = 4;
    static final int STATE_FINISHED = 0;


   public int getShipState();

  //getShipState()method I am unsure of if some one is using it please tell me,
  //if not I am going to delete it.
//-----------------------------------------------------------------
/*SHIP METHODS*/
//--------------------------------------------------------------------------
    public void setRateOfSpeed(int newSpeed);
    //this function set the rate of speed of the ship to the integer value
    //sent to it.

    public void addArmour(int armourToAdd);

    //addArmour fuction adds to the amout of armor of the ship to the integer
    //value sent to it.

    public void moveLeft();

    public void moveRight();

    public void moveUp();

    public void moveDown();

    public void setState(int i);

    public void setShipHitBox();

    public Rectangle getShipHitBox();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END SHIP METHODS*/
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//-------------------------------------------------------------------------
/*WEAPON METHODS*/
//--------------------------------------------------------------------------
    //---------------------------------Weapon Stuff

    public void setLevelState(int i);

    public int getLevelState();

    public void setWeaponState(int newWeaponState);

    public int getWeaponState();

    public void addWeaponLevel(int weaponPower);

    public void setShipState(int newShipState);

    // Missile shoot location
    public float getXofMissileShoot();

    public float getYofMissileShoot();

    public int getX();

    public int getY();

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END WEAPON METHODS*/
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//-------------------------------------------------------------------------
/*HELPER METHODS*/
//--------------------------------------------------------------------------
    public Image getImage(String fileName);

    public void update();

    public int getState();

    public void render(Graphics g);

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END HELPER METHODS*/
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getShipType();
    
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END HELPER METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
    
}

