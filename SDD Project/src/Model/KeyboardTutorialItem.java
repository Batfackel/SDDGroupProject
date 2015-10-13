/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author YuchenFeng
 */
public class KeyboardTutorialItem implements ITutorialItem{
   // private int fontsize = 30;

    public KeyboardTutorialItem(String text, int desiredKey) throws IOException{
        this.text = text;
        this.desiredKey = desiredKey;
        this.isHandled = false;
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        this.text = imagePath + separator + "images" + separator + this.text;
        this.image = ImageIO.read(new File(this.text));
    }
    
    @Override
    public boolean handle(InputEvent e) {
        if(e instanceof KeyEvent){
            KeyEvent ke = (KeyEvent)e;
            
            if (ke.getKeyCode() == this.desiredKey) {
                this.isHandled = true;
            }
        }
        
        return this.isHandled;
    }

    @Override
    public void display(Graphics g) {
        if(!isHandled){
            g.drawImage(image, 200, 550, null);
            
            //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            //g.setFont(new Font("TimesRoman",Font.BOLD,40));
            //g.setColor(Color.red);
            
            //g.drawString(text, (int)(85), (int)(600));  
            //g.drawString(text, (int)(screenSize.getWidth()/ 2), (int)(screenSize.getHeight() / 2));  

        }
    }
    
    private String text;
    private int desiredKey;
    private boolean isHandled;
    private Image image;
}
