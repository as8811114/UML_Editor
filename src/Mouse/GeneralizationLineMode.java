package Mouse;

import java.awt.event.MouseEvent;

import Panels.Canvas;
import UMLObjects.AssociateLine;
import UMLObjects.BasicObject;
import UMLObjects.GeneralizationLine;

public class GeneralizationLineMode extends ModeAdapter {
	public GeneralizationLineMode(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			// TODO Auto-generated method stub
			System.out.println("GeneralizationLineMode Mouse Pressed");
			int objectIndex = hasObject(e.getX(), e.getY());
			BasicObject tmp = null;
			if (objectIndex != -1) {
				tmp = canvasArea.getAllObjects().get(objectIndex);
				if (tmp.getBelongGroup() == null && tmp.getBasicObjects().size() <= 1) {
					srcObject = canvasArea.getBasicClasses()
							.get(getSingleObjectIndex(canvasArea.getAllObjects().get(objectIndex)));
					srcIndex = srcObject.getNearestConnectPoint(e.getX(), e.getY());
				}
			}
		}
	}

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
						newLine = new GeneralizationLine(srcObject, dstObject, canvasArea.getHighestLevel() + 1,
								canvasArea);
						setBasicLineInfo();
					}
				}
			}
		}
	}
}
