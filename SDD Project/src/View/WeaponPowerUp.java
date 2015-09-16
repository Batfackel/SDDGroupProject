/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import Model.AbstractItem;

/**
 *
 * @author Michael McGregor
 */
public class WeaponPowerUp extends Item{

   private int adsaf = 0;
   private float x, y;

    public WeaponPowerUp(float x, float y) {
        super(x, y);
    }
   
  @Override
    public void setItem(int item) {
        this.itemType = item;
    }
            
}
