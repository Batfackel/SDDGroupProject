/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author atm15_000
 */
public abstract class Bullet implements GameFigure{
    abstract float getX();
    abstract float getY();
    abstract void setState();
    abstract public void render(Graphics graphics);  
    abstract public Rectangle getShipHitBox();     
}
