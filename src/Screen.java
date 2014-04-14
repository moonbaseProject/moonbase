
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.*;
import pkg_gui.PathFinder;
import pkg_types.GridDef;
import pkg_types.Obstacles;

public class Screen extends JPanel implements Runnable {
        // list for main grid.  
        ArrayList<GridDef> mainGrid = new ArrayList<GridDef>();
        
        // get the AverageEnemy
        BossEnemy be = new BossEnemy(50,0);
        AverageEnemy ae = new AverageEnemy(100,0);
        AverageEnemy ae_2 = new AverageEnemy(150,0);              
        AverageEnemy ae_3 = new AverageEnemy(250,0);
        TankFront tf_1 = new TankFront(300, 0);
        Blocks block  = new Blocks(0,0);
        
        
        
        public Point MouseXY = new Point(0,0);
        public Point NodeTL = new Point();
        
        
        // background image
	private BufferedImage img;
        private BufferedImage moonBase;
        private BufferedImage enemyEntrance;
        //Tarrain
        //private BufferedImage blocks;
        
        public boolean isRunning = false ;
        
        // BossEnemy cords
        public Point BossEnemy = new Point();
        public Point r ;
        public Point q;
        public Point s;
         public Point t;
         public Point v; 
         
         
        public int pathSize ;
        
        Frame frame;
	public Thread thread = new Thread(this);
	public static int myWidth, myHeight;
	MouseAdapter myMouseAdapter;
        PathFinder pf = new PathFinder();
        
	public Screen(Frame frame) {
            //thread.start();
            this.frame = frame;
            isRunning = true;      
            
            //  set enamy start position
            setEnemyStertEndPositions();
            
            try {
                    // background image
                    img = ImageIO.read(new File("./res/images/NEWLayoutDesign1000x800.jpg"));
                    moonBase = ImageIO.read(new File("./res/images/MoonBaseGraphic.png"));
                    enemyEntrance = ImageIO.read(new File("./res/images/EnemyEntrance.png"));// = ImageIO.read(new File("./res/images/MoonBaseGraphic.png"));
                    //blocks = ImageIO.read(new File("terrain.png"));
                    
                    //EnemyBoss = ImageIO.read(new File("./res/images/AverageFront.png"));
                    //EnemyBoss = ImageIO.read(new File("./res/images/BossFront.png"));
            } catch(IOException e) {
                    e.printStackTrace();
            }
              
            
            
            
            
            
            this.frame.addKeyListener(new KeyHandler(this));  
            //this.frame.addMouseListener(new MyMouseListener(this));
        
                //Adds mouse handling
                MouseAdapter mouseHandler;
		mouseHandler = new MouseAdapter() {
			
			
		//public Point currentHoverPoint;




			//--------------------------------------------
			@Override
			public void mousePressed(MouseEvent e) {
				// get the grid number not the actual coords
				
				System.out.println("mpressed");
				
				// show indication of node being hovered over
				
				//repaint();
				
			}
			
			
			
			
			//--------------------------------------------

			public void mouseMoved(MouseEvent e) {

				MouseXY.x = e.getX();// / cellWidth;
				MouseXY.y = e.getY();// / cellHeight;

                                // calc the current node top left
                                NodeTL.x = (MouseXY.x/50)*50;
				NodeTL.y = (MouseXY.y/50)*50;
                                
                                
				//controls.coordReadout.setText(x + ", " + y);
				//System.out.println(x+","+y);
				
				//Point nodeStart = new Point();
				
				//nodeStart.x = (x/nodeSize)*nodeSize;
				//nodeStart.y = (y/nodeSize)*nodeSize;
				
				
				// to display an indication of node being hovered over
				//currentHoverPoint.x = nodeStart.x;
				//currentHoverPoint.y = nodeStart.y;
				
				
//				for(GridDef sc : mainGrid){
//					
//					if(sc.x == nodeStart.x && sc.y == nodeStart.y){
//						
//						controls.coordReadout2.setText(sc.rx + ", " + sc.ry);
//					}
//					
//				}
				
			}
			
			//--------------------------------------------
			
			@Override
			public void mouseDragged(MouseEvent e) {
                            
                            
                        MouseXY.x = e.getX();// / cellWidth;
                        MouseXY.y = e.getY();// / cellHeight;

                        // calc the current node top left
                        NodeTL.x = (MouseXY.x/50);
                        NodeTL.y = (MouseXY.y/50);
                            
                            
                        //if(controls.draw.getState()==true){    
                        if(true){

					pf.pf_obstacles.add(new Obstacles(NodeTL.x, NodeTL.y, Color.red));
					
					
				 } else{
					 
					 removeObstacle(NodeTL.x, NodeTL.y);
					 //controls.pf.pf_obstacles.remove   (node_x, node_y); 
				 }  

			repaint();	          
                        }
			
			

		};
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
        
                
       createGrid();        
        
       
        
        
       // startPathFinding();
        
       // pathSize = pf.pf_thePath.size(); // the path size
        
       // Collections.reverse(pf.pf_thePath);
        
	}
        
        public void startPathFinding(){
        pf.PathStart.x=(frame.pathStart.x/50);
        pf.PathStart.y=(frame.pathStart.y/50);
        
        pf.PathEnd.x=(frame.pathEnd.x/50);
        pf.PathEnd.y=(frame.pathEnd.y/50);
        
        pf.total_rows = Frame.totalRows; // y's
	pf.total_columns = Frame.totalColumns; // x's
        
        pf.startPathFinding();
        pathSize = pf.pf_thePath.size(); // the path size
        
        Collections.reverse(pf.pf_thePath);

        }
        
        
        public void setEnemyStertEndPositions(){
            be.setStart(100, 650);
            ae.setStart(150, 650);
            ae_2.setStart(200, 650);
            ae_3.setStart(250, 650); 
            tf_1.setStart(300, 650);
        }
        
        
        	private void removeObstacle(int rx, int ry)
	/*
	 * removes an obstacle entry
	 */
	
	{
		
		int index=0;
		for(Obstacles ob: pf.pf_obstacles){
			
			
			if(ob.rx == rx && ob.ry == ry){
				pf.pf_obstacles.remove(index);
			}
			
			
		index++;	
		}
		
		
	}
        
        
        
        
        
        
        
        
        
        public void createGrid()
	/*
	 * fill the maingrid list with grid coordinates
	 */
	{
	
		mainGrid.clear();
		for (int i = 0; i < Frame.totalRows; i++) {
			for (int j = 0; j < Frame.totalColumns; j++) {
			
				
				// calc the node x & y
				int x = (j*50)+frame.gridOffset_x;
				int y = (i*50)+frame.gridOffset_y;
				
				mainGrid.add(new GridDef(x, y, j, i, Color.white, "-") );
				
			
				
			}
			
		}
		mainGrid.add(new GridDef(this.frame.pathStart.x, this.frame.pathStart.y, 0, 0, Color.GREEN, "s") );
                mainGrid.add(new GridDef(this.frame.pathEnd.x, this.frame.pathEnd.y, 0, 0, Color.RED, "e") );
                

                
                
                
                //this.repaint();
		//controls.pf.pf_obstacles.clear();
		
	}
        
        
        
	
	public void define() {
		
	}
	
        
        
@Override
 protected void paintComponent(Graphics g) {
                define();

    super.paintComponent(g);
    // paint the background image and scale it to fill the entire space
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    g.drawImage(moonBase, 700, 450, 100, 72, this);
    g.drawImage(moonBase, 2, 2, 100, 72, this);
    
    
    
     
           
    // set the grid colour
    g.setColor(Color.GRAY);       
    // draws the grid      
    //    for(int x=0; x < 18; x++){ // 18 in x
    //
    //        for(int y=0; y<10;y++){ // 10 in y
    //            g.drawRect(50+(x*50), 50 +(y*50), 50, 50);
    //        }
    //
    //
    //
    //    }
    
    if(Frame.showGameGrid){
       // add filled rectangle
        for (GridDef tc : mainGrid) {

                //g.setColor(tc.cColour);
                //g.fillRect(tc.x, tc.y, 50, 50);
                g.setColor(tc.cColour);
                g.drawRect(tc.x, tc.y, 50, 50);
        } 
    }
    
    
    
    // disply the obstacles
    for (Obstacles dd : pf.pf_obstacles) {

            //g.setColor(dd.colour);
            //g.fillRect(dd.rx*50, dd.ry*50, 50, 50);
            //g.setColor(Color.lightGray);
            //g.drawRect(dd.rx*50, dd.ry*50, 50, 50);
        g.drawImage(block.getImage(), dd.rx*50, dd.ry*50, 50, 50, this);
        
        

    }
    
    
    
    
    // Display the path 
    for (Obstacles cc : pf.pf_thePath) {

            //g.setColor(Color.YELLOW);
            //g.fillRect(cc.rx*50+50, cc.ry*50+50, 50, 50);
            g.setColor(Color.YELLOW);
            g.drawRect(cc.rx*50, cc.ry*50, 50, 50);

    }
    
    
    // Move the Enemies
    g.drawImage(be.getImage(), be.getX(), be.getY(), 50, 50, this);
    g.drawImage(ae.getImage(), ae.getX(), ae.getY(), 50, 50, this);    
    g.drawImage(ae_2.getImage(), ae_2.getX(), ae_2.getY(), 50, 50, this);
    g.drawImage(ae_3.getImage(), ae_3.getX(), ae_3.getY(), 50, 50, this);
    g.drawImage(tf_1.getImage(), tf_1.getX(), tf_1.getY(), 50, 50, this);
    
    
    // fill current node
    // if within grid bounds
    if((NodeTL.x>=50 && NodeTL.y>=50) && (NodeTL.x<=(50*18) && NodeTL.y<=(50*10))){
        g.setColor(Color.BLUE);
        g.drawRect(NodeTL.x, NodeTL.y, 50, 50);
    }
    
    // draw the mouse xy
    g.setColor(Color.YELLOW);
    g.drawString(MouseXY.x+","+MouseXY.y+"", 20,  20);
    
  }
	
 public Point getNextMove(int xx){
     Point p = new Point();
     if(xx<pathSize){
        
        p.x = (int) pf.pf_thePath.get(xx).rx;
        p.y = (int) pf.pf_thePath.get(xx).ry; 
        return p;
     }
     
     return p;
 }
 
 
 
	public void run () {
            // start pos of enamies
            //ae_2.setStart(50, 0);
            //ae_2.setStart(100, 0);
            //repaint();
            int h = 0;
            int i=0;
            int j=0;
            int k=0;
            int m=0;
            int n=0;
            //this.ps = pf.pf_thePath.size();
		while(i<70) {

			
			
			try {
                            
                            Thread.sleep(320);
                            
                            // get the next xy from the path list
                            
                              if(i<=0){h=0;} else {
                                q = new Point(getNextMove(h));
                                this.be.move(q.x*50, q.y*50 );
                              }
                                
                            
                           
                                
                                if(i<=6){j=0;
                                }else{
                                
                                r = new Point(getNextMove(j));
                                this.ae.move(r.x*50, r.y*50 );
                                }
                                
                          
                                if(i<=9)
                                {
                                    k=0;
                                }else {
                                s = new Point(getNextMove(k));
                                this.ae_2.move(s.x*50, s.y*50 );
                                }
                                
                                
                                
                                
                                if(i<=13){m=0;}else {
                                t = new Point(getNextMove(m));
                                this.ae_3.move(t.x*50, t.y*50  );
                                }
                                
                                
                                if(i<=14){n=0;}else {
                                v = new Point(getNextMove(n));
                                this.tf_1.move(v.x*50, v.y*50  );
                                }
                            
                            System.out.println("i: "+i+" : "+"j: "+j+"ps:"+pathSize);
                                    
                             h++;       
                            i++; 
                            j++;
                            k++;
                            m++;
                            n++;
                            
                            repaint();
                            
                            
			} 
                        catch(Exception e)
                        {
                            System.out.printf(e.getMessage());
                        }
                      
                 
                      
		}
                
         repaint();        
         this.be.move(50, 0 );       
         this.ae.move(100, 0 );
         this.ae_2.move(150, 0 ); 
         this.ae_3.move(200, 0 ); 
         
               
                
                
	}
        
        
        
 public class KeyTyped{ 
        
        public void  keyESC(){
            
           //running = false;
            System.out.println("KT Screen-Esc");
        }
        
        
        public void  keySPACE(){
           System.out.println("KT Screen-Space"); 
          // scene = 1;
          // isRunning = true;
           
          System.out.println("KT S pressed");
            
            
            if(!thread.isAlive()){
            createGrid();  
            startPathFinding();    
            thread.start();
            }
        }
        
        public void  keyS(){
            
           //running = false;
            //startPathFinding();
            
           thread.suspend();
           
        }
        
    }        
        
        
}