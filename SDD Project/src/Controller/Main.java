
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener, MouseListener, KeyListener {

    private GamePanel gamePanel;
    private final GameData gameData;
    private Animator animator;
    private JButton startButton;
    private JButton quitButton;
    private Launcher launcher;
    private Launcher launcher2;
    private int screenWidth = 800;
    private int screenHeight = 1000;
    private JLabel lbl;
    private Date now = new Date();
    private TempShip ship;
    
    public Main() {
        //changed sizing to fit the default image
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        Container c = getContentPane();
        animator = new Animator();
        gameData = new GameData();
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
        c.add(southPanel, "South");

        gamePanel.addMouseListener(this);
        startButton.setFocusable(false); // "Start" button click should not receive keyboard data
        gamePanel.setFocusable(true); // receives keyboard data
        gamePanel.addKeyListener(this);
        startButton.addActionListener(this);
        quitButton.addActionListener(this);
        
        launcher = (Launcher) gameData.figures.get(0); // launcher        
        pack();
        setVisible(true);
        
        ship = (TempShip) gameData.figures.get(2);
    }
       
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            gamePanel.startGame();
            startTimer();
        } else if (ae.getSource() == quitButton) {
            animator.running = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Color color;
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

        Missile f = new Missile(launcher.getXofMissileShoot(), launcher.getYofMissileShoot(), color);
        f.setTarget(x, y);
        int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
        f.setExplosionMaxSize(size);
         synchronized (gameData.figures) {
            gameData.figures.add(f);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                ship.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                ship.moveRight();
                break;
            case KeyEvent.VK_UP:
                ship.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                ship.moveDown(); 
                break;
            case KeyEvent.VK_1:
                ship.setRateOfSpeed(5);
                ship.setShipType(1);
                break;
            case KeyEvent.VK_2:
                ship.setRateOfSpeed(8);
                ship.setShipType(2);
                break;
            case KeyEvent.VK_3:
                ship.setRateOfSpeed(12);
                ship.setShipType(3);
                break;
            case KeyEvent.VK_4:
                ship.setRateOfSpeed(15);
                ship.setShipType(4);
                break;
            case KeyEvent.VK_5:
                ship.setRateOfSpeed(18);
                ship.setShipType(5);
                break;
            case KeyEvent.VK_6:
                ship.setRateOfSpeed(21);
                ship.setShipType(6);
                break;
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
    //move into controller that handles player input
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    //move into controller that handles player input
    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
