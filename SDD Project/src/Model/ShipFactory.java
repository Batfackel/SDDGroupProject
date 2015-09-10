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
    public ShipFactory(){
        
    }
    
    public Ship getShip(int shipType, float x, float y){
        
        switch (shipType) {
            case 0:{
                
                return new DefaultShip(x,y);
            }
            default:{
                return null;
            }
        }
    }
    
    
}
