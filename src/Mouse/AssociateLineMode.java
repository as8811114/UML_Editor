package Mouse;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Panels.Canvas;
import UMLObjects.AssociateLine;
import UMLObjects.BasicLine;
import UMLObjects.BasicObject;
import UMLObjects.SingleObject;

public class AssociateLineMode extends ModeAdapter {
	public AssociateLineMode(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			// TODO Auto-generated method stub
			System.out.println("AssociateLineMode Mouse Pressed" + e.getX() + " " + e.getY());
			int objectIndex = hasObject(e.getX(), e.getY());
			BasicObject tmp = null;
			if (objectIndex != -1) {
				tmp = canvasArea.getAllObjects().get(objectIndex);
				System.out.println(tmp.getBasicObjects().size() + "<<<");
				if (tmp.getBelongGroup() == null && tmp.getBasicObjects().size() <= 1) {
					srcObject = canvasArea.getBasicClasses()
							.get(getSingleObjectIndex(canvasArea.getAllObjects().get(objectIndex)));
					srcIndex = srcObject.getNearestConnectPoint(e.getX(), e.getY());
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 1) {
			// TODO Auto-generated method stub
			int objectIndex = hasObject(e.getX(), e.getY());
			BasicObject tmp = null;
			if (objectIndex != -1) {
				tmp = canvasArea.getAllObjects().get(objectIndex);
				if (srcObject != null && tmp.getBelongGroup() == null && tmp.getBasicObjects().size() <= 1) {

					dstObject = canvasArea.getBasicClasses()
							.get(getSingleObjectIndex(canvasArea.getAllObjects().get(objectIndex)));
					if (dstObject != srcObject) {
						dstIndex = dstObject.getNearestConnectPoint(e.getX(), e.getY());
						newLine = new AssociateLine(srcObject, dstObject, canvasArea.getHighestLevel() + 1, canvasArea);
						setBasicLineInfo();
					}
				}
			}
		}
	}


}
