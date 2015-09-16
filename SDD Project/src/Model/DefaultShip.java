/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Will
 */
public class DefaultShip implements Ship, ShipState {
    
   Image currentImage; 
   float x, y , dx, dy;
   float shipHeight, shipWidth;
   float rateOfSpeed;
   int armour;
   int shipState;
   int weaponState,weaponLevel;
   int levelState = -1; //stores weapon level state
   Rectangle[] hitBox = new Rectangle[2];
   private static HashMap<Integer,Image> defaultShipMap = new HashMap<Integer, Image>();
   int state;
    public DefaultShip(float x, float y){
    //Initialize ship here
        this.x = x;
        this.y = y;
        this.shipHeight = 50;
        this.shipWidth = 50;
        this.levelState = BASE_LEVEL; //initialze weapon level state
        this.state = STATE_OK;
       
        setShipState(0/*newShipState*/);
   
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
    
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "raider.png");
        defaultShipMap.put(0, this.currentImage);//Should be use constant NORMAL_STATE=0
        this.setShipHitBox();
    }
    
//===GetUserInput==================================================================================================
public void moveRight(int x) {
    dx = x;
}
//-----------------------------------------------------------------------------------------------------------
public void moveLeft(int x) {
    dx = x;
}
//-----------------------------------------------------------------------------------------------------------
public void moveUp(int y) {
    dy = y;
}
//-----------------------------------------------------------------------------------------------------------
public void moveDown(int y) {
    dy = y;
}
//-----------------------------------------------------------------------------------------------------------
public void setShipHitBox(){
    switch (getShipState()){
        case 0: {
            this.hitBox[0] = new Rectangle((int)this.x, (int)this.y, (int)this.shipWidth,
            (int) this.shipHeight); 
        }
    }
}
public Rectangle[] getShipHitBox(){
    return this.hitBox;
}

@Override
public void render(Graphics g){
    System.out.println("before switch------------------------");
    switch (getShipState()){
        case 0:{
            System.out.println("case 0------------------------");
            g.setColor(Color.red);
            g.drawImage(defaultShipMap.get(0), (int)x, (int)y, null);
//            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,            
                //(int) this.shipHeight);
            g.drawRect((int)this.x, (int)this.y, 100, 100);
        }
    }
}
   public void setRateOfSpeed(int newSpeed)
   {
       this.rateOfSpeed = newSpeed;
   }
   //This add to the ship's current armour.  
   //   should be only sent vailid integer
   //  as constant for the individual ships.
   public void addArmour(int armourToAdd)
   {
       this.armour = this.armour + armourToAdd;
   }
   
   public void setWeaponState(int newWeaponState)
   {
       this.weaponState = newWeaponState;
   }
   
   public void addWeaponLevel(int weaponPower)
   {
      this.weaponLevel = this.weaponLevel + weaponPower;
   }
   //This sets the ship's current state.  
   //   should be only sent integer values only
   public void setShipState(int newShipState)
   {
       this.shipState = newShipState;
   }
   public int getShipState()
   {
       return this.shipState;
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
    
    //----------------------------------------------------------------------
    //This will be used by the ship class to get and set the weapon level
    //state. 9/10/2015
    //----------------------------------------------------------------------
    // get and set the weapon level state
  @Override
    public void setLevelState(int i) {
        switch(i) {
            case -1: this.levelState = BASE_LEVEL;
                break;
            case 0: this.levelState = LEVEL_1;
                break;
            case 1: this.levelState = LEVEL_2;
                break;
            case 2: this.levelState = LEVEL_3;
        }
    }
    
   @Override
    public int getLevelState() {
        return this.levelState;
    }
//---------------------------------------------------------------------
private void updateAnimation(){
    
}
private void updateLocation(){
    
}
private void updateState(){

}
@Override
public void update(){
    updateState();
    updateLocation();
    setShipHitBox();
}

@Override
public int getState() {
    return this.state;
}

//Weapon Methods
// Missile shoot location
    public float getXofMissileShoot() {
        return x+30;
    }
    
    public float getYofMissileShoot() {
        return y+20;
    }

   
    @Override
    public void setShipType(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


 
}
