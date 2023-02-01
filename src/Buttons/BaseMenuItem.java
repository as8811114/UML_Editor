package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import Panels.Canvas;

public abstract class BaseMenuItem extends JMenuItem{
	protected Canvas canvasArea;
	public BaseMenuItem(Canvas canvasArea) {
		// TODO Auto-generated constructor stub
		this.canvasArea = canvasArea;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMouseListener();
			}
		});
	}
	public abstract void setMouseListener();
}
