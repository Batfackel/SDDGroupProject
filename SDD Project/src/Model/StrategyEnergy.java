/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author atm15_000
 */
public class StrategyEnergy implements ItemStrategy{

    @Override
    public Item spawnItem() {
        KineticWeapon asdf = new KineticWeapon(122f, 122f, 2);
        return asdf;       
    }
    
}
