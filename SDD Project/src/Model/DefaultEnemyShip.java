/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MovementStrategy;
import Controller.SweepDown;
import Controller.SweepLeft;
import Controller.SweepRight;
import View.GamePanel;
import View.MainMenu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ryan
 */
public class DefaultEnemyShip implements ShipState, GameFigure{
    
    Image image;
    private float x;
    private float y;
    float  dx, dy, shipHeight, shipWidth, rateOfSpeed;
    int armour, shipState, weaponState, weaponLevel, state;
    int levelState = -1;
    Rectangle[] hitBox = new Rectangle[2];
    private boolean moveRight = true;
    boolean moveLeft = false;
    
    public DefaultEnemyShip(float x, float y) {
        this.x = x;
        this.y = y;
        this.shipHeight = 235;
        this.shipWidth = 160;
        this.levelState = BASE_LEVEL;
        this.state = STATE_OK;
        this.rateOfSpeed = 2;
        setShipState(0);
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        image = getImage(imagePath + separator + "images" + separator + "Enemies" + separator + "defaultEnemyShip.png");
        this.setShipHitBox();
        
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
    public void setWeaponState(int newWeaponState) {
        this.weaponState = newWeaponState;
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
    public void setShipHitBox() {
        switch (getShipState()){
        case 0: 
            this.hitBox[0] = new Rectangle((int)this.getX(), (int)this.getY(), (int)this.shipWidth,
            (int) this.shipHeight); 
            break;
        }
    }

    @Override
    public int getShipState() {
         return this.shipState;
    }

    @Override
    public Rectangle getShipHitBox() {
        return this.hitBox[0];
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
    public void update() {
        setShipHitBox();
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void render(Graphics g) {
//        System.out.println("before switch------------------------");
        switch (getShipState()){
            case 0:
    //            System.out.println("case 0------------------------");
                g.setColor(Color.red);
                g.drawImage(image, (int)getX(), (int)getY(), null);
    //            g.drawRect((int)this.x, (int)this.y, (int)this.shipWidth,            
                    //(int) this.shipHeight);
                g.drawRect((int)this.getX(), (int)this.getY(), (int)this.shipWidth, (int)this.shipHeight);
                break;
        }
        move();
    }

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

    @Override
    public void moveLeft() {
        x = (int) (getX() - this.rateOfSpeed);
        dx = getX();
    }

    @Override
    public void moveRight() {
        x = (int) (getX() + this.rateOfSpeed);
        dx = getX();
    }

    @Override
    public void moveUp() {
        y = (int) (getY() - this.rateOfSpeed);
        dy = getY();
    }

    @Override
    public void moveDown() {
        y = (int) (getY() + this.rateOfSpeed);
        dy = getY();
    }

    @Override
    public void setShipType(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getXofMissileShoot() {
        return getX()+30;
    }

    @Override
    public float getYofMissileShoot() {
        return getY()+20;
    }

    @Override
    public int getWeaponState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void move() {
        MovementStrategy movement;
        
        if(getX() > 0 && isMoveRight()) {
            movement = new SweepRight();
            movement.moveShip(this);
            if(getX() + shipWidth >= MainMenu.m.getWidth()) {
                setMoveRight(false);
            }
        }
        else if(!isMoveRight()) {
            movement = new SweepLeft();
            movement.moveShip(this);
            if(getX() < 0) {
                setMoveRight(true);
            }
        }
        
        movement = new SweepDown();
        movement.moveShip(this);
    }

    @Override
    public void setState(int i) {
        this.state = i;
    }

    @Override
    public int getX() {
        return (int)x;
    }

    @Override
    public int getY() {
        return (int)y;
    }

    /**
     * @return the moveRight
     */
    public boolean isMoveRight() {
        return moveRight;
    }

    /**
     * @param moveRight the moveRight to set
     */
    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }
}
