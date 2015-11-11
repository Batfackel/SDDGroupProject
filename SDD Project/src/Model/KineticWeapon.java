/*
 * Kinetic weapon for the ships used in the factory pattern. This inherits from
 * Item and is a more specific kind of weapon power up.
 */
package Model;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Michael McGregor
 */
public class KineticWeapon extends Item{
    private int weaponType, adsaf = 0;
   private float x, y;
   Random rand;
   

    public KineticWeapon(float x, float y, int ref) {
        super(x, y, ref, 0, 0, 32, 32);
        this.weaponType = 0;
        rand = new Random();
        int randomNum = rand.nextInt((3 - 0) + 1) + 0;
        //setItem(randomNum);
    }
   
  @Override
    public void setItem(int item) {
        this.itemType = item;
    } 
    
    @Override
    public int getItemType() {
        return this.weaponType;
    }
    
    @Override
    protected String getText() {
        return "Projectile Weapon -Item Pickup.";
    }
}
