/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Will
 */
public interface Ship {
   public void setRateOfSpeed(int newSpeed);
   public void addArmour(int armourToAdd);
   public void setWeaponState(int newWeaponState);
   public void addWeaponLevel(int weaponPower);
   public void setShipState(int newShipState);
   public int getShipState();
   public Image getImage(String fileName);
   public void update() ;
   public int getState(); 
   public void render(Graphics g);
}