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
import java.util.Set;

public class Main extends JFrame implements ActionListener, MouseListener {

    private GamePanel gamePanel;
    public final GameData gameData;
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
    


    public KeyController controller;
    
    /*public Ship Ship(){
        return this.ship;
    }*/
    
    public Main() {
        //changed sizing to fit the default image
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        c = getContentPane();
        animator = new Animator();
        gameData = new GameData();

        now = new Date();
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
        
        

        gamePanel.addMouseListener(this);
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

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //----------------------------------------------------------------------
        //changes the types of bullet shot. This changes the weapon type when 
        //the ship weapon state changes - 9/10/2015
        //----------------------------------------------------------------------
        Color color;
        /*
        double r = Math.random();
        if (r < 0.25) {
            color = Color.red;
        } else if (r < 0.5) {
            color = Color.blue;
        } else if (r < 0.75) {
            color = Color.gray;
        } else {
            color = Color.green;
        }
        */       
        System.out.println("this is the state -------- " + mainShip.getLevelState());
        //switch(launcher.getLevelState()){            
        switch(mainShip.getLevelState()) {
            case 0: color = Color.gray;
                break;
            case 1: color = Color.blue;
                break;
            case 2: color = Color.green;
                break;
            case 3: color = Color.red;
                break;
            default: color = Color.yellow;
        }
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //Missile f = new Missile(launcher.getXofMissileShoot(), launcher.getYofMissileShoot(), color);
        Missile f = new Missile(mainShip.getXofMissileShoot(), mainShip.getYofMissileShoot(), color);
        f.setTarget(x, y);
        int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
        f.setExplosionMaxSize(size);
         synchronized (gameData.figures) {
            gameData.figures.add(f);
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
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
//    void setKeyController(KeyController keyCon)
//    {
//      
//        mainShip = (Ship) gameData.ships.get(0);
//        keyCon.setShip(mainShip);        
//    }
    //move into controller that handles player input
    
    //initial main not needed
    /*
    public static void main(String[] args) {
        JFrame game = new Main();
        //game.setTitle("Beggar's Canyon");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
    */
}
