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
            shipType = new DefaultShip(x,y);
            return shipType;
        }
        else{
            throw new IllegalArgumentException("NO SUCH SHIP TYPE");
        }
    }    
}
