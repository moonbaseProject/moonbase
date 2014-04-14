/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Alan Kinghorn <1074159>
 */
public class KeyHandler implements KeyListener{
    
    private Screen screen;
    private Screen.KeyTyped keyTyped;
            
    public KeyHandler(Screen screen){
        this.screen = screen;
        this.keyTyped = this.screen.new KeyTyped();
        
        
    }
    
    

    
    public void keyTyped(KeyEvent e) {
      
    }

    
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        
        
        if(keyCode == 27){ // escape key
            System.out.println("esc pressed");
            this.keyTyped.keyESC();
            
        }
        
        if(keyCode == 32){ // escape key
            System.out.println("Space pressed");
            this.keyTyped.keySPACE();
            
        }
        
         if(keyCode == 83){ // escape key
            System.out.println("S pressed");
            this.keyTyped.keyS();
            
        }
        
        // test the kh
         System.out.println(e.getKeyCode());
    }

    
    public void keyReleased(KeyEvent e) {

    }
    
}
