/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SaveData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author ryan
 */
public class ShipSelect extends JPanel{
    private SaveData data;
    private Image dbImage = null;
    private Graphics graphics;
    public static final int PWIDTH = 800; // size of the game panel
    public static final int PHEIGHT = 800;
    private JLabel nameBanner, score, time, level;
    private Vector<JLabel> nameLabels, scoreLabels, timeLabels, levelLabels;
    private JPanel header;
    private JPanel[][] panelHolder;
    private JTable table;
    private JScrollPane scrollPane;
            
    public ShipSelect() {
    
        header = new JPanel();
      
        //header.setPreferredSize(new Dimension(getWidth(), 100));
        header.setBackground(Color.green);
        //header.setLayout(layout);
        panelHolder = new JPanel[1 + data.getnumberOfLoadedScores()][4];
        for(int n = 0; n < 1 + data.getnumberOfLoadedScores(); n++) {
            for(int x = 0; x < 4; x++) {
                panelHolder[n][x] = new JPanel();
                header.add(panelHolder[n][x]);
            }
        }
        nameBanner = new JLabel("Name");
        score = new JLabel("score");
        time = new JLabel("Time");
        level = new JLabel("Level");
        panelHolder[0][0].add(nameBanner);
        panelHolder[0][1].add(score);
        panelHolder[0][2].add(time);
        panelHolder[0][3].add(level);
        nameLabels = new Vector();
        scoreLabels = new Vector();
        timeLabels = new Vector();
        levelLabels = new Vector();
        for(int i = 1; i < data.getnumberOfLoadedScores() + 1; i++) {
            JLabel tempLabel = new JLabel((String)data.getValueAt(i - 1, 0));
            panelHolder[i][0].add(tempLabel);
            tempLabel = new JLabel((String)data.getValueAt(i - 1, 1));
            panelHolder[i][1].add(tempLabel);
            tempLabel = new JLabel((String)data.getValueAt(i - 1, 2));
            panelHolder[i][2].add(tempLabel);
            tempLabel = new JLabel((String)data.getValueAt(i - 1, 3));
            panelHolder[i][3].add(tempLabel);
        }
        
        
        
        
        //table = new JTable(data.getloadedScores(), columnNames);
        //scrollPane.add(header);
        this.add(header, "North");
        //load up the java swing components to display on the screen
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setBackground(Color.green);
        
        
        //this.add(nameBanner);
    }
}
