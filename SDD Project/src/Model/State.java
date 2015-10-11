/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * used with the weapon state design pattern
 * 
 * @author atm15_000
 */
public interface State{
    public void fire(Context bullet, int wls, int x, int y);
}
