/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ryan
 */
public class EnemyFactory {
    
    private Ship enemyShip;
    
    public Ship getEnemyShip(String shipSelection, float x, float y){
        
        switch(shipSelection) {
            case "defaultship":
                enemyShip = new DefaultEnemyShip(x,y);
                return enemyShip;
            default:
                throw new IllegalArgumentException("NO SUCH SHIP TYPE");
        }
    }
    
}
