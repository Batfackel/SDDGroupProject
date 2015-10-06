/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.MainMenu;
import java.util.List;

/**
 *
 * @author ryan
 */
public class EnemyFactory {
    
    private Ship enemyShip;
    private Ship[] enemyFormation;
    
    public Ship getEnemyShip(String shipSelection, float x, float y){
        
        switch(shipSelection) {
            case "defaultship":
                enemyShip = new DefaultEnemyShip(x,y);
                return enemyShip;
            default:
                throw new IllegalArgumentException("NO SUCH SHIP TYPE");
        }
    }
    
    public Ship[] getEnemyShipFormation(String shipSelection, float x, float y) {
        enemyFormation = new Ship[5];
        enemyFormation[0] = new DefaultEnemyShip(x, y - 50);
        enemyFormation[1] = new DefaultEnemyShip(x + 190, y - 50);
        enemyFormation[2] = new DefaultEnemyShip(x + 380, y - 50);
        enemyFormation[3] = new DefaultEnemyShip(x + 190, y - 250);
        enemyFormation[4] = new DefaultEnemyShip(x + 380, y - 250);
        return enemyFormation;
    }
    
}
