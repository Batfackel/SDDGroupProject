package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class TempShip implements GameFigure, ShipState {
    
    
   Image currentImage; 
   float x, y , dx, dy;
   float shipHeight, shipWidth;
   float rateOfSpeed;
   int armour;
   int shipState;
   int weaponState,weaponLevel;
   int levelState;
   int shipType;
   Rectangle[] hitBox = new Rectangle[2];
   private static HashMap<Integer,Image> defaultShipMap = new HashMap<Integer, Image>();
   
    public TempShip(float x, float y){
    //Initialize ship here
        this.x = x;
        this.y = y;
        this.rateOfSpeed = 5;
        this.shipType = 1;
        //this.shipWidth and this.shipHeight are never set so I hard coded in the values for now
        this.shipHeight = 50;
        this.shipWidth = 50;
        this.levelState = -1;
        setLevelState(this.levelState);
        setShipState(STATE_OK);
   
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
    
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "death.png");
        defaultShipMap.put(1, this.currentImage);//Should be use constant NORMAL_STATE=0
  
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "rose.png");
        defaultShipMap.put(2, this.currentImage);//Sh
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "shadow.png");
        defaultShipMap.put(3, this.currentImage);//Sh
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "pine.png");
        defaultShipMap.put(4, this.currentImage);//Sh
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "violet.png");
        defaultShipMap.put(5, this.currentImage);//Sh
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "raider.png");
        defaultShipMap.put(6, this.currentImage);//Sh
        
        //initialize hitbox
        setHitBox();
    }
    
//===GetUserInput==================================================================================================
public void moveRight() {
    x = (int) (x + this.rateOfSpeed);
    dx = x;
}
//-----------------------------------------------------------------------------------------------------------
public void moveLeft() {
    x = (int) (x - this.rateOfSpeed);
    dx = x;
}
//-----------------------------------------------------------------------------------------------------------
public void moveUp() {
     y = (int) (y - this.rateOfSpeed);
    dy = y;
}
//-----------------------------------------------------------------------------------------------------------
public void moveDown() {
    y = (int) (y + this.rateOfSpeed);
    dy = y;
}
//-----------------------------------------------------------------------------------------------------------
public void setHitBox(){
//    System.out.println("before sethitbox--------------------------------------------");
    //System.out.println(getShipState());
    switch (getShipState()){
        case 1: {
            //System.out.println("in sethitbox--------------------------------------------");
            this.hitBox[0] = new Rectangle((int)this.x, (int)this.y, (int)this.shipWidth,
            (int) this.shipHeight); 
        }
    }
}
public Rectangle getShipHitBox(){
    return this.hitBox[0];
}

public void render(Graphics g){
    //System.out.println("before switch2------------------------");
    switch (getShipState()){
        case 1:{
            //System.out.println("in switch2------------------------");
            g.setColor(Color.red);
            g.drawImage(defaultShipMap.get(this.shipType), (int)x, (int)y, null);
            //this.shipWidth and this.shipHeight are never set so I hard coded in the values for now
            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,
                (int) this.shipHeight);
        }
    }
}
    public void setShipType(int type)
    {
       this.shipType = type;
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
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    
    //----------------------------------------------------------------------
    // Missile shoot location
    //----------------------------------------------------------------------
    public float getXofMissileShoot() {
        return x+25;
    }
    
    public float getYofMissileShoot() {
        return y+25;
    }
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    
private void updateAnimation(){
    
}
private void updateLocation(){
    
}
private void updateState(){

}

public void update(){
    updateState();
    updateLocation();
    setHitBox();
}

public int getState() {
    return this.shipState;
}

    @Override
    public void setShipHitBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /*
    @Override
    public Rectangle[] getShipHitBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public int getWeaponState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getShipType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    


