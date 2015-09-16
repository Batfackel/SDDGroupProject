package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael McGregor
 */
public interface AbstractItem {
    static final int KINETIC_POWER = 0;
    static final int LASER_POWER = 1;
    static final int PLASMA_POWER = 2;
    public int getItem();
    public void setItem(int item);
    public void timeout();
}
