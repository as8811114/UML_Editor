package UMLObjects;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JLayeredPane;

public abstract class BasicLine {
	protected SingleObject src;
	protected SingleObject dst;
	protected int srcIndex,dstIndex;
	protected JLayeredPane canvasArea;
	protected double length;
	protected int lineDstX, lineDstY;
	protected double vectorX,vectorY; 
	protected double normalVectorX, normalVectorY;
	protected Point srcLocation,dstLocation;
	int depth;
	
	public abstract void drawLine(Graphics g);
	public BasicLine(SingleObject src, SingleObject dst,int depth,JLayeredPane canvasArea) {
		this.depth = depth;
		this.src = src;
		this.dst = dst;
		this.canvasArea = canvasArea;
	}

	public void setSrcIndex(int srcIndex) {
		this.srcIndex = srcIndex;
	}
	public void setDstIndex(int dstIndex) {
		this.dstIndex = dstIndex;
	}

	public void setDraw(Graphics2D g2) {
		srcLocation = src.getConnectPoingLocation(srcIndex);
		dstLocation = dst.getConnectPoingLocation(dstIndex);

		g2.setStroke(new BasicStroke(3));
		length = Math.sqrt(Math.pow((dstLocation.x - srcLocation.x), 2) + Math.pow((dstLocation.y - srcLocation.y), 2));
		vectorX = (dstLocation.x - srcLocation.x) / length;
		vectorY = (dstLocation.y - srcLocation.y) / length; 
		normalVectorX = vectorY;
		normalVectorY = vectorX * -1;
		
		
	}
	
	
	
}
