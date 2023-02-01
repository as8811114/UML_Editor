package Main;

import javax.swing.*;
import Panels.MainPanel;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("UML_Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel main = new MainPanel(frame);

		main.initialWindow();
	}
}
