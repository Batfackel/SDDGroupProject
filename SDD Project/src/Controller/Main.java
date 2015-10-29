package Controller;

import Model.Launcher;
import Model.GameData;
import Model.Missile;
import Model.Ship;
//import Model.ShipFactory;
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
import View.ShipSelect;
import java.awt.event.KeyListener;
import java.io.IOException;
import Model.Sound;

public class Main extends JFrame implements ActionListener {

    public GamePanel gamePanel;
    public static  GameData gameData;
   //public static GameData gameData2;
    private Animator animator;
    //private Animator animator2;
    public JButton startButton;
    private JButton quitButton;
    private JButton pauseButton;
    private JButton selectShipButton;
    private Launcher launcher;
    private Launcher launcher2;
    private int screenWidth = 800;
    private int screenHeight = 1000;
    public JLabel lbl;
    private int count;
    private JButton leaderBoard;
    private LeaderBoard leaderPanel;
    private Container c;   
    //private ShipFactory shipMaker;
    private Ship ship;
    private Ship mainShip;
    private Tutorial tutorial;
    private ShipSelect shipSelector = new ShipSelect();

    private String shipName = null;

    private KeyController controller;
    public MouseController mouseController;
    public Ship Ship(){
        return this.ship;
    }
    
    public Main(String shipN) throws IOException {
        //changed sizing to fit the default image
        this.shipName = shipN;
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        c = getContentPane();
        animator = new Animator();
        gameData = new GameData(this.shipName);

//        animator2 = new Animator();
//        gameData2 = new GameData();
        //why do something that gamedata does for me already, just give me what
        //is already there
        //shipMaker = new ShipFactory();
        //ship = shipMaker.getShip("defaultShip", 350, 350);
       

       // ship = shipMaker.getShip("defaultShip", 350, 350);
        mainShip = (Ship) gameData.ships.get(0);//will checking som
        controller = new KeyController(mainShip, this);
        controller.setGameData(gameData);
//Add before here
        gamePanel = new GamePanel(animator, gameData);
        animator.setGamePanel(gamePanel);
        animator.setGameData(gameData);
        c.add(gamePanel, "Center");

        JPanel southPanel = new JPanel();
        
        lbl = new JLabel("00:00:00");
        southPanel.add(lbl);
        
        startButton = new JButton("Start");
        southPanel.add(startButton);
        
        selectShipButton = new JButton("Select Ship");
        southPanel.add(selectShipButton);
        
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
        selectShipButton.addActionListener(this);
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
          if (count == 0) {
          Sound.sound1.loop();
          count = 3;}
        }
//        else if (ae.getSource() == selectShipButton) {
//            gamePanel.pauseGame();
//            c.add(shipSelector, "Center");
//            gamePanel.setVisible(false);
//            shipSelector.setVisible(true);
//            selectShipButton.setEnabled(false);
//        } 
        else if (ae.getSource() == quitButton) {
            animator.running = false;
        }
        else if(ae.getSource() == leaderBoard) {
            leaderPanel = new LeaderBoard();
            c.add(leaderPanel, "Center");
            gamePanel.setVisible(false);
            leaderBoard.setVisible(true);
           ;
        }
        else if(ae.getSource() == pauseButton) {
            if (!animator.isPause()) {
                gamePanel.pauseGame();
                Sound.sound1.stop();
                pauseButton.setText("Resume");
            }
            else{
                gamePanel.resumeGame();
                pauseButton.setText("Pause");
                Sound.sound1.play();
            }
            
        }
    }

   
    public void setScreenSize(int w, int h){
        this.screenHeight = h;
        this.screenWidth = w;
        setSize(getScreenWidth(), getScreenHeight());
    }

    public void setShipName(String ship) {
        this.shipName = ship;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public String getShipName() {
        return shipName;
    }
}
