/*
 * laser weapon for the ship used in the factory pattern. This inherits from
 * Item and is a more specific kind of weapon power up.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Michael McGregor
 */
public class LaserWeapon extends Item{
   private int weaponType, adsaf = 0;
   private float x, y;
   Random rand;
   
    public LaserWeapon(float x, float y, int ref) {
        super(x, y, ref, 32, 0, 64, 32);
        this.weaponType = ref;
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
}
