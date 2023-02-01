package UMLObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLayeredPane;

public class CompositionLine extends BasicLine {

	public CompositionLine(SingleObject src, SingleObject dst, int depth, JLayeredPane canvasArea) {
		super(src, dst, depth, canvasArea);
	}

	public void drawLine(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		setDraw(g2);
		int headX = dstLocation.x, headY = dstLocation.y;

		int polyX = (int) (dstLocation.x - (20 * vectorX));
		int polyY = (int) (dstLocation.y - (20 * vectorY));
		lineDstX = (int) (dstLocation.x - (40 * vectorX));
		lineDstY = (int) (dstLocation.y - (40 * vectorY));
		int p1X = (int) (polyX - (10 * normalVectorX));
		int p1Y = (int) (polyY - (10 * normalVectorY));
		int p2X = (int) (polyX + (10 * normalVectorX));
		int p2Y = (int) (polyY + (10 * normalVectorY));

		// 畫線
		g2.drawLine(srcLocation.x, srcLocation.y, lineDstX, lineDstY);
		// 畫三角形
		g2.drawPolygon(new int[] { headX, p1X, lineDstX, p2X }, new int[] { headY, p1Y, lineDstY, p2Y }, 4);
	}
}
