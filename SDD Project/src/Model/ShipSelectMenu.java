/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.KeyController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author Will
 */
public class ShipSelectMenu implements Background {
    private Image backgroundImage = null;
    private final String imagePath = System.getProperty("user.dir");
    private final String separator = System.getProperty("file.separator");// separator: Windows '\', Linux '/'
    private final static int DONE = 0;
    private final static int FIRST_SHIP_SELECTED = 1;    private final static int SECOND_SHIP_SELECTED = 2;
    private final static int THIRD_SHIP_SELECTED = 3;    private final static int FOURTH_SHIP_SELECTED = 4;
    private final static int FIFTH_SHIP_SELECTED = 5;    private final static int SIXTH_SHIP_SELECTED = 6;
    //Resolutions Available to deterimne which screen to use.
    private final static int RESOLUTION_800X1000 = 1;    private final static int RESOLUTION_1280X720 = 2;
    private final static int RESOLUTION_1400X900 = 3;
   //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Values for rectangles on the secetion screen at 800X1000 Res
    private final static int TOP_COL_OF_DEFAULT_SHIP_X_VALUE_800X1000 = 90;  //YELLOW SHIP
    private final static int TOP_COL_OF_SHIP_V_X_VALUE_800X1000 = 335;  //DARK GREEN SHIP
    private final static int TOP_COL_OF_SHIP_X_X_VALUE_800X1000 = 565;  //Violet SHIP
    private final static int TOP_ROW_OF_SHIPS_Y_VALUE_800X1000 = 365;
    private final static int TOP_COL_OF_SHIP_W_X_VALUE_800X1000 = 90;  //SHADOW SHIP
    private final static int TOP_COL_OF_ShipV_X_VALUE_800X1000 = 335;  //MINT SHIP
    private final static int TOP_COL_OF_ShipX_X_VALUE_800X1000 = 565;  //SUN SHIP
    private final static int BOTTOM_ROW_OF_SHIPS_Y_VALUE_800X1000 = 565;
    private final static int SELECTION_RECTANGLE_WIDTH_800X1000 = 150;
    private final static int SELECTION_RECTANGLE_HEIGHT_800X1000 = 0;
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private int currentSelection; private int currentResolution;
    private int state; private float x, y; private boolean hasThePlayerSelectedAShip;
    String nameOfShip;
    public ShipSelectMenu(int currentResolution)//Acccepts 1-3 to determine current screen Res
    {
        this.currentResolution = currentResolution;
        this.x = 0; this.y = 0; this.hasThePlayerSelectedAShip = false;
        state = FIRST_SHIP_SELECTED; currentSelection = FIRST_SHIP_SELECTED;
        backgroundImage = getImage(imagePath + separator + "images"
                + separator + "tempShipSelectMenu.png");
    }
    public boolean hasPlayerSelectedAShip() {return hasThePlayerSelectedAShip;}
    private void moveCursorUp() {
        System.out.println(currentSelection);
        switch (currentSelection) {
         case FIRST_SHIP_SELECTED: {currentSelection = FOURTH_SHIP_SELECTED; break;}
         case SECOND_SHIP_SELECTED: {currentSelection = FIFTH_SHIP_SELECTED; break;}
         case THIRD_SHIP_SELECTED: {currentSelection = SIXTH_SHIP_SELECTED; break;}
         case FOURTH_SHIP_SELECTED: {currentSelection = FIRST_SHIP_SELECTED; break;}
         case FIFTH_SHIP_SELECTED: {currentSelection = SECOND_SHIP_SELECTED; break;}
         case SIXTH_SHIP_SELECTED: {currentSelection = THIRD_SHIP_SELECTED; break;}
        
        } }
    private void moveCursorDown() {
        System.out.println(currentSelection);
     switch (currentSelection){
       case FIRST_SHIP_SELECTED:{currentSelection = FOURTH_SHIP_SELECTED; break;}
       case SECOND_SHIP_SELECTED:{currentSelection = FIFTH_SHIP_SELECTED; break;}
       case THIRD_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;}
       case FOURTH_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;}
       case FIFTH_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;}
       case SIXTH_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;}
      } }
    private void moveCursorRight()
    { System.out.println(currentSelection);
        switch (currentSelection){
       case FIRST_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;} case SECOND_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;}
       case THIRD_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;} case FOURTH_SHIP_SELECTED:{currentSelection = FIFTH_SHIP_SELECTED; break;}
       case FIFTH_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;} case SIXTH_SHIP_SELECTED:{currentSelection = FOURTH_SHIP_SELECTED; break;}  
      } }
    private void moveCursorLeft()
            
    { System.out.println(currentSelection);
        switch (currentSelection){
        case FIRST_SHIP_SELECTED:{currentSelection = THIRD_SHIP_SELECTED; break;} case SECOND_SHIP_SELECTED:{currentSelection = FIRST_SHIP_SELECTED; break;}
        case THIRD_SHIP_SELECTED:{currentSelection = SECOND_SHIP_SELECTED; break;} case FOURTH_SHIP_SELECTED:{currentSelection = SIXTH_SHIP_SELECTED; break;}
        case FIFTH_SHIP_SELECTED:{currentSelection = FOURTH_SHIP_SELECTED; break;} case SIXTH_SHIP_SELECTED:{currentSelection = FIFTH_SHIP_SELECTED; break;}
      } }
    private void setSelectionBox(){
    //setSelectionBox() creates a retangle around the selected ship designated 
    //    by the player selction using arrow keys    
        
    }
    private void selectShip()
    {
        switch (currentSelection) {
            case FIRST_SHIP_SELECTED: {
                nameOfShip = "FIRST_SHIP";
                   System.out.println(currentSelection);
                break;
            }
            case SECOND_SHIP_SELECTED: {
                nameOfShip = "SECOND_SHIP";
                break;
            }
            case THIRD_SHIP_SELECTED: {
                nameOfShip = "THIRD_SHIP";
                break;
            }
            case FOURTH_SHIP_SELECTED: {
                nameOfShip = "FOURTH_SHIP";
                break;
            }
            case FIFTH_SHIP_SELECTED: {
                nameOfShip = "FIFTH_SHIP";
                break;
            }
            case SIXTH_SHIP_SELECTED: {
                nameOfShip = "SIXTH_SHIP";
                break;
            }

        }
        state=STATE_DONE;
        hasThePlayerSelectedAShip = true;
    }
    
    String getShipSelection()
    {
        return nameOfShip;
    }
//-------------------------------------------------------------------------
/*STATE AND ANIMATION METHODS*/
//-------------------------------------------------------------------------   
    @Override
    public void render(Graphics g) {
        g.drawImage(backgroundImage, (int) x, (int) y, null);
        switch (currentResolution) {
            case RESOLUTION_800X1000: {
                switch (currentSelection) {
                    case FIRST_SHIP_SELECTED: {g.setColor(Color.RED);
                        g.drawRect(300, 300,
                                SELECTION_RECTANGLE_WIDTH_800X1000, SELECTION_RECTANGLE_HEIGHT_800X1000);break;}
                    case  SECOND_SHIP_SELECTED: {g.setColor(Color.RED);
                        g.drawRect(TOP_COL_OF_SHIP_V_X_VALUE_800X1000, TOP_ROW_OF_SHIPS_Y_VALUE_800X1000,
                                SELECTION_RECTANGLE_WIDTH_800X1000, SELECTION_RECTANGLE_HEIGHT_800X1000);break;}
                    case THIRD_SHIP_SELECTED: {g.setColor(Color.RED);
                        g.drawRect(TOP_COL_OF_SHIP_X_X_VALUE_800X1000, TOP_ROW_OF_SHIPS_Y_VALUE_800X1000,
                                SELECTION_RECTANGLE_WIDTH_800X1000, SELECTION_RECTANGLE_HEIGHT_800X1000);break;}
                    case FOURTH_SHIP_SELECTED: {g.setColor(Color.RED);
                        g.drawRect(TOP_COL_OF_SHIP_W_X_VALUE_800X1000, BOTTOM_ROW_OF_SHIPS_Y_VALUE_800X1000,
                                SELECTION_RECTANGLE_WIDTH_800X1000, SELECTION_RECTANGLE_HEIGHT_800X1000);break;}
                    case  FIFTH_SHIP_SELECTED: {g.setColor(Color.RED);
                        g.drawRect(TOP_COL_OF_ShipV_X_VALUE_800X1000, BOTTOM_ROW_OF_SHIPS_Y_VALUE_800X1000,
                                SELECTION_RECTANGLE_WIDTH_800X1000, SELECTION_RECTANGLE_HEIGHT_800X1000);break;}
                    case SIXTH_SHIP_SELECTED: {g.setColor(Color.RED);
                        g.drawRect(TOP_COL_OF_ShipX_X_VALUE_800X1000, BOTTOM_ROW_OF_SHIPS_Y_VALUE_800X1000,
                                SELECTION_RECTANGLE_WIDTH_800X1000, SELECTION_RECTANGLE_HEIGHT_800X1000);break;}
                }
            }
        }
    }
    @Override
    public void update() {
        getState();
        if(getState() != STATE_DONE)
        {
            
        }
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getState() {
       return this.state;
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

//    @Override
//    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//       switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//                moveCursorLeft();
//                break;
//            case KeyEvent.VK_RIGHT:
//                moveCursorRight();                
//                break;
//            case KeyEvent.VK_UP:
//                moveCursorUp();              
//                break;
//            case KeyEvent.VK_DOWN:
//                moveCursorDown(); 
//                break;
//            case KeyEvent.VK_ENTER:
//                selectShip();
//                break;
//           
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
