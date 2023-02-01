package Buttons;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Panels.Canvas;

public class EditButton extends BaseMenuItem {

	public EditButton(Canvas canvasArea) {
		super(canvasArea);
		// TODO Auto-generated constructor stub
		setText("Edit");
	}

	@Override
	public void setMouseListener() {
		if (canvasArea.getSelectedObject() != null) {
			String newName = JOptionPane.showInputDialog(null, "Input New Object Name", "Edit Name",
					JOptionPane.INFORMATION_MESSAGE);
			if (newName != null) {
				canvasArea.getSelectedObject().setName(newName);
				canvasArea.revalidate();
				canvasArea.repaint();

			} else {
				System.out.println("Cancel");
			}
		}
	}

}
