/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EnemyFlyweightItems;
import Model.Ship;
import java.awt.Image;

/**
 *
 * @author ryan
 */
public class EnemyFlyWeightFactory {
    public EnemyFlyweight flyweight;
    public EnemyFlyWeightFactory() {
        flyweight = new EnemyFlyweightItems();
    }
    
    public EnemyFlyweight getFlyweight() {
        return flyweight;
    }
}
