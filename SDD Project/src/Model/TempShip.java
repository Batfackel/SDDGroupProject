/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ShipState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author Will
 */
public class TempShip implements GameFigure{
    
    
   Image currentImage; 
   float x, y , dx, dy;
   float shipHeight, shipWidth;
   float rateOfSpeed;
   int armour;
   int shipState;
   int weaponState,weaponLevel;
   int shipType;
   Rectangle[] hitBox = new Rectangle[2];
   private static HashMap<Integer,Image> defaultShipMap = new HashMap<Integer, Image>();
   
    public TempShip(float x, float y){
    //Initialize ship here
        this.x = x;
        this.y = y;
        this.rateOfSpeed = 5;
        this.shipType = 1;
        setShipState(STATE_TRAVELING);
   
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
    switch (getShipState()){
        case 0: {
            this.hitBox[0] = new Rectangle((int)this.x, (int)this.y, (int)this.shipWidth,
            (int) this.shipHeight); 
        }
    }
}
public Rectangle[] getHitBox(){
    return this.hitBox;
}

public void render(Graphics g){
    switch (getShipState()){
        case 1:{
            g.drawImage(defaultShipMap.get(this.shipType), (int)x, (int)y, null);
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
    
}
