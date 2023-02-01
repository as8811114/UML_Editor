package Buttons;

import java.awt.Color;

import javax.swing.ImageIcon;

import Mouse.GeneralizationLineMode;
import Mouse.UmlClassMode;
import Panels.Canvas;

public class GeneralizationLineButton extends BaseButton {

	public GeneralizationLineButton(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
		setIcon(new ImageIcon("src/imgs/generalization_line.png"));
	}

	@Override
	public void setMouseListener() {
		// TODO Auto-generated method stub
		System.out.println("GneralizationLineButton");
		
		canvasArea.addMouseListener(new GeneralizationLineMode(canvasArea));
		canvasArea.addMouseMotionListener(new GeneralizationLineMode(canvasArea));
	}

}
