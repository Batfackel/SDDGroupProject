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
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Will
 */
public class NewShip implements Ship, ShipState {

    private float x, y, dx, dy, shipHeight, shipWidth;
    private int state, levelState, rateOfSpeed, armour, shipState, weaponState, weaponLevel, health;
    private String shipType;
    private Image shipImage;
    Rectangle[] hitBox = new Rectangle[2];

    NewShip(float x, float y) {
        this.x = x;
        this.y = y;
        this.levelState = BASE_LEVEL;
        this.state = STATE_OK;
        this.rateOfSpeed = 2;
        setShipState(13);
        this.setShipHitBox();
    }

    NewShip(String shipType, float x, float y) {
        this.x = x;
        this.y = y;
        this.levelState = BASE_LEVEL;
        this.state = STATE_OK;
        //this.rateOfSpeed = 2;
        setShipState(13);
        this.shipType = shipType;
        shipImage = GameData.flyweightItems.setImage(this);
        this.shipHeight = shipImage.getHeight(null);
        this.shipWidth = shipImage.getWidth(null);
        //this.shipHeight = 64;
        //this.shipWidth = 64;
        switch (shipType) {
            case "defaultship":
                this.health = 4;
                this.rateOfSpeed = 10;
                break;
            case "shipv":
                this.health = 2;
                this.rateOfSpeed = 30;
                break;
            case "shipw":
                this.health = 10;
                this.rateOfSpeed = 5;
                break;
            case "shipx":
                this.health = 3;
                this.rateOfSpeed = 10;
                break;
            case "shipy":
                this.health = 8;
                this.rateOfSpeed = 8;
                break;
            case "shipz":
                this.health = 3;
                this.rateOfSpeed = 20;
                break;
            default:
                this.health = 5;
                this.rateOfSpeed = 10;
                break;
        }
        this.setShipHitBox();
    }

    @Override
    public int getShipState() {
        return this.shipState;
    }

    @Override
    public void setRateOfSpeed(int newSpeed) {
        this.rateOfSpeed = newSpeed;
    }

    @Override
    public void addArmour(int armourToAdd) {
        this.armour = this.armour + armourToAdd;
    }

    @Override
    public void moveLeft() {
        
        x = (int) (x - this.rateOfSpeed);
        dx = -x;
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

    @Override
    public void setState(int i) {
        this.state = i;
    }

    @Override
    public void setShipHitBox() {
        switch (getState()) {
            case STATE_OK: {
                this.hitBox[0] = new Rectangle((int) this.x, (int) this.y, (int) this.shipWidth,
                        (int) this.shipHeight);
            }
            case STATE_TURNING_LEFT: {
                this.hitBox[0] = new Rectangle((int) this.x, (int) this.y, (int) this.shipWidth,
                        (int) this.shipHeight);
            }
            case STATE_TURNING_RIGHT: {
                this.hitBox[0] = new Rectangle((int) this.x, (int) this.y, (int) this.shipWidth,
                        (int) this.shipHeight);
            }
        }
    }

    @Override
    public Rectangle getShipHitBox() {
        return this.hitBox[0];
    }

    @Override
    public void setLevelState(int i) {
        switch (i) {
            case -1:
                this.levelState = BASE_LEVEL;
                break;
            case 0:
                this.levelState = LEVEL_1;
                break;
            case 1:
                this.levelState = LEVEL_2;
                break;
            case 2:
                this.levelState = LEVEL_3;
        }
    }

    @Override
    public int getLevelState() {
        return this.levelState;
    }

    @Override
    public void setWeaponState(int newWeaponState) {
        this.weaponState = newWeaponState;
    }

    @Override
    public int getWeaponState() {
        return this.weaponState;
    }

    @Override
    public void addWeaponLevel(int weaponPower) {
        this.weaponLevel = this.weaponLevel + weaponPower;
    }

    @Override
    public void setShipState(int newShipState) {
        this.shipState = newShipState;
    }

    @Override
    public int getX() {
        return (int) x;
    }

    @Override
    public int getY() {
        return (int) y;
    }

    @Override
    public String getShipType() {
        return shipType;
    }

    @Override
    public void update() {
        setShipHitBox();
        isTurning();
        shipImage = GameData.flyweightItems.setImage(this);
    }
    private void isTurning()
    {
        if (dx>0)
        {
            this.state = STATE_TURNING_RIGHT;
             dx=0;
        }
        else if (dx<0)
        {
           this.state = STATE_TURNING_LEFT;
           dx=0;
        }
        else { 
              this.state = STATE_OK;
        }
            
    }
    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void render(Graphics g) {
        update();
        if (getShipState() == 13) {
            g.drawImage(shipImage, getX(), getY(), null);
        } else {
            g.drawImage(GameData.flyweightItems.setImage(this), getX(), getY(), null);
            if (shipState != 12) {
                shipState++;
            } else {
                shipState = 0;
            }

        }

        g.drawRect(getX(), getY(), (int)this.shipWidth, (int) this.shipHeight);
    }

    public void setImage(Image image) {
        this.shipImage = image;
    }

    @Override
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

    @Override
    public float getXofMissileShoot() {
        throw new UnsupportedOperationException("Not using anymore."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getYofMissileShoot() {
        throw new UnsupportedOperationException("Not using anymore."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onShipDamage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
