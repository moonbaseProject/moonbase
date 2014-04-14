package pkg_types;

public class GoNoGo {
	
	
		
	public int rx;	
	public int ry;
	
	public int F; // Calculated : Summ of G and H
	
	public int G;  // Move cost
	public int H; // the mhd calc
	public int Px ; //parent
	public int Py ; //parent
	
	
	

	public GoNoGo(int Px, int Py, int rx, int ry, int F, int G, int H ) {
		
		this.Px = Px;
		this.Py = Py;
		this.rx = rx;
		this.ry = ry;
		this.F = F;
		this.G = G;
		this.H = H;
		
	}
	
	public GoNoGo(int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.rx = x2;
		this.ry = y2;
		
		
	}


	
	
}