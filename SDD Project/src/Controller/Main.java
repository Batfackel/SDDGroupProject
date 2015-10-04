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

public class Main extends JFrame implements ActionListener {

    private GamePanel gamePanel;
    public static  GameData gameData;
    private Animator animator;
    private JButton startButton;
    private JButton quitButton;
    private Launcher launcher;
    private Launcher launcher2;
    private int screenWidth = 800;
    private int screenHeight = 1000;
    private JLabel lbl;
    private Date now; 
    private JButton leaderBoard;
    private LeaderBoard leaderPanel;
    private Container c;    
    private ShipFactory shipMaker;
    private Ship ship;
    private Ship mainShip;
    private Tutorial tutorial;
    


    private KeyController controller;
    
    public Ship Ship(){
        return this.ship;
    }
    
    public Main() {
        //changed sizing to fit the default image
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        c = getContentPane();
        animator = new Animator();
        gameData = new GameData();

        now = new Date();
        //why do something that gamedata does for me already, just give me what
        //is already there
        //shipMaker = new ShipFactory();
        //ship = shipMaker.getShip("defaultShip", 350, 350);
        ship = (Ship) gameData.ships.get(0);//will checking som
        controller = new KeyController(ship);

       // ship = shipMaker.getShip("defaultShip", 350, 350);
        mainShip = (Ship) gameData.ships.get(0);//will checking som
        controller = new KeyController(mainShip);
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
        
        

        MouseController mouseController = new MouseController(mainShip);
        gamePanel.addMouseListener(mouseController);
        startButton.setFocusable(false); // "Start" button click should not receive keyboard data
        gamePanel.setFocusable(true); // receives keyboard data

      //  gamePanel.addKeyListener(new KeyController());

        gamePanel.addKeyListener(controller);

        startButton.addActionListener(this);
        quitButton.addActionListener(this);
        leaderBoard.addActionListener(this);
        
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
            gamePanel.startGame();
            startTimer();
        } else if (ae.getSource() == quitButton) {
            animator.running = false;
        }
        else if(ae.getSource() == leaderBoard) {
            leaderPanel = new LeaderBoard();
            c.add(leaderPanel, "Center");
            gamePanel.setVisible(false);
            leaderBoard.setVisible(true);
        }
    }

   
    public void setScreenSize(int w, int h){
        this.screenHeight = h;
        this.screenWidth = w;
        setSize(screenWidth, screenHeight);
    }
    private void startTimer(){ 
		now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
		final Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date now2 = new Date(now.getTime() + 1000);
				now = now2;
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
				lbl.setText(formatter.format(now));
			}
		});
                
                timer.start();
    }
    
}
