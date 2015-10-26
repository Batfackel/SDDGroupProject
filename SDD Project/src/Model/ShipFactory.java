/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Will
 */
public class ShipFactory {
    
    //Default constructor
  private Ship shipType;
     
  void Ship()
  {
      shipType = null;
  }
    public Ship getShip(String shipSelection, float x, float y){
        
        if (shipSelection.equalsIgnoreCase("defaultship")){
          //  shipType = new DefaultShip(x,y);
            shipType = new NewShip("defaultShip",x,y);
            return shipType;
        }
        else if (shipSelection.equalsIgnoreCase("shipx")){
           // shipType = new ShipX(x,y);
                 shipType = new NewShip("shipx",x,y);
            return shipType;
        }
        else if (shipSelection.equalsIgnoreCase("shipy")){
           // shipType = new ShipY(x,y);
                 shipType = new NewShip("shipy",x,y);
            return shipType;
        }
        else if (shipSelection.equalsIgnoreCase("shipz")){
           // shipType = new ShipZ(x,y);
                shipType = new NewShip("shipz",x,y);
            return shipType;
        }
         else if (shipSelection.equalsIgnoreCase("shipw")){
           // shipType = new ShipW(x,y);
                  shipType = new NewShip("shipw",x,y);
            return shipType;
        }
          else if (shipSelection.equalsIgnoreCase("shipv")){
            //shipType = new ShipV(x,y);
                  shipType = new NewShip("shipv",x,y);
            return shipType;
        }
        else{
             // shipType = new DefaultShip(x,y);
                   shipType = new NewShip("defaultShip",x,y);
            return shipType;
            //throw new IllegalArgumentException("NO SUCH SHIP TYPE");
        }
    }    
}
