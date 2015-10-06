/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Will
 */
public class ShipSelectMenu implements Background{

private Image backgroundImage = null;
    
   private final String imagePath = System.getProperty("user.dir");
   private final String separator = System.getProperty("file.separator");// separator: Windows '\', Linux '/'
   private final static int DONE = 0;
   private final static int FIRST_SHIP_SELECTED = 1;
   private final static int SECOND_SHIP_SELECTED = 2;     
   private final static int THIRD_SHIP_SELECTED = 3; 
   private final static int FOURTH_SHIP_SELECTED = 4;
   private final static int FIFTH_SHIP_SELECTED = 5;
   private final static int SIXTH_SHIP_SELECTED = 6;
   private int currentSelection;
   private int state;
   private float x, y;
public ShipSelectMenu()
{
    state = FIRST_SHIP_SELECTED;
    currentSelection = FIRST_SHIP_SELECTED;
    backgroundImage = getImage(imagePath + separator + "images" + 
            separator +"tempShipSelectMenu.png");
}

    private void moveCursorUp()
    {
      switch (currentSelection){
          case FIRST_SHIP_SELECTED:{ currentSelection = FOURTH_SHIP_SELECTED; break;}
          case SECOND_SHIP_SELECTED:{ currentSelection = FIFTH_SHIP_SELECTED; break;}
          case THIRD_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;}
          case FOURTH_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;}
          case FIFTH_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;}
          case SIXTH_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;}
      }
    }
    private void moveCursorDown()
    {
     switch (currentSelection){
          case FIRST_SHIP_SELECTED:{currentSelection = FOURTH_SHIP_SELECTED; break;}
          case SECOND_SHIP_SELECTED:{currentSelection = FIFTH_SHIP_SELECTED; break;}
          case THIRD_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;}
          case FOURTH_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;}
          case FIFTH_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;}
          case SIXTH_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;}
      }
    }
    private void moveCursorRight()
    {
         switch (currentSelection){
          case FIRST_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;}
          case SECOND_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;}
          case THIRD_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;}
          case FOURTH_SHIP_SELECTED:{currentSelection = FIFTH_SHIP_SELECTED; break;}
          case FIFTH_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;}
          case SIXTH_SHIP_SELECTED:{currentSelection = FOURTH_SHIP_SELECTED; break;}
          
      }
    }
     private void moveCursorLeft()
    {
         switch (currentSelection){
          case FIRST_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;}
          case SECOND_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;}
          case THIRD_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;}
          case FOURTH_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;}
          case FIFTH_SHIP_SELECTED:{currentSelection = FOURTH_SHIP_SELECTED; break;}
          case SIXTH_SHIP_SELECTED:{currentSelection = FIFTH_SHIP_SELECTED; break;}
          
          
      }
    }
    private void setSelectionBox(){
    //setSelectionBox() creates a retangle around the selected ship designated 
    //    by the player selction using arrow keys
        
        
    }
//-------------------------------------------------------------------------
/*STATE AND ANIMATION METHODS*/
//-------------------------------------------------------------------------   
    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*STATE AND ANIMATION METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    
//-------------------------------------------------------------------------
/*HELPER METHODS*/ 
//-------------------------------------------------------------------------
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
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*END HELPER METHODS*/ 
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
}
