
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame
        implements ActionListener/*, MouseListener*/, KeyListener {

    private GamePanel gamePanel;
    private final GameData gameData;
    private Animator animator;
    private JButton startButton;
    private JButton quitButton;
    private Launcher launcher;
    private Launcher launcher2;
    
    public Main() {
        setSize(615, 480);
        setLocation(100, 100);
        Container c = getContentPane();
        animator = new Animator();
        gameData = new GameData();
        gamePanel = new GamePanel(animator, gameData);
        animator.setGamePanel(gamePanel);
        animator.setGameData(gameData);
        c.add(gamePanel, "Center");

        JPanel southPanel = new JPanel();
        startButton = new JButton("Start");
        southPanel.add(startButton);
        
        quitButton = new JButton("Quit");
        southPanel.add(quitButton);
        c.add(southPanel, "South");

//        gamePanel.addMouseListener(this);
        startButton.setFocusable(false); // "Start" button click should not receive keyboard data
        gamePanel.setFocusable(true); // receives keyboard data
        gamePanel.addKeyListener(this);
        startButton.addActionListener(this);
        quitButton.addActionListener(this);

        launcher = (Launcher) gameData.figures.get(0); // launcher
        launcher2 = (Launcher) gameData.figures.get(0); // launcher
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            gamePanel.startGame();
        } else if (ae.getSource() == quitButton) {
            animator.running = false;
        }
    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        int x = e.getX();
//        int y = e.getY();
//
//        Color color;
//        double r = Math.random();
//        if (r < 0.25) {
//            color = Color.red;
//        } else if (r < 0.5) {
//            color = Color.blue;
//        } else if (r < 0.75) {
//            color = Color.gray;
//        } else {
//            color = Color.green;
//        }
//
//        Missile f = new Missile(launcher.getXofMissileShoot(), launcher.getYofMissileShoot(), color);
//        f.setTarget(x, y);
//        int size = (int) (Math.random() * 100) + 5; // min = 5 max = 105
//        f.setExplosionMaxSize(size);
//
//        synchronized (gameData.figures) {
//            gameData.figures.add(f);
//        }
//    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                launcher.x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                launcher.x += 10;
                break;
        }
    }
//
//    @Override
//    public void mouseClicked(MouseEvent me) {
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent me) {
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent me) {
//    }
//
//    @Override
//    public void mouseExited(MouseEvent me) {
//    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public static void main(String[] args) {
        JFrame game = new Main();
        
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
