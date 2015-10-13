/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *used with the state design pattern
 *
 * @author atm15_000
 */
public class Context {
    private State bullet;
    private int weaponLevelState;
    
    public Context(){
        bullet = null;
        weaponLevelState = -1;
    }
    
    public void setState(State bullet, int wls){
        this.weaponLevelState = wls;
        this.bullet = bullet;        
    }
    
    public State getState() {
        return bullet;
    }
    
    public int getWeaponLevel() {
        return weaponLevelState;
    }
    
    public void fire(int x, int y) {
        this.bullet.fire(this, weaponLevelState, x, y);
    }
}
