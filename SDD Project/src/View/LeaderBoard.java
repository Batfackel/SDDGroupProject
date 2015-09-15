/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SaveData;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ryan
 */
public class LeaderBoard extends JPanel{
    private SaveData data;
    public LeaderBoard(Graphics graphics) {
        //read the data file to get what scores are in there
        data.readFile();
        
        //load up the java swing components to display on the screen
    }
    
    public void 
}
