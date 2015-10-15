package Controller;

import Model.Launcher;
import Model.GameData;
import Model.Missile;
import Model.Ship;
import Model.ShipFactory;
import Model.Tutorial;
import View.LeaderBoard;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import View.GamePanel;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {

    private GamePanel gamePanel;
    public static  GameData gameData;
    private Animator animator;
    private JButton startButton;
    private JButton quitButton;
    private JButton pauseButton;
    private Launcher launcher;
    private Launcher launcher2;
    private int screenWidth = 800;
    private int screenHeight = 1000;
    private JLabel lbl;

    private JButton leaderBoard;
    private LeaderBoard leaderPanel;
    private Container c;   
    private ShipFactory shipMaker;
    private Ship ship;
    private Ship mainShip;
    private Tutorial tutorial;
    


    private KeyController controller;
    public MouseController mouseController;
    public Ship Ship(){
        return this.ship;
    }
    
    public Main() throws IOException {
        //changed sizing to fit the default image
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        c = getContentPane();
        animator = new Animator();
        gameData = new GameData();


        //why do something that gamedata does for me already, just give me what
        //is already there
        //shipMaker = new ShipFactory();
        //ship = shipMaker.getShip("defaultShip", 350, 350);
       

       // ship = shipMaker.getShip("defaultShip", 350, 350);
        mainShip = (Ship) gameData.ships.get(0);//will checking som
        controller = new KeyController(mainShip, this);
        controller.setGameData(gameData);

        gamePanel = new GamePanel(animator, gameData);
        animator.setGamePanel(gamePanel);
        animator.setGameData(gameData);
        c.add(gamePanel, "Center");

        JPanel southPanel = new JPanel();
        
        lbl = new JLabel("00:00:00");
        southPanel.add(lbl);
        
        startButton = new JButton("Start");
        southPanel.add(startButton);
        
        quitButton = new JButton("Quit");
        southPanel.add(quitButton);
        
        leaderBoard = new JButton("Scores");
        southPanel.add(leaderBoard);
        c.add(southPanel, "South");
        
        pauseButton = new JButton("Pause");
        southPanel.add(pauseButton);
        
        
        mouseController = new MouseController(mainShip);
        gamePanel.addMouseListener(mouseController);
        startButton.setFocusable(false); // "Start" button click should not receive keyboard data
        gamePanel.setFocusable(true); // receives keyboard data
        pauseButton.setFocusable(false); // "Pause" button click should not receive keyboard data

      //  gamePanel.addKeyListener(new KeyController());

        gamePanel.addKeyListener(controller);

        startButton.addActionListener(this);
        quitButton.addActionListener(this);
        leaderBoard.addActionListener(this);
        pauseButton.addActionListener(this);

        //launcher = (Launcher) gameData.figures.get(1); // launcher      
       // ship = (Ship) gameData.ships.get(0);
        pack();
        setVisible(true);
        
        tutorial = new Tutorial();
        gamePanel.addMouseListener(tutorial);
        /*yuchen can you move the keylistener in the tutorial to the keyController class*/
        gamePanel.addKeyListener(tutorial);
                 synchronized (gameData.figures) {
            gameData.figures.add(tutorial);
        }
       // gameData.figures.add(tutorial);
//        Ship ship;
//        ship = (Ship) gameData.ships.get(0);

    }
     
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            gamePanel.startGame(lbl);
            startButton.setEnabled(false);
        } else if (ae.getSource() == quitButton) {
            animator.running = false;
        }
        else if(ae.getSource() == leaderBoard) {
            leaderPanel = new LeaderBoard();
            c.add(leaderPanel, "Center");
            gamePanel.setVisible(false);
            leaderBoard.setVisible(true);
            //use pause to show leaderboard better
        }
        else if(ae.getSource() == pauseButton) {
            if (!animator.isPause()) {
                gamePanel.pauseGame();
                
                pauseButton.setText("Resume");
            }
            else{
                gamePanel.resumeGame();
                pauseButton.setText("Pause");
            }
            
        }
    }

   
    public void setScreenSize(int w, int h){
        this.screenHeight = h;
        this.screenWidth = w;
        setSize(screenWidth, screenHeight);
    }

    
    public int getScreenHeight() {
        return screenHeight;
    }
    
    public int getScreenWidth() {
        return screenWidth;
    }
    
}
