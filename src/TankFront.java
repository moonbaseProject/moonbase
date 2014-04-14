
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alan Kinghorn <1074159>
 */
public class TankFront {
    
    public int x, y;
    private Image image;
    boolean visible;
    
    public int score = 20;
     

    
    public TankFront(int x, int y) {

        ImageIcon ii = new ImageIcon(this.getClass().getResource("TankFront.png"));
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setStart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    public boolean isVisible() {
        return visible;
    }

    public void move(int x, int y) {
        this.x=x;
        this.y=y;
        
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
