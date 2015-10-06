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
public interface  Background {
    public void render(Graphics g);
    public void update();
    public int getState();
    public Image getImage(String fileName);
    static final int STATE_TRAVELING = 1;
    static final int STATE_EXPLODING = 2;
    static final int STATE_DONE = 0;
}
