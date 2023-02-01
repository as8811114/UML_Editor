package Mouse;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Panels.Canvas;
import UMLObjects.SingleObject;
import UMLObjects.UseCase;

public class UseCaseMode extends ModeAdapter {

	public UseCaseMode(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			// TODO Auto-generated method stub
			System.out.println("UseCaseMode Mouse Pressed");
			createBasicClass(e.getX(), e.getY());
		}
	}

	public void createBasicClass(int pX, int pY) {
		newClass = new UseCase(canvasArea.getHighestLevel() + 1, 150, 210, canvasArea);
		setBasicClassInfo(pX, pY);

	}
}
