package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import Buttons.AssociateLineButton;
import Buttons.BaseButton;
import Buttons.BaseMenu;
import Buttons.BaseMenuItem;
import Buttons.ButtonHandler;
import Buttons.CompositionLineButton;
import Buttons.EditButton;
import Buttons.EditMenu;
import Buttons.FileMenu;
import Buttons.GeneralizationLineButton;
import Buttons.GroupButton;
import Buttons.SelectButton;
import Buttons.UmlClassButton;
import Buttons.UnGroupButton;
import Buttons.UseCaseButton;

public class MainPanel {
	protected JFrame mainFrame;
	protected JMenuBar menubar;
	protected Canvas canvasArea;
	protected ArrayList<BaseButton> mainButtons;
	protected ArrayList<BaseMenuItem> mainEditButtons;
	protected ArrayList<BaseMenu> mainMenus;
	protected JPanel buttonPanel;

	protected final int mainPanelWidth = 1600;
	protected final int mainPanelHeight = 900;
	protected final int buttonPanelWidth = 100;
	protected final int buttonPanelHeight = mainPanelHeight;
	protected final int canvasAreaWidth = mainPanelWidth - buttonPanelWidth;
	protected final int canvasAreaHeight = mainPanelHeight;

	public MainPanel(JFrame frame) {
		this.mainFrame = frame;
		this.buttonPanel = new JPanel();
		this.menubar = new JMenuBar();

	}

	public void initialWindow() {

		canvasArea = new Canvas(new Rectangle(0, 0, canvasAreaWidth, canvasAreaHeight));
		initialCanvasArea();
		initialButton();
		mainFrame.add(canvasArea);

		// -------------------------------------------------------------

		mainFrame.setSize(mainPanelWidth, mainPanelHeight);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
	}

	private void initialButton() {
		ButtonHandler BH = new ButtonHandler(new ArrayList<BaseButton>());
		this.mainButtons = new ArrayList<>(
				Arrays.asList(new SelectButton(canvasArea), new AssociateLineButton(canvasArea),
						new CompositionLineButton(canvasArea), new GeneralizationLineButton(canvasArea),
						new UmlClassButton(canvasArea), new UseCaseButton(canvasArea)));

		this.mainEditButtons = new ArrayList<>(
				Arrays.asList(new GroupButton(canvasArea), new UnGroupButton(canvasArea), new EditButton(canvasArea)));

		this.mainMenus = new ArrayList<>(Arrays.asList(new FileMenu(), new EditMenu()));

		BH.setButtons(mainButtons);
		buttonPanel.setSize(buttonPanelWidth, buttonPanelHeight);
		buttonPanel.setBackground(new Color(125, 125, 125));
		buttonPanel.setLayout(null);

		int i = 0;
		for (BaseButton button : this.mainButtons) {
			buttonPanel.add(button);
			button.setBH(BH);
			button.setLocation(0, 100 * i);
			button.setSize(100, 100);
			i++;
		}
		for (BaseMenu menu : this.mainMenus) {
			menubar.add(menu);
		}
		JMenuItem edit = this.mainMenus.get(1);

		for (BaseMenuItem button : this.mainEditButtons) {
			edit.add(button);
		}
		mainFrame.setJMenuBar(menubar);
		mainFrame.getContentPane().add(BorderLayout.WEST, buttonPanel);
	}

	private void initialCanvasArea() {

		canvasArea.setLayout(null);
		canvasArea.setOpaque(true);
		canvasArea.setBackground(new Color(204, 204, 204));
		canvasArea.setLocation(buttonPanelWidth, 0);
		canvasArea.setSize(canvasAreaWidth, canvasAreaHeight);
	}

}
