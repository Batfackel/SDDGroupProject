/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ship;
import View.GamePanel;
import View.MainMenu;

/**
 *
 * @author ryan
 */
public class SweepRight implements MovementStrategy{

    @Override
    public void moveShip(Ship ship) {
        ship.moveRight();
    }
    
}
