/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author YuchenFeng
 */
public class StartScreen extends JFrame {
    public StartScreen(){
        setSize(600,400);
        setLocation(0, 0);
        Container c = getContentPane();
        c.add(new MainMenu(), "Center");
        pack();
    }
    
        public static void main(String[] args) {
            
 SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run()
            {
                new StartScreen().setVisible(true);
            }

        });
    }
}
