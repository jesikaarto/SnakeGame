package mainWindow;

import javax.swing.JFrame;

/**
 * The start window of the game
 * @author Jes
 */
public class MainFrame extends JFrame{
    
    private MainPanel mainPanel;
    
    public MainFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320, 127, 600, 400); //x, y, width, height
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel = new MainPanel(this);
        this.getContentPane().add(mainPanel);
    }
}
