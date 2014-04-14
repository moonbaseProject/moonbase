import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
	public static String title = "Moonbase Alpha";
	public static Dimension size = new Dimension (1000, 800);
        // gamegrid offset from top left
	public static int gridOffset_x = 0;
        public static int gridOffset_y = 0;
        public static boolean showGameGrid = true; // turns grid off when true
        
        // Start and end points
        public  Point pathStart = new Point(0,0); //Point(50,50);
       // public  Point pathStart = new Point(300,100); //Point(50,50);
        //public  Point pathStart = new Point(300,100); //Point(50,50);
        public  Point pathEnd = new Point(700,450);
        
        public static int totalRows = 11;
        public static int totalColumns =16;
        
	public Frame() {
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
                
	}
	
	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		Screen screen = new Screen(this);
		add(screen);
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		Frame frame = new Frame();
	}
}
