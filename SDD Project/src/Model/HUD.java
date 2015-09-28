/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 *
 * @author Brian
 */
public class HUD {
    //private Ship ship;
    
    public HUD() {
        
    
}
    


public void render(Graphics g){

    g.setColor(Color.BLACK);
    g.fillRect(750,0,50, 1200);
    g.fillRect(0, 0, 50, 1200);
   // g.setColor(Color.WHITE);
    
   

        /////////////////////health bar/////////////////////////////
        g.setColor(Color.GRAY);
        g.drawRect(5,5,10,300);
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(5,5,10,300);
        
        g.setColor(Color.RED);
        g.fillRect(5,5,10,300);
        
        g.setColor(Color.GREEN);
        g.fillRect(5,5,10,300);
        g.setColor(Color.BLACK);
        ///////Terrible way to get verticle letters- will change later///////
        g.drawString("L",5,240);
        g.drawString("I",5,260);
        g.drawString("F",5,280);
        g.drawString("E",5,300);
        //////////////////Sheild bar///////////////////////////////
        g.setColor(Color.YELLOW);
        g.fillRect(25,105,10,200);
        
        g.setColor(Color.ORANGE);
        g.fillRect(25,105,10,200);
        

        
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman",Font.BOLD,13));
        g.drawString("S",25,200);
        g.drawString("H",25,220);
        g.drawString("I",25,240);
        g.drawString("E",25,260);
        g.drawString("L",25,280);
        g.drawString("D",25,300);
        

        /////////////////Score placeholder//////////
        g.setColor(Color.WHITE);
        g.drawString("SCORE",5,340);
        g.drawRect(5,350,35,60);
 
        

}

  
     
    
    
    
    
}
