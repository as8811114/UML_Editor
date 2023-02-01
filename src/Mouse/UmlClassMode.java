package Mouse;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Panels.Canvas;
import UMLObjects.SingleObject;
import UMLObjects.UmlClass;

public class UmlClassMode extends ModeAdapter {

	public UmlClassMode(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			// TODO Auto-generated method stub
			createBasicClass(e.getX(), e.getY());
			System.out.println("UmlClassMode Mouse Pressed");
		}
	}

	public void createBasicClass(int pX, int pY) {
		newClass = new UmlClass(canvasArea.getHighestLevel() + 1, 210, 150, canvasArea);
		setBasicClassInfo(pX, pY);
	}
}
