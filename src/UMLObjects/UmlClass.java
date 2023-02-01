package UMLObjects;
import Panels.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Color;

public class UmlClass extends SingleObject {

	public UmlClass(int depth, int h, int w,  Canvas canvasArea) {
		super(depth, h, w, canvasArea);
	}

	@Override
	public void drawObject(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(new Color(0, 0, 0));
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(pX, pY, width, height);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(pX, pY + 70, width + pX, pY + 70);
		g2.drawLine(pX, pY + 140, width + pX, pY + 140);
		
		g2.drawString(name, pX + width/4, pY + height/5);
		// 畫四個點
		if (isSelected) {
			g2.setStroke(new BasicStroke(10));
			g2.drawLine(pX + width / 2, pY, pX + width / 2, pY);
			g2.drawLine(pX + width / 2, pY + height, pX + width / 2, pY + height);
			g2.drawLine(pX , pY + height  / 2, pX ,pY + height  / 2);
			g2.drawLine(pX + width , pY + height  / 2, pX + width ,pY + height / 2);
		}
		Point[] p = new Point[4];
		p[0] = new Point(pX + width / 2, pY);
		p[1] = new Point(pX + width / 2, pY + height);
		p[2] = new Point(pX , pY + height  / 2);
		p[3] = new Point(pX + width, pY + height / 2);
		setPointsLocation(p);
	}
	
	@Override
	public boolean isInsideClass(int x, int y) {
		if (pX <= x && pY <= y && x <= (pX + width) && y <= (pY + height)) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public void setObjectSelected() {
		// TODO Auto-generated method stub
		this.isSelected = true;
	}
	public void setObjectUnSelected() {
		this.isSelected = false;
	}
}
