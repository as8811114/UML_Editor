package Buttons;

import Panels.Canvas;

public class UnGroupButton extends BaseMenuItem {

	public UnGroupButton(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
		setText("UnGroup");
	}

	@Override
	public void setMouseListener() {
		// TODO Auto-generated method stub
		canvasArea.destructGroup();
	
	}

}
