package UMLObjects;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLayeredPane;

public class GeneralizationLine extends BasicLine{

	public GeneralizationLine(SingleObject src, SingleObject dst,int depth,JLayeredPane canvasArea) {
		super(src,dst,depth,canvasArea);
	}
	public void drawLine(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		setDraw(g2);
		
		
		int headX = dstLocation.x , headY = dstLocation.y;
		lineDstX = (int)(dstLocation.x - (20 * vectorX));
		lineDstY = (int)(dstLocation.y - (20 * vectorY));
		
		int p1X = (int)(lineDstX - (10 * normalVectorX));
		int p1Y = (int)(lineDstY - (10 * normalVectorY));
		int p2X = (int)(lineDstX + (10 * normalVectorX));
		int p2Y = (int)(lineDstY + (10 * normalVectorY));
		
		//畫線
		g2.drawLine(srcLocation.x, srcLocation.y, lineDstX,lineDstY);
		//畫三角形
		g2.drawPolygon(new int[] {headX,p1X,p2X}, new int[] {headY,p1Y,p2Y}, 3);
		
	}
}
