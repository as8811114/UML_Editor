package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mouse.UmlClassMode;
import Mouse.UseCaseMode;
import Panels.Canvas;

public class UseCaseButton extends BaseButton {

	public UseCaseButton(Canvas canvasArea) {
		super(canvasArea);
		super.setIcon(new ImageIcon("src/imgs/usecase.png"));
		// TODO Auto-generated constructor stub
	}
	public void setMouseListener() {
		System.out.println("UseCaseButton");
		canvasArea.addMouseListener(new UseCaseMode(canvasArea));
		canvasArea.addMouseMotionListener(new UseCaseMode(canvasArea));
	}
}
