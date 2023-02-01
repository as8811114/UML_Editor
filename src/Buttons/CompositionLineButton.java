package Buttons;

import java.awt.Color;

import javax.swing.ImageIcon;

import Mouse.CompositionLineMode;
import Mouse.UmlClassMode;
import Panels.Canvas;

public class CompositionLineButton extends BaseButton {

	public CompositionLineButton(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
		setIcon(new ImageIcon("src/imgs/copmosition_line.png"));
	}

	@Override
	public void setMouseListener() {
		// TODO Auto-generated method stub
		System.out.println("CompositionLineButton");
	
		canvasArea.addMouseListener(new CompositionLineMode(canvasArea));
		canvasArea.addMouseMotionListener(new CompositionLineMode(canvasArea));
		
	}

}
