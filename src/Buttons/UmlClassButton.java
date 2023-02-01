package Buttons;

import java.awt.Color;
import javax.swing.ImageIcon;

import Mouse.UmlClassMode;
import Panels.Canvas;

public class UmlClassButton extends BaseButton {

	public UmlClassButton(Canvas canvasArea) {
		super(canvasArea);
		super.setIcon(new ImageIcon("src/imgs/class.png"));
	
		// TODO Auto-generated constructor stub
	}
	public void setMouseListener() {
		System.out.println("UmlClassButton");
		
		canvasArea.addMouseListener(new UmlClassMode(canvasArea));
		canvasArea.addMouseMotionListener(new UmlClassMode(canvasArea));
	}
}
