/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Graphics;
import java.awt.event.InputEvent;

/**
 *
 * @author YuchenFeng
 */
public interface ITutorialItem {
    void display(Graphics g);
    boolean handle(InputEvent e);
}
