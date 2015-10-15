/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Main;
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


import Controller.SaveData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;;

import Controller.SaveData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Will
 */
public class ShipSelect extends JPanel implements ActionListener{
    public static final String ship1 = "Ship 1";
    public static final String ship2 = "Ship 2";
    public static final String ship3 = "Ship 3";
    public static final String ship4 = "Ship 4";
    public static final String ship5 = "Ship 5";
    public static final String ship6 = "Ship 6";
    public static final String select = "Select Ship";

    private Image shipSelectScreen = null;
    public static final int PWIDTH = 800; // size of the game panel
    public static final int PHEIGHT = 800;
    private JPanel main;
    private JButton selectButton=null;
    private JRadioButton[] ship= new JRadioButton[6];
    private String shipSelected = null;

    public ShipSelect() {
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        shipSelectScreen = getImage(imagePath + separator + "images"
                + separator + "tempShipSelectMenu.png");
        main = new JPanel(new GridBagLayout());

        selectButton = new JButton(select);
        ship[0] = new JRadioButton(ship1);
        ship[1] = new JRadioButton(ship2);
        ship[2] = new JRadioButton(ship3);
        ship[3] = new JRadioButton(ship4);
        ship[4] = new JRadioButton(ship5);
        ship[5] = new JRadioButton(ship6);

        GridBagConstraints c =  new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        main.add(ship[0]);
        c.gridx = 1;
        c.gridy = 0;
        main.add(ship[1]);
        c.gridx = 2;
        c.gridy = 0;
        main.add(ship[2]);
        c.gridx = 0;
        c.gridy = 1;
        main.add(ship[3]);
        c.gridx = 1;
        c.gridy = 1;
        main.add(ship[4]);
        c.gridx = 2;
        c.gridy = 1;
        main.add(ship[5]);

        main.add(selectButton);
        this.add(main, "South");

        ship[0].addActionListener(this);
        ship[1].addActionListener(this);
        ship[2].addActionListener(this);
        ship[3].addActionListener(this);
        ship[4].addActionListener(this);
        ship[5].addActionListener(this);
        selectButton.addActionListener(this);
        //load up the java swing components to display on the screen
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setBackground(Color.red);


        //this.add(nameBanner);
    }
 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(shipSelectScreen, 0, 0, null); // see javadoc for more info on the parameters
        //g.drawImage(playerSpriteSheet, (int) this.x, (int) this.y, (int) x + 25, (int) y + 40, 144, 16, 169, 52, null, null);
    }

    public static Image getImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }
    @Override
    public void actionPerformed(ActionEvent se) {
        if (se.getSource() == selectButton) {
            if (ship[0].isSelected()) {
                shipSelected = "defaultship";
            } else if (ship[1].isSelected()) {
                shipSelected = "shipx";
            } else if (ship[2].isSelected()) {
                shipSelected = "shipy";
            } else if (ship[3].isSelected()) {
                shipSelected = "shipz";
            } else if (ship[4].isSelected()) {
                shipSelected = "shipw";
            } else {
                shipSelected = "shipv";
            }
        }
        MainMenu.m.gamePanel.startGame(MainMenu.m.lbl);
        MainMenu.m.startButton.setEnabled(false);
    }
public String getShipSelection(){
        return shipSelected;
}
}
// if (shipSelection.equalsIgnoreCase("defaultship")){
//        else if (shipSelection.equalsIgnoreCase("shipx")){
//        else if (shipSelection.equalsIgnoreCase("shipy")){
//        else if (shipSelection.equalsIgnoreCase("shipz")){
//
//         else if (shipSelection.equalsIgnoreCase("shipw")){
//
//          else if (shipSelection.equalsIgnoreCase("shipv")){