/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class DefaultShip implements Ship {
    
   Image currentImage; 
   float x, y , dx, dy;
   float shipHeight, shipWidth;
   float rateOfSpeed;
   int armour;
   int shipState;
   int weaponState,weaponLevel;
   Rectangle[] hitBox = new Rectangle[2];
   private static HashMap<Integer,Image> defaultShipMap = new HashMap<Integer, Image>();
   
    public DefaultShip(float x, float y){
    //Initialize ship here
        this.x = x;
        this.y = y;
        setShipState(0/*newShipState*/);
   
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
    
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "raider.png");
        defaultShipMap.put(0, this.currentImage);//Should be use constant NORMAL_STATE=0
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

@Override
public void render(Graphics g){
    switch (getShipState()){
        case 0:{
            g.drawImage(defaultShipMap.get(0), (int)x, (int)y, null);
            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,
                (int) this.shipHeight);
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
    setHitBox();
}

@Override
public int getState() {
    return 0;
}
}
