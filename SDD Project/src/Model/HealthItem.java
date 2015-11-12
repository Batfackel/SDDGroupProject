/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.GameFigure.STATE_DONE;
import static Model.GameFigure.STATE_TRAVELING;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Will
 */
public class HealthItem extends Item{
   private int weaponType, adsaf = 0;
   private float x, y;
   Random rand;
   

    public HealthItem(float x, float y, int ref) {
        super(x, y, ref, 130, 228, 156, 253);
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
    
    @Override
    protected String getText() {
        return "Health -Item Pickup.";
    }
}
