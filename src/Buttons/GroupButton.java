package Buttons;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Panels.Canvas;
import UMLObjects.CompositeObject;

public class GroupButton extends BaseMenuItem {

	public GroupButton(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
		setText("Group");
	}

	@Override
	public void setMouseListener() {
		// TODO Auto-generated method stub
		if (canvasArea.getReadyToAddGroup() != null && canvasArea.getSelectedBasicClasses().size() + canvasArea.getSelectedCompositeObjects().size() > 1) {
			canvasArea.addReadyGroup();
			canvasArea.revalidate();
			canvasArea.repaint();
		}
	}

}
