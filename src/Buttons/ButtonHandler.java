package Buttons;

import java.util.ArrayList;

public class ButtonHandler {
	public ArrayList<BaseButton> buttons;
	public ButtonHandler(ArrayList<BaseButton> buttons ) {
		this.buttons = buttons;
	}
	public ArrayList<BaseButton> getButtons() {
		return buttons;
	}
	public void setButtons(ArrayList<BaseButton> buttons) {
		this.buttons = buttons;
	}

}
