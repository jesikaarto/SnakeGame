package snake2d;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * A class that represent a snake in the game
 * @author Jes
 */
public class Snake {
    private final int DEFAULT_SNAKE_LENGTH = 5;
    private final int DEFAULT_SNAKE_DIRECTION = 3;
    private ArrayList<Ellipse2D.Double> body;
    private int direction;
    
    public Snake()
    {
        this.body = new ArrayList<Ellipse2D.Double>();
        for (int i = 0; i < DEFAULT_SNAKE_LENGTH; i++) {
            //posisi x, posisi y, width, height dari tiap elips pada body
            body.add(new Ellipse2D.Double(355 - i * 16, 191, 16, 16) {});
        }
        
        direction = DEFAULT_SNAKE_DIRECTION;
    }

    public int getDirection() 
    {
        return this.direction;
    }

    public void setDirection(int dir) 
    {
        this.direction = dir;
    }
    
    public void eat()
    {
        body.add(body.get(getLength()- 1));
    }
    
    public int getLength()
    {
        return this.body.size();
    }
    
    public ArrayList<Ellipse2D.Double> getBody() 
    {
        return this.body;
    }
    
    public void move()
    {
        for (int i = getLength() - 1; i > 0; i--) {
            body.set(i, body.get(i - 1));
        }
        
        if (direction == 1) { //up
            decreaseY();
        } else if (direction == 2) { //down
            increaseY();
        } else if (direction == 3) { //right
            increaseX();
        } else if (direction == 4) { //left
            decreaseX();
        }
    }
    
    public void increaseY()
    {
        Ellipse2D.Double temp = (Ellipse2D.Double) body.get(0);
        Ellipse2D.Double elli = new Ellipse2D.Double(temp.x, temp.y + 16, 
                temp.getWidth(), temp.getHeight());
        
        body.set(0, (Ellipse2D.Double) elli);
    }
    
    public void decreaseY()
    {
        Ellipse2D.Double temp = (Ellipse2D.Double) body.get(0);
        Ellipse2D.Double elli = new Ellipse2D.Double(temp.x, temp.y - 16, 
                temp.getWidth(), temp.getHeight());
        
        body.set(0, (Ellipse2D.Double) elli);
    }
    
    public void increaseX()
    {
        Ellipse2D.Double temp = (Ellipse2D.Double) body.get(0);
        Ellipse2D.Double elli = new Ellipse2D.Double(temp.x + 16, temp.y, 
                temp.getWidth(), temp.getHeight());
        
        body.set(0, (Ellipse2D.Double) elli);
    }
    
    public void decreaseX()
    {
        Ellipse2D.Double temp = (Ellipse2D.Double) body.get(0);
        Ellipse2D.Double elli = new Ellipse2D.Double(temp.x - 16, 
                temp.y, temp.getWidth(), temp.getHeight());
        
        body.set(0, (Ellipse2D.Double) elli);
    }
    
    public Ellipse2D.Double getHead()
    {
        return body.get(0);
    }
}
