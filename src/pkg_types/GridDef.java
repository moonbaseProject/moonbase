package pkg_types;

import java.awt.Color;

import javax.swing.CellEditor;

public class GridDef {
	
	
	public int x;
	public int y;
	public int rx;
	public int ry;
	public Color cColour;
	public String cellType;
	
	
	public GridDef(int x, int y, int rx, int ry, Color colour, String cellType) {
		
		super();
		this.x = x;
		this.y = y;
		this.rx = rx;
		this.ry = ry;
		this.cColour = colour;
		this.cellType = cellType;
		
		
	}
	
public GridDef(int x, int y,  Color colour, String cellType) {
		
		super();
		this.x = x;
		this.y = y;
		
		this.cColour = colour;
		this.cellType = cellType;
		
		
		
	}



	

}
