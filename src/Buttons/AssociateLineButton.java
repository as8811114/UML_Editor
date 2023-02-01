package Buttons;

import java.awt.Color;

import javax.swing.ImageIcon;

import Mouse.AssociateLineMode;
import Mouse.UmlClassMode;
import Panels.Canvas;

public class AssociateLineButton extends BaseButton {

	public AssociateLineButton(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
		setIcon(new ImageIcon("src/imgs/association_line.png"));
	}

	@Override
	public void setMouseListener() {
		// TODO Auto-generated method stub
		
		System.out.println("AssociateButton");
		canvasArea.addMouseListener(new AssociateLineMode(canvasArea));
		canvasArea.addMouseMotionListener(new AssociateLineMode(canvasArea));
	}

}
