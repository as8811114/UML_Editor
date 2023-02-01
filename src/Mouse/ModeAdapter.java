package Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Panels.Canvas;
import UMLObjects.BasicLine;
import UMLObjects.BasicObject;
import UMLObjects.SingleObject;
import UMLObjects.CompositeObject;

public class ModeAdapter implements MouseMotionListener, MouseListener {
	// Don't change
	SingleObject newClass;
	SingleObject srcObject, dstObject;
	BasicLine newLine;
	Canvas canvasArea;

	int pressX, pressY;

	CompositeObject compositeObject = null;
	BasicObject selectedObject = null;
	int srcIndex, dstIndex;

	public ModeAdapter(Canvas canvasArea) {
		this.canvasArea = canvasArea;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setBasicClassInfo(int pX, int pY) {
		newClass.setpX(pX);
		newClass.setpY(pY);
		ArrayList<BasicObject> newBO = canvasArea.getAllObjects();
		newBO.add(newClass);
		canvasArea.setAllObjects(newBO);

		ArrayList<SingleObject> newSO = canvasArea.getBasicClasses();
		newSO.add(newClass);
		canvasArea.setBasicClasses(newSO);

		canvasArea.setHighestLevel(canvasArea.getHighestLevel() + 1);
		canvasArea.revalidate();
		canvasArea.repaint();
	}

	public int hasObject(int pX, int pY) {
		int i = 0;
		int index = 0;
		int max = -1;
		for (BasicObject b : canvasArea.getAllObjects()) {
			System.out.println(b.isInsideClass(pX, pY));
			if (b.isInsideClass(pX, pY)) {
				if (b.getDepth() >= max) {
					index = i;
					max = b.getDepth();
				}
			}
			i++;
		}
		if (max == -1)
			return -1;
		else
			return index;
	}

	public int getSingleObjectIndex(BasicObject b) {
		int i = 0;
		for (SingleObject s : canvasArea.getBasicClasses()) {
			if (s == b)
				return i;
			i++;
		}
		return -1;
	}

	public ArrayList<BasicObject> getInsideAreaObjects(int pX, int pY, int pX2, int pY2) {
		if (pX > pX2) {
			int t = pX;
			pX = pX2;
			pX2 = t;
		}
		if (pY > pY2) {
			int t = pY;
			pY = pY2;
			pY2 = t;
		}
		ArrayList<BasicObject> temp = new ArrayList<>();
		for (BasicObject b : canvasArea.getAllObjects()) {
			if (pX <= b.getpX() && pY <= b.getpY() && pX2 >= b.getpX() + b.getWidth()
					&& pY2 >= b.getpY() + b.getHeight()) {
				b.setObjectSelected();
				temp.add(b);
			}
		}

		canvasArea.revalidate();
		canvasArea.repaint();
		return temp;
	}
	
	
	public ArrayList<SingleObject> getInsideAreaSingleObjects(int pX, int pY, int pX2, int pY2) {
		if (pX > pX2) {
			int t = pX;
			pX = pX2;
			pX2 = t;
		}
		if (pY > pY2) {
			int t = pY;
			pY = pY2;
			pY2 = t;
		}
		ArrayList<SingleObject> temp = new ArrayList<>();

		for (SingleObject b : canvasArea.getBasicClasses()) {
			if (b.getBelongGroup() == null && pX <= b.getpX() && pY <= b.getpY() && pX2 >= b.getpX() + b.getWidth()
					&& pY2 >= b.getpY() + b.getHeight() ) {
				temp.add(b);
			}
		}

		canvasArea.revalidate();
		canvasArea.repaint();
		return temp;
	}
	public ArrayList<CompositeObject> getInsideAreaCompositeObjects(int pX, int pY, int pX2, int pY2) {
		if (pX > pX2) {
			int t = pX;
			pX = pX2;
			pX2 = t;
		}
		if (pY > pY2) {
			int t = pY;
			pY = pY2;
			pY2 = t;
		}
		ArrayList<CompositeObject> temp = new ArrayList<>();

		for (CompositeObject b : canvasArea.getCompositeObjects()) {
			if ( pX <= b.getpX() && pY <= b.getpY() && pX2 >= b.getpX() + b.getWidth()
					&& pY2 >= b.getpY() + b.getHeight() ) {
				temp.add(b);
			}
		}

		canvasArea.revalidate();
		canvasArea.repaint();
		
		return temp;
	}
	
	
	public void setBasicLineInfo() {
		newLine.setSrcIndex(srcIndex);
		newLine.setDstIndex(dstIndex);
		ArrayList<BasicLine> BL = canvasArea.getBasicLines();
		BL.add(newLine);
		canvasArea.setBasicLines(BL);
		canvasArea.revalidate();
		canvasArea.repaint();
	}

}
