package UMLObjects;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JLayeredPane;

public class AssociateLine extends BasicLine {
	public AssociateLine(SingleObject src, SingleObject dst, int depth, JLayeredPane canvasArea) {
		super(src, dst, depth, canvasArea);
	}

	public void drawLine(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		setDraw(g2);
		lineDstX = (int)(dstLocation.x - (20 * vectorX));
		lineDstY = (int)(dstLocation.y - (20 * vectorY));
		int p1X = (int)(lineDstX - (15 * normalVectorX));
		int p1Y = (int)(lineDstY - (15 * normalVectorY));
		int p2X = (int)(lineDstX + (15 * normalVectorX));
		int p2Y = (int)(lineDstY + (15 * normalVectorY));
		
		g2.drawLine(srcLocation.x, srcLocation.y, dstLocation.x, dstLocation.y);
		g2.drawLine(dstLocation.x, dstLocation.y, p1X, p1Y);
		g2.drawLine(dstLocation.x, dstLocation.y, p2X, p2Y);
	
	}

}
