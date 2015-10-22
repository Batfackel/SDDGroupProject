/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.MainMenu;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ryan
 */
public class EnemyFactory {
    
    private Ship enemyShip;
    private Ship[] enemyFormation;
    private Random rand;
    
    public Ship getEnemyShip(String shipSelection, float x, float y){
        
        switch(shipSelection) {
            case "defaultship":
                enemyShip = new EnemyShip(x,y);
                return enemyShip;
            default:
                throw new IllegalArgumentException("NO SUCH SHIP TYPE");
        }
    }
    
    public Ship[] getEnemyShipFormation(String shipSelection, float x, float y) {
        enemyFormation = new Ship[5];
        rand = new Random();
        enemyFormation[0] = new EnemyShip("alien1", x, y - rand.nextInt(MainMenu.m.getHeight()));
        enemyFormation[1] = new EnemyShip("blueFighter", x + rand.nextInt(MainMenu.m.getWidth()), y - rand.nextInt(MainMenu.m.getHeight()));
        enemyFormation[2] = new EnemyShip("purpleFighter", x + rand.nextInt(MainMenu.m.getWidth()), y - rand.nextInt(MainMenu.m.getHeight()));
        enemyFormation[3] = new EnemyShip("redFighter", x + rand.nextInt(MainMenu.m.getWidth()), y - rand.nextInt(MainMenu.m.getHeight()));
        enemyFormation[4] = new EnemyShip("defaultEnemyShip", x + rand.nextInt(MainMenu.m.getWidth()), y - rand.nextInt(MainMenu.m.getHeight()));
        return enemyFormation;
    }
    
}
