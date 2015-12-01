package Model;
import java.awt.Image;
/**
 *
 * @author Will
 */
import java.awt.Graphics;
import java.awt.Rectangle;

public interface Ship {

    static final int STATE_FINISHED = 0;
    static final int STATE_OK = 1;
    static final int STATE_TURNING_LEFT = 2;
    static final int STATE_TURNING_RIGHT = 3;
    static final int STATE_DAMAGED = 11;
    static final int STATE_TURNING_LEFT_DAMAGED = 12;
    static final int STATE_TURNING_RIGHT_DAMAGED = 13;
    static final int STATE_EXPLODING = 14;
  
  
    
    public int getDamagedCounter();
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
    public void setLevelState(int i);
    public int getLevelState();
    public int getShipSpeed();
    public int getShipMaxHealth();
    public int getShipMaxShield();
    public void setWeaponState(int newWeaponState);
    public int getWeaponState();
    public void addWeaponLevel(int weaponPower);
    public void setShipState(int newShipState);
    // Missile shoot location
    public float getXofMissileShoot();
    public float getYofMissileShoot();
    public int getX();
    public int getY();
    public String getShipType();
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

    public void addHealth(int i);
}