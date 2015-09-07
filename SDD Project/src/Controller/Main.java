
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

public class Main extends JFrame implements ActionListener/*, MouseListener*/, KeyListener {

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
    //move into controller that handles player input
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    //move into controller that handles player input
    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public static void main(String[] args) {
        JFrame game = new Main();
        
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
