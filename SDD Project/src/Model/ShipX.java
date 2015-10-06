package Model;
import Model.Ship;
import static Model.Ship.STATE_OK;
import Model.ShipState;
import static Model.ShipState.BASE_LEVEL;
import static Model.ShipState.LEVEL_1;
import static Model.ShipState.LEVEL_2;
import static Model.ShipState.LEVEL_3;
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
public class ShipX implements Ship, ShipState {
    
  Image currentImage; 
   float x, y , dx, dy;
   float shipHeight, shipWidth;
   float rateOfSpeed;
   int armour;
   int shipState;
   int weaponState,weaponLevel;
   int levelState = BASE_LEVEL; //stores weapon level state
   Rectangle[] hitBox = new Rectangle[2];
   private static HashMap<Integer,Image> defaultShipMap = new HashMap<Integer, Image>();
   int state;
   int explosionState;
   private Image eSheet;
   private int shipHealth;
   private int shipImageToUse;
  
   public ShipX(float x, float y){
      
       state = 1; 
   
       
    //Initialize ship here
        this.x = x;
        this.y = y;
        this.shipHeight = 50;
        this.shipWidth = 50;
        this.shipImageToUse = 1;
        this.explosionState=1;
        this.levelState = BASE_LEVEL; //initialze weapon level state
        this.state = STATE_OK;
        //needs a default speed otherwise I don't know how far to move
        this.rateOfSpeed = 10;
        this.weaponState = 0; //initialze to kinetic weapon
        setShipState(0/*newShipState*/);
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
    
        
        this.eSheet = getImage(imagePath + separator + "images" + 
            separator +"explosionsheet.png");
        //----------------------------------------------------------------------------------------------------
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "violet.png");
        defaultShipMap.put(1, this.currentImage);//Should be use constant NORMAL_STATE=0
        this.setShipHitBox();
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "raider_left.png");
        defaultShipMap.put(2, this.currentImage);//Should be use constant NORMAL_STATE=0
        this.setShipHitBox();
        
        this.currentImage = getImage(imagePath + separator + "images" + 
            separator + "raider_right.png");
        defaultShipMap.put(3, this.currentImage);//Should be use constant NORMAL_STATE=0
        this.setShipHitBox();
        
        
        
        
        
        //----------------------------------------------------------------------------------------------------
    }
   
//-------------------------------------------------------------------------
/*SHIP METHODS*/
//-------------------------------------------------------------------------   
      @Override
    public void moveLeft() {
    x = (int) (x - this.rateOfSpeed);
    dx = x;
    }

    @Override
    public void moveRight() {
    x = (int) (x + this.rateOfSpeed);
    dx = x;
    }

    @Override
    public void moveUp() {
    y = (int) (y - this.rateOfSpeed);
    dy = y;
    }

    @Override
    public void moveDown() {
    y = (int) (y + this.rateOfSpeed);
    dy = y;
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
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END SHIP METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   
   
 //-------------------------------------------------------------------------
/*HITBOX METHODS*/
//-------------------------------------------------------------------------   
    
     ShipX() {
     this.shipHealth = 50;
 }  //Will someone tell me what this is for.  I know what is does, but I don't
    //who or why someone put an additional constructor that does not initalize
    //anything but the health of the ship.
    
 public int getShipHealth() {
     return this.shipHealth;
 }

public void setShipHitBox(){
    switch (getState()){
        case 1: {
            this.hitBox[0] = new Rectangle((int)this.x, (int)this.y, (int)this.shipWidth,
            (int) this.shipHeight); 
        }
    }
}
public Rectangle getShipHitBox(){
    return this.hitBox[0];
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END HITBOX METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
@Override
public void render(Graphics g){
    
   
    //System.out.println("before switch------------------------");
    
    switch (getState()){
        case 1:{  //flying normally
           //System.out.println("case 0------------------------");
          g.setColor(Color.red);
            g.drawImage(defaultShipMap.get(shipImageToUse), (int)x, (int)y, null);
//            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,            
                //(int) this.shipHeight);
          //  g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
             System.out.println("Normal State="+this.state+" and explosionState = " + this.explosionState);
            break;
        }
        case 2:{
             g.setColor(Color.red);
            g.drawImage(defaultShipMap.get(shipImageToUse), (int)x, (int)y, null);
//            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,            
                //(int) this.shipHeight);
           // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
             System.out.println("Normal State="+this.state+" and explosionState = " + this.explosionState);
            break;
        }
         case 3:{
             g.setColor(Color.red);
             g.drawImage(defaultShipMap.get(shipImageToUse), (int)x, (int)y, null);
//            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,            
                //(int) this.shipHeight);
            //g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);          
            break;
        }
          case 4:{//Dying       
       
              switch (this.explosionState) {
                
                case GameData.STATE_EXPLOSIOIN_1: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 0, 0, 64, 64, null, null);
                   // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_2: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 64, 0, 128, 64, null, null);
                  //  g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_3: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 128, 0, 192, 64, null, null);
                   // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_4: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 192, 0, 256, 64, null, null);
                  //  g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_5: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 0, 64, 64, 128, null, null);
                  //  g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_6: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 64, 64, 128, 128, null, null);
                  //   g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_7: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 128, 64, 192, 128, null, null);
                 //  g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_8: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 192, 64, 256, 128, null, null);
                   // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_9: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 0, 128, 64, 192, null, null);
                   // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_10: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 64, 128, 128, 192, null, null);
                    // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_11: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 128, 128, 192, 192, null, null);
                   // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_12: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 192, 128, 256, 192, null, null);
                    // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_13: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 0, 192, 64, 256, null, null);
                   //  g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_14: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 64, 192, 128, 256, null, null);
                    // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_15: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 128, 192, 192, 256, null, null);
                    // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
                case GameData.STATE_EXPLOSIOIN_16: {
                    g.drawImage(eSheet, (int) x, (int) y, (int) x + 100, (int) y + 100, 192, 192, 256, 256, null, null);
                   // g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth, (int)this.shipHeight);
                    break;
                }
              
            }

            break;
        }
    }
     
   
}
private boolean isMovingHorizontal() {

        if (dx != 0) {
            return true;
        } else {
            return false;
        }
    }

    private void updateFlightAnimation() {
        if (isMovingHorizontal()) {

            if (dx < 0)//moving Left
            {
                setState(2);
                shipImageToUse = 2;
            
            }
            else // moving right
            {
                setState(3);
                 shipImageToUse = 3;
            }
           
        }
        else   //no horizontal movement
        {
            setState(1);
            shipImageToUse = 1;
        }

    }
   
//-------------------------------------------------------------------------
/*WEAPON METHODS*/
//-------------------------------------------------------------------------   
//Weapon Methods
// Missile shoot location
    public float getXofMissileShoot() {
        return x+30;
    }
    
    public float getYofMissileShoot() {
        return y+20;
    }
   
   public void setWeaponState(int newWeaponState)
   {
       this.weaponState = newWeaponState;
   }
   public int getWeaponState() {
       return this.weaponState;
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
  //-------------------------------------------------------------------------  
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

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END SHIP METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 


private void updateExplosionAnimation(){
    
        if (this.explosionState < 17) {
            this.explosionState++;
        } else {
            this.state = 0/*STATE_DONE*/;
        }

}
private void updateLocation(){
    
}
private void updateState(){
 //    updateFlightAnimation();
}


@Override
public void update(){
     updateState();
      if (state == 1/*STATE_NORMAL*/) {
            updateLocation();
            setShipHitBox();
        } else if (state == 4/*STATE_EXPLODING*/) {
            updateExplosionAnimation();
        } 
    updateLocation();
    setShipHitBox();
}
@Override
public void setState(int newState){
    this.state = newState;
}
@Override
public int getState() {
    return this.state;
}
//-------------------------------------------------------------------------
/*STATE AND ANIMATION METHODS*/
//-------------------------------------------------------------------------   
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*STATE AND ANIMATION METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
//-------------------------------------------------------------------------
/*HELPER METHODS*/ 
//-------------------------------------------------------------------------
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
<<<<<<< HEAD

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


 
=======
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END HELPER METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
>>>>>>> d5346a101e5cf8ecd43973f315a5ab4ff3dbd4df
}
