/*
 * Missle weapon for the ship used in factory pattern. This inherits from
 * Item and is a more specific kind of weapon power up.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Michael McGregor
 */
public class MissileWeapon extends Item{
   private int weaponType, adsaf = 0;
   private float x, y;
   Random rand;
   

    public MissileWeapon(float x, float y, int ref) {
        super(x, y, ref, 0, 128, 32, 160);
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
