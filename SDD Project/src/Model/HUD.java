/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import static View.GamePanel.PHEIGHT;
import static View.GamePanel.PWIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author Brian
 */
public class HUD {


public int score = 0;


public void update() {
    //Health
    if (gameOver()) {
        // do game over here
    }
    score ++;
}
public void render(Graphics g) {
    
        /*g.setColor(Color.DARK_GRAY);
        g.fillRect(2, 5, (int) (100 * 3.5), 15);
        g.setColor(new Color(150, (int)greenValue, 0));
        g.fillRect(2, 5, (int) (Health * 3.5), 15);
        g.setColor(Color.white);
        g.drawRect(2, 5, (int) (100 * 3.5), 15);*/
        
    
    //public void render(Graphics g){

    g.setColor(Color.BLACK);
    g.fillRect(750,0,50, 1200);
    g.fillRect(0, 0, 50, 1200);
   // g.setColor(Color.WHITE);
    
   

        /////////////////////health bar/////////////////////////////
        g.setColor(Color.GRAY);
        g.drawRect(5,5,10,300);
        
        g.setColor(Color.DARK_GRAY);
        renderHealth(g, 1);
        
        g.setColor(Color.RED);
        renderHealth(g, 2);
        
        g.setColor(Color.GREEN);
        renderHealth(g, 3);
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
        g.drawString("SCORE", PWIDTH/2,PHEIGHT+75);
        g.drawString(String.valueOf(score),PWIDTH/2,PHEIGHT+100);
 
 

}

private void renderHealth(Graphics g, int lifeNumber){
    float percentage = 0;
    
    if (lifeNumber < NewShip.getInstance().getLives()) {
        percentage = 1;
    }
    else if(lifeNumber == NewShip.getInstance().getLives()){
        percentage = NewShip.getInstance().getHealth() / 100f;
    }
    else{
        percentage = 0;
    }
    System.out.println(percentage);
    g.fillRect(5,305 - (int)(300 * percentage),10,(int)(300 * percentage));
}

private boolean gameOver() {
    return NewShip.getInstance().getLives() <= 0 &&
            NewShip.getInstance().getHealth() <= 0;
}

  
    

   

  
     
    
    
    
    
}
