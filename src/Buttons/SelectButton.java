package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;

import Mouse.SelectMode;
import Panels.Canvas;

public class SelectButton extends BaseButton {

	public SelectButton( Canvas canvasArea) {
		super(canvasArea);
		setIcon(new ImageIcon("src/imgs/select.png"));
	}


	public void setMouseListener() {
		System.out.println("SelectButton");
		
		canvasArea.addMouseListener(new SelectMode(canvasArea));
		canvasArea.addMouseMotionListener(new SelectMode(canvasArea));
	}
	
}
