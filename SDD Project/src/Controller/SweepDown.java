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
public class SweepDown implements MovementStrategy {

    @Override
    public void moveShip(Ship ship) {
        ship.moveDown();
        if(ship.getY() >= MainMenu.m.getHeight() + 150) {
            ship.setState(0);
        }
        else {
            ship.moveDown();
        }
    }
    
}
