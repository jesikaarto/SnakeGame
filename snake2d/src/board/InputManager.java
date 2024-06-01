package board;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class that represent the keyboard control of the game
 * @author TUF
 */
public class InputManager implements KeyListener {
    
    private GameBoardPanel gameBoard;
    
    public InputManager(GameBoardPanel gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    /**
    * Method abstraknya wajib dioverride...
    * tetapi karena tidak butuh diatur aksinya,
    * maka tidak diisi aksi apapun di dalam methodnya
    */
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
    
        if (key == KeyEvent.VK_UP) 
        { //up arrow key
            gameBoard.changeSnakeDirection(1);
        }
        else if (key == KeyEvent.VK_DOWN)
        { //down arrow key
            gameBoard.changeSnakeDirection(2);
        }
        else if (key == KeyEvent.VK_RIGHT)
        { //right arrow key
            gameBoard.changeSnakeDirection(3);
        }
        else if (key == KeyEvent.VK_LEFT)
        { //left arrow key
            gameBoard.changeSnakeDirection(4);
        }
        else if (key == KeyEvent.VK_SPACE)
        { //space key
            if (gameBoard.isGameRunning()) {
                gameBoard.pauseGame();
            }
            else {
                gameBoard.startGame();
            }
        }
        else if (key == KeyEvent.VK_ESCAPE)
        { //esc key
            System.exit(0);
        }
    }  
}
