/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SaveData;
import Model.Level;
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
public class LeaderBoard extends JPanel{
    private SaveData data;
    private Image dbImage = null;
    private Graphics graphics;
    public static final int PWIDTH = 800; // size of the game panel
    public static final int PHEIGHT = 800;
    private JLabel nameBanner, score, time, level;
    private Vector<JLabel> nameLabels, scoreLabels, timeLabels, levelLabels;
    private JPanel header;
    private JTable table;
    private JScrollPane scrollPane;
            
    public LeaderBoard() {
        //read the data file to get what scores are in there
        data = new SaveData(true);
        data.readFile();
        
        header = new JPanel();
        GridLayout layout = new GridLayout(1 + data.getnumberOfLoadedScores(),4, 20, 20);
        //header.setPreferredSize(new Dimension(getWidth(), 100));
        header.setBackground(Color.green);
        header.setLayout(layout);
        nameBanner = new JLabel("Name");
        score = new JLabel("score");
        time = new JLabel("Time");
        level = new JLabel("Level");
        header.add(nameBanner);
        header.add(score);
        header.add(time);
        header.add(level);
        nameLabels = new Vector();
        scoreLabels = new Vector();
        timeLabels = new Vector();
        levelLabels = new Vector();
//        for(int i = 0; i < data.getnumberOfLoadedScores(); i++) {
//            String name = (String)data.getValueAt(i, 0);
//            nameLabels.add(new JLabel(name));
//            scoreLabels[i] = new JLabel((String)data.getValueAt(i, 1));
//            timeLabels[i] = new JLabel((String)data.getValueAt(i, 2));
//            levelLabels[i] = new JLabel((String)data.getValueAt(i, 3));
//            header.add(nameLabels[i]);
//            header.add(scoreLabels[i]);
//            header.add(timeLabels[i]);
//            header.add(levelLabels[i]);
//        }
        
        
        
        
        //table = new JTable(data.getloadedScores(), columnNames);
        //scrollPane.add(header);
        this.add(header, "North");
        //load up the java swing components to display on the screen
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setBackground(Color.green);
        
        
        //this.add(nameBanner);
    }
}
