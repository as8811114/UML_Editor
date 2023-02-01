package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Panels.Canvas;
import UMLObjects.SingleObject;

public abstract class BaseButton extends JButton {
	protected ButtonHandler BH;
	protected Canvas canvasArea;

	public BaseButton(Canvas canvasArea) {
		super();
		setBackground(new Color(0, 255, 255));
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (canvasArea.getMouseListeners().length > 0)
					canvasArea.removeMouseListener(canvasArea.getMouseListeners()[0]);
				if (canvasArea.getMouseMotionListeners().length > 0)
					canvasArea.removeMouseMotionListener(canvasArea.getMouseMotionListeners()[0]);
				unSelecteButtons();
				setBackground(new Color(0,0,0));
				setMouseListener();
				canvasArea.revalidate();
				canvasArea.repaint();
			}
		});
		this.canvasArea = canvasArea;
	}

	public void setBH(ButtonHandler BH) {
		this.BH = BH;
	}

	public abstract void setMouseListener();

	public void unSelecteButtons() {
		for (BaseButton Button : BH.getButtons()) {
			Button.setBackground(new Color(0, 255, 255));
		}
	}
}
