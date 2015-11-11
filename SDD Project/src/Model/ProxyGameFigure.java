/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author YuchenFeng
 */
public class ProxyGameFigure implements GameFigure {
    
    private GameFigure f;
    private boolean showToolTips;
    
    public ProxyGameFigure(GameFigure f){
        this.f = f;
        showToolTips = false;
    }

    @Override
    public void render(Graphics g) {
        if (f != null) {
            f.render(g);
            
            if (showToolTips) {
                f.renderToolTips(g);
            }
        }
    }

    @Override
    public void update() {
        if (f != null) {
            f.update();
        }
    }

    @Override
    public int getState() {
        if (f != null) {
            return f.getState();
        }
        
        return 0;
    }

    @Override
    public Rectangle getRectangle() {
        if (f != null) {
            return f.getRectangle();
        }
        
        return null;
    }

    public void onRendering(Graphics g, Point p) {
        if (f.getRectangle() != null && p!= null && f.getRectangle().contains(p)) {
            showToolTips = true;
        }
        else{
            showToolTips = false;
        }
        if(p!=null)
        //System.out.println("Mouse.X: " + p.x + " Mouse.Y: " + p.y + " showToolTip: " + showToolTips);
        this.render(g);
    }

    @Override
    public void renderToolTips(Graphics g) {
        if (f != null) {
            f.renderToolTips(g);
        }
    }
    
}
