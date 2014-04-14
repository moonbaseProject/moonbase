/**
 * ® ALKinghorn duckend.net
 * Please do not modify this class in any way
 * Please do not modify this class in any way
 * Please do not modify this class in any way
 * Please do not modify this class in any way
 */


package pkg_gui;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import pkg_types.GoNoGo;
import pkg_types.GridDef;
import pkg_types.Obstacles;
import sun.awt.windows.ThemeReader;
import sun.net.www.content.text.plain;

public class PathFinder {

	private int parent_F = 0;
	private int G_currentParent = 0;
	private int parent_H = 0;

	// the main grid
	// ArrayList<GridDef> pf_mainGrid = new ArrayList<GridDef>();
	
	//the boundary of the thing!!
	
        public ArrayList<Obstacles> pf_thePath;
	// the generated path
	//ArrayList<Obstacles> pf_thePath = new ArrayList<Obstacles>();

	public ArrayList<Obstacles> pf_obstacles  ;

	// The OPEN list
	ArrayList<GoNoGo> openList = new ArrayList<GoNoGo>();

	// The CLOSED list
	ArrayList<GoNoGo> closedList = new ArrayList<GoNoGo>();

	// the path start and end points
	public Point PathStart = new Point();
	public Point PathEnd = new Point();

	public int total_rows; // y's
	public int total_columns; // x's

	//private Controls pg;

//	public PathFinder(Controls controls) {
//		// TODO Auto-generated constructor stub
//		this.pg = controls;
//
//	}

	public PathFinder() {
		// TODO Auto-generated constructor stub
            
            pf_thePath = new ArrayList<Obstacles>();
            pf_obstacles = new ArrayList<Obstacles>();
            
            // temp create some obstacles
//            pf_obstacles.add( new Obstacles(2, 1, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 2, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 3, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 4, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 5, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 6, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 7, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 8, Color.blue));
//            pf_obstacles.add( new Obstacles(2, 9, Color.blue));
//            
//            
//            // temp create some obstacles
//            
//            pf_obstacles.add( new Obstacles(6, 0, Color.blue));
//            pf_obstacles.add( new Obstacles(6, 1, Color.blue));            
//            pf_obstacles.add( new Obstacles(6, 2, Color.blue));
//            pf_obstacles.add( new Obstacles(6, 3, Color.blue));
//            pf_obstacles.add( new Obstacles(6, 4, Color.blue));
//            pf_obstacles.add( new Obstacles(6, 5, Color.blue));
//            pf_obstacles.add( new Obstacles(6, 6, Color.blue));
//            pf_obstacles.add( new Obstacles(6, 7, Color.blue));
//            pf_obstacles.add( new Obstacles(7, 5, Color.blue));
//            pf_obstacles.add( new Obstacles(8, 5, Color.blue));
//            pf_obstacles.add( new Obstacles(9, 5, Color.blue));
//            
//            
//            
//            
//            
//            
//            
//            // temp create some obstacles
//            pf_obstacles.add( new Obstacles(11, 1, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 2, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 3, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 4, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 5, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 6, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 7, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 8, Color.blue));
//            pf_obstacles.add( new Obstacles(11, 9, Color.blue));
//            
//            pf_obstacles.add( new Obstacles(8, 2, Color.blue));
//            pf_obstacles.add( new Obstacles(9, 2, Color.blue));
//            pf_obstacles.add( new Obstacles(10, 2, Color.blue));
//            
//            
            
            
	}

	
	
	
	
	
	
	
	
	
	/*
	 * feed the end coords
	 */
	public void fillThePath(int nx, int ny, Color colour)
	{
		
		
		
		
		for(GoNoGo tp : closedList){
			// start at the target
			
			if(tp.rx == nx && tp.ry == ny){
				
				// exit loop if start found
				if(tp.Px==PathStart.x && tp.Py == PathStart.y){
					break;
				}
				
				pf_thePath.add(new Obstacles(tp.Px, tp.Py, colour));
				
				
				
				
				fillThePath(tp.Px, tp.Py, colour);
				
			
		
		
			}
	
	}
 
	}

	public void startPathFinding() { // exciting eh...

		
		
		
		
		
		// add the starting node to the OPEN list
		// PathStart set when start node is first selected
		openList.add(new GoNoGo(PathStart.x, PathStart.y));

		processOpen();

		if(openList.size()==0){
			
			int result = JOptionPane.showConfirmDialog(null,"Clear grid?","No Path Found!",JOptionPane.YES_NO_OPTION);
		
		
			if (result == JOptionPane.YES_OPTION) {
		         System.out.println("Yes" );
		         
		         
		         
		         
		         
		         
		      } else {
		    	  
		    	  System.out.println("No" );
		      }
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	private void processOpen() {

		// pocess the first node
		// processNeighbours(PathStart.x, PathStart.y);

		// loop the openList if not empty
		// for(GoNoGo open : openList){
		// The list GoList expands as more nodes are added
		//int length = openList.size();
		//for (int i = 0; i <= length; i++) {

			
		while(!openList.isEmpty()){	
			
			
			
			// get the node index with lowest F
			// the new parent node (Center of 9 (Where's 7 these days??))
			int indexLowest_F = getLowest_F();

			GoNoGo nool = openList.get(indexLowest_F);

			// this.parent_F = nool.F;
			this.G_currentParent = nool.G;
			// this.parent_H = nool.H;

			// openList.add(new GoNoGo(nool.rx, nool.ry));

			///////System.out.println("NextParent: " + nool.rx + "," + nool.ry);

			removeItemFrom_OPEN_list(nool.rx, nool.ry);
			
			
			
			
			
			
			
			
			
			System.out.println("Size: "+openList.size());
			
			
			addNodeToClosed(nool.Px, nool.Py, nool.rx, nool.ry, nool.F, nool.G,
					nool.H);
			
			processNeighbours(nool.rx, nool.ry);// with new parent node
			
			/*
			 * If we are adding the target node, then we are done
			 */
			if (nool.rx == PathEnd.x && nool.ry == PathEnd.y) {

				
				// start to fill the path with the path end points
				fillThePath(PathEnd.x, PathEnd.y, Color.yellow);
				break;
			}
			
			
			
		}

		// System.out.println();
		// pg.repaint();
		


	}

	
	
	
	
	
	
	
	
	
	
	private void processNeighbours(int Prx, int Pry) {

		

		int scanRange = 3;

		// Add this node to the closed list
		// addNodeToClosed(Prx, Pry);

		// removeItemFrom_OPEN_list(Prx, Pry);
		// addNodeToClosed(Prx, Pry);

		// start point = top left of 9
		int tl_x = Prx - 1;
		int tl_y = Pry - 1;

		
	
		
		// loops the 8 nodes (n) around the parent		
		for (int i = 0; i < scanRange; i++) {
			for (int j = 0; j < scanRange; j++) {
	
				// what is the basic cost of the move 10 or 14,
				int G_movecost = manhattan_node_move_cost(Prx, Pry,
						tl_x, tl_y);
				
				

					/*
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */

					if ((!isItemIn_OBSTACLES_list(tl_x, tl_y)) 	&& (!isItemIn_CLOSED_list(tl_x, tl_y)) 
							&& isWithinBoundaries(tl_x, tl_y)  )
					
					{ // if its
						// NOT
						// in the
						// closed
						// list...continue

						// G; existing cost of current parent (the center of the
						// 9) 0 if none
						int G_parent = this.G_currentParent; //

						// G; existing G cost of neighbour node being scanned 0
						// if none
						int G_currentNeighbourNode = get_OPEN_list_G(tl_x, tl_y);

						

						// From current parent to node being scanned
						int G = G_parent + G_movecost;
						;// + G_currentNeighbourNode;

						// H distance from this neighbour node to the target
						int H = nodeCalc_H((tl_x), (tl_y)) * 10;

						int F = G + H;

						/*
						 * is this (n) already in the open list? Yes? Compare
						 * the G value of that (n) in the open list with the
						 * current (n) ???????????Which ever is better (lower)
						 * make that the new parent and scan the neighbours
						 */
						//

						// if neighbour is NOT in the open list, add it
						// recording Parent, F, G & H

						if (!isItemIn_OPEN_list(tl_x, tl_y)) {
							
							if(G_movecost==10){	

							addNodeToOpen(Prx, Pry, tl_x, tl_y, F, G, H);
							
							}
							

						} else { // if it IS in the open list,

							G = G_parent + G_movecost;

							if (G < G_currentNeighbourNode) {
								// if new path is better(lower) value
								// reparent that node and recalc fgh

								F = G + H;
								
								
								
								//////////
								//removeItemFrom_OPEN_list(tl_x, tl_y);
								//removeItemFrom_CLOSED_list(tl_x, tl_y);
								
								if(G_movecost==10){
								
								// update the neighbour node
								updateBetterNode(Prx, Pry, tl_x, tl_y, F, G, H);
								
								}
								
								

								String x = "";

							} else {
								// leave alone

								// addNodeToOpen(Prx, Pry, tl_x, tl_y, F,
								// G_movecost, H);

							}

							// System.out.println();

						}// end else

					}// end:is in closed

					// } // obstacles

					/*
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
				

				// move right
				tl_x++;

				// ++++++++++++++++++++++++
			}
			tl_y++;
			tl_x = Prx - 1;// --;//start_x = Px - cellWidth;
		}

		
		// addNodeToClosed(Prx, Pry);
		System.out.println();
		// pg.repaint();
		
		
		
		
	}
	
	

	
	private int nodeCalc_H(int rx, int ry)
	/*
	 * Do the calcs for each node in the scan
	 */
	{
		// int start_point
		// get the mh distance between start end end
		int mh_dist = manhattan(rx, ry);

		// JOptionPane.showMessageDialog(null, mh_dist);
		return mh_dist;

	}

	public int manhattan(int start_x, int start_y) {

		int target_x = PathEnd.x;
		int target_y = PathEnd.y;

		int mhd = Math.abs(target_x - start_x) + Math.abs(target_y - start_y);

		return mhd;

	}

	public int manhattan_node_move_cost(int current_x, int current_y, int to_x,
			int to_y) {

		int mhd = Math.abs(to_x - current_x) + Math.abs(to_y - current_y);

		mhd = (mhd == 2) ? 14 : 10; // if distance is 2 provide 14 (diagonal)
									// otherwise 10 for horiz/vert

		return mhd;

	}

	public boolean isItemIn_OPEN_list(int x, int y) {

		for (GoNoGo isit : openList) {

			if (isit.rx == x && isit.ry == y) {

				return true;// isit.G;
			}

		}

		return false;

	}

	public boolean isItemIn_OBSTACLES_list(int rx, int ry) {

		for (Obstacles isit : pf_obstacles) {

			if (isit.rx == rx && isit.ry == ry) {

				return true;
			}

		}

		return false;

	}

	public boolean isItemIn_CLOSED_list(int rx, int ry) {

		for (GoNoGo isit : closedList) {

			if (isit.rx == rx && isit.ry == ry) {

				return true;
			}

		}

		return false;

	}

	public int get_OPEN_list_F(int x, int y) {

		for (GoNoGo isit : openList) {

			if (isit.rx == x && isit.ry == y) {

				return isit.F;
			}

		}

		return 0;

	}

	public int get_OPEN_list_G(int x, int y) {

		for (GoNoGo isit : openList) {

			if (isit.rx == x && isit.ry == y) {

				return isit.G;
			}

		}

		return 0;

	}

	public int get_PARENT_G(int x, int y) {

		for (GoNoGo isit : closedList) {

			if (isit.rx == x && isit.ry == y) {

				return isit.G;
			}

		}

		return 0;

	}

	public int get_CLOSED_list_F(int x, int y) {

		for (GoNoGo isit : closedList) {

			if (isit.rx == x && isit.ry == y) {

				return isit.F;
			}

		}

		return 0;

	}

	public void addNodeToClosed(int Px, int Py, int rx, int ry, int F, int G,
			int H)
	/*
	 * Add the node to the closed list
	 */
	{
		closedList.add(new GoNoGo(Px, Py, rx, ry, F, G, H));

	}

	public void addNodeToOpen(int Px, int Py, int rx, int ry, int F, int G,
			int H)
	/*
	 * Add node to the OPEN list
	 */
	{

		openList.add(new GoNoGo(Px, Py, rx, ry, F, G, H));

	}

	public void updateBetterNode(int Px, int Py, int rx, int ry, int F, int G,
			int H)
	/*
	 * Add node to the OPEN list
	 */
	{

		int index = 0;
		// get the index of the arraylist for rx & rf

		for (GoNoGo al : openList) {

			if (al.rx == rx && al.ry == ry) {
				break;
			}
			index++;
		}

		openList.set(index, new GoNoGo(Px, Py, rx, ry, F, G, H));

	}

	private int getLowest_F() {

		// find smallest F
		int check = 9999;
		; // an arbitary high value
		int smallestIndexContaining = 0; // smallest index where F is discovered

		int index = 0; // counter
		for (GoNoGo sm : openList) {

			if (sm.F <= check) {

				smallestIndexContaining = index;
				check = sm.F;

			}

			index++;
		}
		return smallestIndexContaining;
	}

	public void removeItemFrom_OPEN_list(int Px, int Py) {
		int i = 0;
		for (GoNoGo isit : openList) {

			if (isit.rx == Px && isit.ry == Py) {

				openList.remove(i);
				break;
				// return true;
			}

			i++;
		}

	}
public void removeItemFrom_CLOSED_list(int Px, int Py) {
		int i = 0;
		for (GoNoGo isit : closedList) {

			if (isit.rx == Px && isit.ry == Py) {

				closedList.remove(i);
				break;
				// return true;
			}

			i++;
		}

	}



private boolean isWithinBoundaries(int bx, int by)
/*
 * are we inside the boundaries of the play area
 * True if we are
 * false otherwise
 */
{
	
	if(((bx >= 0 && by >= 0) && (bx <= (total_columns-1) && by <= (total_rows-1)))){
		
		return true;
	}
	
	
	return false;
}


public void clearGrid(){
	
	
pf_obstacles.clear();
pf_thePath.clear();
	
	
	
}
}

/**
 * ® ALKinghorn duckend.net
 * Please do not modify this class in any way
 * Please do not modify this class in any way
 * Please do not modify this class in any way
 * Please do not modify this class in any way
 */
