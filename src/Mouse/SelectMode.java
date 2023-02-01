package Mouse;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Panels.Canvas;
import UMLObjects.SingleObject;
import UMLObjects.BasicObject;
import UMLObjects.CompositeObject;

public class SelectMode extends ModeAdapter {

	public SelectMode(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			int objectIndex;
			objectIndex = hasObject(e.getX(), e.getY());
			canvasArea.setSelectedObject(null);
			selectedObject = null;
			compositeObject = null;
			pressX = pressY = -1;

			// 沒有Object
			if (objectIndex == -1) {
				unSelectClass(e.getX(), e.getY());
				pressX = e.getX();
				pressY = e.getY();
			} else if (objectIndex != -1) {
				selectedObject = canvasArea.getAllObjects().get(objectIndex);
				unSelectClass(e.getX(), e.getY());
				canvasArea.setSelectedObject(selectedObject);
				selectedObject.setObjectSelected();
				// For Move
				selectedObject.setoX(e.getX());
				selectedObject.setoY(e.getY());
			}

			canvasArea.revalidate();
			canvasArea.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 1) {
			ArrayList<BasicObject> insideBasicObjects = null;
			ArrayList<SingleObject> insideSingleObjects = null;
			ArrayList<CompositeObject> insideCompositeObjects = null;
			canvasArea.setReadyToAddGroup(null);

			if (pressX != -1 && pressY != -1) {
				insideBasicObjects = getInsideAreaObjects(pressX, pressY, e.getX(), e.getY());
				insideSingleObjects = getInsideAreaSingleObjects(pressX, pressY, e.getX(), e.getY());
				insideCompositeObjects = getInsideAreaCompositeObjects(pressX, pressY, e.getX(), e.getY());
			}
			if (selectedObject == null && insideBasicObjects != null && insideBasicObjects.size() > 0) {
				int releaseX = e.getX();
				int relaseeY = e.getY();
				if (pressX > releaseX) {
					int t = pressX;
					pressX = releaseX;
					releaseX = t;
				}
				if (pressY > relaseeY) {
					int t = pressY;
					pressY = relaseeY;
					relaseeY = t;
				}

				int minX, minY, maxX, maxY;
				minX = minY = 9999;
				maxX = maxY = -1;
				for (BasicObject b : insideBasicObjects) {
					if (b.getpX() < minX) {
						minX = b.getpX();
					}
					if (b.getpY() < minY) {
						minY = b.getpY();
					}
				}
				for (BasicObject b : insideBasicObjects) {
					if ((b.getpX() + b.getWidth()) > maxX) {
						maxX = b.getpX() + b.getWidth();
					}
					if ((b.getpY() + b.getHeight()) > maxY) {
						maxY = b.getpY() + b.getHeight();
					}
				}

				CompositeObject t = new CompositeObject(canvasArea.getHighestLevel(), maxY - minY, maxX - minX,
						canvasArea);
				t.setpX(minX);
				t.setpY(minY);
				// 設定準備要加入的Composite
				canvasArea.setReadyToAddGroup(t);
				canvasArea.setSelectedBasicClasses(insideBasicObjects);
				if (insideCompositeObjects != null)
					canvasArea.setSelectedCompositeObjects(insideCompositeObjects);
				if (insideSingleObjects != null)
					canvasArea.setSelectedSingleObjects(insideSingleObjects);

			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		// TODO Auto-generated method stub
		selectedObject = canvasArea.getSelectedObject();

		// 有選擇並且是選到的狀態
		if (selectedObject != null && selectedObject.isInsideClass(e.getX(), e.getY())) {
			selectedObject.move(e.getX(), e.getY());
			canvasArea.revalidate();
			canvasArea.repaint();

		}

	}

	public void unSelectClass(int pX, int pY) {
		System.out.println("unSelectClass");
		for (BasicObject b : canvasArea.getAllObjects()) {
			b.setObjectUnSelected();
		}
	}

}
