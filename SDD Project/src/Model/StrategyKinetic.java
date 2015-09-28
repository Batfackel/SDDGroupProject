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
public class StrategyKinetic implements ItemStrategy{

    @Override
    public Item spawnItem() {
        KineticWeapon asdf = new KineticWeapon(122f, 122f, 2);
        //return (Item) ("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100));
        return (Item)asdf;
        //return new KineticWeapon()
        
    }
    
}
