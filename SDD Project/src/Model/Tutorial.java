/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author YuchenFeng
 */
public class Tutorial implements GameFigure, KeyListener, MouseListener {
    public Tutorial() throws IOException{
        items = new ArrayList<>();
        
        items.add(new KeyboardTutorialItem("up.png", KeyEvent.VK_UP));
        items.add(new KeyboardTutorialItem("down.png", KeyEvent.VK_DOWN));
        items.add(new KeyboardTutorialItem("left.png", KeyEvent.VK_LEFT));
        items.add(new KeyboardTutorialItem("right.png", KeyEvent.VK_RIGHT));
        items.add(new KeyboardTutorialItem("shots.png", KeyEvent.VK_SPACE));
        //items.add(new MouseTutorialItem("shot.png"));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        handlingItems(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handlingItems(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private void handlingItems(InputEvent e){
        ArrayList<ITutorialItem> handledItems = new ArrayList<>();
        
        for(ITutorialItem item : items){
            if(item.handle(e)){
                handledItems.add(item);
            }
        }
        
        removeHandledItems(handledItems);
    }
    
    private void removeHandledItems(ArrayList<ITutorialItem> handledItems){
        this.items.removeAll(handledItems);
    }
    

    @Override
    public void render(Graphics g) {
        if (items.size() > 0) {
            items.get(0).display(g);
        }
    }

    @Override
    public void update() {
    }

    @Override
    public int getState() {
        return 1;
    }
    
    ArrayList<ITutorialItem> items;

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    @Override
    public void renderToolTips(Graphics g) {
    }
}
