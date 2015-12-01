
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.KeyController;
import Controller.MovementStrategy;
import Controller.SweepDown;
import Controller.SweepLeft;
import Controller.SweepRight;
import static Model.GameData.enemyBulletsContext;
import View.MainMenu;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ryan
 */
public class EnemyShip implements ShipState, GameFigure{
    private Image image;
    private float x;
    private float y;
    float  dx, dy, shipHeight, shipWidth, rateOfSpeed;
    int armour, shipState, weaponState, weaponLevel, state, health;
    private int score;
    int levelState = -1;
    Rectangle[] hitBox = new Rectangle[2];
    private boolean moveRight = true;
    private String shipType;
    private int shootTicker, shootTimer;
    private Random rand;
    
    public EnemyShip(float x, float y) {
        this.x = x;
        this.y = y;
        this.levelState = BASE_LEVEL;
        this.state = STATE_OK;
        this.rateOfSpeed = 2;
        setShipState(13);
        this.setShipHitBox();
    }
    
    public EnemyShip(String shipType, float x, float y) {
        this.x = x;
        this.y = y;
        this.levelState = BASE_LEVEL;
        this.state = STATE_OK;
        this.rateOfSpeed = 2;
        setShipState(13);
        this.shipType = shipType;
        image = GameData.flyweightItems.setShipImage(this);
        this.shipHeight = image.getHeight(null);
        this.shipWidth = image.getWidth(null);
        rand = new Random();
        moveRight = rand.nextBoolean();
        shootTicker = 100;
        shootTimer = 0;
        weaponState = 10;
        switch(shipType) {
            case "alien1":
                this.health = 5;
                score = 5;
                break;
            case "blueFighter":
                this.health = 4;
                score = 4;
                break;
            case "purpleFighter":
                this.health = 3;
                score = 3;
                break;
            case "redFighter":
                this.health = 2;
                score = 2;
                break;
            default:
                this.health = 1;
                score = 1;
                break;
        }
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
        this.hitBox[0] = new Rectangle(getX(), getY(), (int)this.shipWidth, (int) this.shipHeight); 
        
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
        if (this.x > 850 || this.y > 1050){            
            this.state = STATE_DONE;
        }
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void render(Graphics g) {
        move();
        if(getShipState() == 13) {
            g.drawImage(GameData.flyweightItems.setShipImage(this), getX(), getY(), null);
            setShipHitBox();
        }
        else {
            g.drawImage(GameData.flyweightItems.setShipImage(this), getX(), getY(), null);
            if(shipState != 12) {
                shipState++;
                hitBox[0] = new Rectangle(-100, -100, 0, 0);
            }
            else {
                shipState = 0;
                hitBox[0] = new Rectangle(-100, -100, 0, 0);
            }
            
        }
    }

    @Override
    public void setLevelState(int i) {
        levelState = i;
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
        
        if(isMoveRight()) {
            movement = new SweepRight();
            movement.moveShip(this);
            if(getX() + shipWidth >= MainMenu.m.getWidth()) {
                setMoveRight(false);
            }
        }
        else if(isMoveRight() == false) {
            movement = new SweepLeft();
            movement.moveShip(this);
            if(getX() < 0) {
                x = 0;
                setMoveRight(true);
            }
        }
        
        movement = new SweepDown();
        movement.moveShip(this);
        
        if(shootTimer == shootTicker) {
            shootTicker = 100; 
            shootTimer = 0;
            //spawn a shot and make it go down to attack the player
            //should ignore the other enemyships
            GameData.enemyBulletsContext.setState(GameData.kinetic, this.weaponState);
            GameData.enemyBulletsContext.fire(fireLocationX(), fireLocationY());
        }
        else {
            shootTimer++;
        }
        
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

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the shipType
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
    
    public void getHit() {
        //can have the type of bullet change how much damage is done
        health--;
        if(health == 0) {
            shipState = 1;
        HUD.score += 100;
        }
    }
    
    public void getHit(Bullet bullet) {
        //do stuff depending on what type of bullet it is
    }

    
    @Override
    public Rectangle getRectangle() {
        return this.getShipHitBox();
    }

    @Override
    public void renderToolTips(Graphics g) {
        //string is modified based on the enemy type that is being hovered over        
        g.drawString("****ENEMY SHIP****", (int)getX() + 25, (int)getY());
        g.drawString("FIRE WHEN READY!!", (int)getX() + 25, (int)getY() + 15);

    }

    @Override
    public int getDamagedCounter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int fireLocationX() {
        //half the width of the ship
        return (int) x + ((int) shipWidth / 2);
    }
    
    public int fireLocationY() {
        //at the bottom of the picture
        return (int) y + (int)shipHeight;
    }

    @Override
    public int getShipSpeed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getShipMaxHealth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getShipMaxShield() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHealth(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHealth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playerDied() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDead() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
