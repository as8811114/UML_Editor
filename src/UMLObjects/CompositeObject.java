package UMLObjects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Panels.Canvas;

public class CompositeObject extends BasicObject {

	public CompositeObject(int depth, int h, int w, Canvas canvasArea) {
		super(depth, h, w, canvasArea);
		
		// TODO Auto-generated constructor stub
	
	}

	public boolean isInsideClass(int x, int y) {
		boolean isInside = false;
		if (compositiObjects.size() > 0) {
			for (CompositeObject c : compositiObjects) {
				isInside = c.isInsideClass(x, y);
				if(isInside)
					return isInside;
			}
		}
		if (singleObjects.size() > 0) {
			for (SingleObject b : singleObjects) {
				isInside = b.isInsideClass(x, y);
				if(isInside)
					return isInside;
			}
		}
		return isInside;
	}

	public void drawObject(Graphics g) {

		for (SingleObject b : singleObjects) {
			b.drawObject(g);
		}
		for (CompositeObject b : compositiObjects) {

			b.drawObject(g);
		}
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawString(name, pX + width/3 +10, pY);
		g2.setColor(new Color(0, 0, 0, 50));
		g2.setStroke(new BasicStroke(3));
		g2.fillRect(pX, pY, width, height);
	}

	@Override
	public void setObjectSelected() {
		// TODO Auto-generated method stub
		for (SingleObject b : singleObjects) {
			b.setObjectSelected();
		}
		for (CompositeObject b : compositiObjects) {

			b.setObjectSelected();
		}
	}

	public void setObjectUnSelected() {
		for (SingleObject b : singleObjects) {

			b.setObjectUnSelected();
		}
		for (CompositeObject b : compositiObjects) {

			b.setObjectUnSelected();
		}
	}

	public void AddCompositeObject(CompositeObject c) {
		this.compositiObjects.add(c);
	}

	public void AddBasicObject(SingleObject b) {
		this.singleObjects.add(b);
	}

	public ArrayList<CompositeObject> getCompositiObjects() {
		return compositiObjects;
	}

	public CompositeObject getCompositiObject(int n) {
		return compositiObjects.get(n);
	}

	public ArrayList<SingleObject> getBasicObjects() {
		return singleObjects;
	}

	public SingleObject getBasicObject(int n) {
		return singleObjects.get(n);
	}

	public void move(int x, int y) {
		for (SingleObject b : singleObjects) {
			b.move(x, y);
		}
		for (CompositeObject b : compositiObjects) {
			b.move(x, y);

		}
		resetLocation();
	}

	public void setoX(int oX) {
		for (SingleObject b : singleObjects) {
			b.setoX(oX);
		}
		for (CompositeObject b : compositiObjects) {

			b.setoX(oX);

		}
	}

	public void setoY(int oY) {
		for (SingleObject b : singleObjects) {
			b.setoY(oY);
		}
		for (CompositeObject b : compositiObjects) {

			b.setoY(oY);
		}
	}

	public void resetLocation() {
		int minX, minY, maxX, maxY;
		minX = minY = 9999;
		maxX = maxY = -1;
		for (SingleObject b : singleObjects) {
			if (b.getpX() < minX) {
				minX = b.getpX();
			}
			if (b.getpY() < minY) {
				minY = b.getpY();
			}
		}
		for (SingleObject b : singleObjects) {
			if ((b.getpX() + b.getWidth()) > maxX) {
				maxX = b.getpX() + b.getWidth();
			}
			if ((b.getpY() + b.getHeight()) > maxY) {
				maxY = b.getpY() + b.getHeight();
			}
		}

		for (CompositeObject b : compositiObjects) {
			if (b.getpX() < minX) {
				minX = b.getpX();
			}
			if (b.getpY() < minY) {
				minY = b.getpY();
			}
		}
		for (CompositeObject b : compositiObjects) {
			if ((b.getpX() + b.getWidth()) > maxX) {
				maxX = b.getpX() + b.getWidth();
			}
			if ((b.getpY() + b.getHeight()) > maxY) {
				maxY = b.getpY() + b.getHeight();
			}
		}

		setpX(minX);
		setpY(minY);
	}
	public void resetDepth(int n) {
		for (SingleObject b : singleObjects) {
			b.setDepth(n);
		}
		for (CompositeObject b : compositiObjects) {
			b.resetDepth(n);
			b.setDepth(n);
		}
		
	}


}
