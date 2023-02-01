package UMLObjects;

import javax.swing.*;

import Panels.Canvas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class UseCase extends SingleObject {

	public UseCase(int depth, int h, int w, Canvas canvasArea) {
		super(depth, h, w, canvasArea);
	}

	@Override
	public void drawObject(Graphics graphics) {
		// TODO Auto-generated method stub
		System.out.println("Draw UseCase");
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(new Color(0, 0, 0));
		g2.setStroke(new BasicStroke(3));
		g2.drawOval(pX, pY, width, height);
		g2.drawString(name, pX + width/3, pY + height/2);
		// 畫四個點
		if (isSelected) {
			System.out.println("Draw Connect Points");
			g2.setStroke(new BasicStroke(8));
			// 上下左右
			g2.drawLine(pX + width / 2, pY, pX + width / 2, pY);
			g2.drawLine(pX + width / 2, pY + height, pX + width / 2, pY + height);
			g2.drawLine(pX, pY + height / 2, pX, pY + height / 2);
			g2.drawLine(pX + width, pY + height / 2, pX + width, pY + height / 2);

//			className.setBounds(originX * 15, originY * 8, width / 2, height / 2);
		}

		Point[] p = new Point[4];
		p[0] = new Point(pX + width / 2, pY);
		p[1] = new Point(pX + width / 2, pY + height);
		p[2] = new Point(pX, pY + height / 2);
		p[3] = new Point(pX + width, pY + height / 2);
		setPointsLocation(p);
	}

	@Override
	public boolean isInsideClass(int x, int y) {
		// x^2/a^2+y^2/b^2=1
		// x*x/a/a+y*y/b/b
		int a = width / 2;
		int b = height / 2;
		double n = (Math.pow(x - (pX + width / 2), 2) / Math.pow(a, 2))
				+ (Math.pow(y - (pY + height / 2), 2) / Math.pow(b, 2));
		if (n <= 1) {
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
