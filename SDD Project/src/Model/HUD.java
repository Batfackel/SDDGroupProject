/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import static Controller.Main.gameData;
import static View.GamePanel.PHEIGHT;
import static View.GamePanel.PWIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Brian
 */
public class HUD {
private float greenValue = 255;
//public int score = 0;
/*Will*/
String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
String separator = System.getProperty("file.separator");
Image weaponPowerIcon=getImage(imagePath + separator + "images" + separator + "strength.png");
Image speedIcon=getImage(imagePath + separator + "images" + separator + "speed.png");
Image heartIcon=getImage(imagePath + separator + "images" + separator + "heart.png");
Image shieldIcon=getImage(imagePath + separator + "images" + separator + "shield.png");
/*Will++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
public static int score = 0;
public void update() {
    //Health
    if (gameOver()) {
        // do game over here

//private float greenValue = 255;
//public static int score = 0;

//    HealthBound();
    //score 
//    greenValue = Health*3;
    
//    if (greenValue > 255) {
//        greenValue = 255;
    }
    score ++;
}
public void render(Graphics g) {
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

//        g.fillRect(5,5,10,300);
       // g.setColor(Color.BLACK);

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
        g.setColor(Color.BLACK);
        g.drawString("SCORE", PWIDTH/2,PHEIGHT+75);
        g.drawString(String.valueOf(score),PWIDTH/2,PHEIGHT+100);
 
 /*Will*/
        g.drawImage(weaponPowerIcon,-5, 300, null);
        
        g.drawString((Integer.toString(gameData.currentShip.getLevelState())),30,350);
        
        g.drawImage(speedIcon,-237, 115, null);
        
        g.drawString((Integer.toString(gameData.currentShip.getShipSpeed())),30,400);
        
        g.drawImage(heartIcon,-90, 320, null);
        
        g.drawString((Integer.toString(gameData.currentShip.getShipMaxHealth())),30,455);
       
        g.drawImage(shieldIcon,-90, 380, null);
        
        g.drawString((Integer.toString(gameData.currentShip.getShipMaxShield())),30,525);
 /*Will++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        
        
        

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
   // System.out.println(percentage);
    g.fillRect(5,305 - (int)(300 * percentage),10,(int)(300 * percentage));
}

private boolean gameOver() {
    return NewShip.getInstance().getLives() <= 0 &&
            NewShip.getInstance().getHealth() <= 0;
}
/*Will*/
  public Image getImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }
/*Will++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    
    
    
    
}
