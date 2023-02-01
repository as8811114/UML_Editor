package UMLObjects;

import java.awt.Graphics;
import java.util.ArrayList;
import Panels.Canvas;

public abstract class BasicObject {
	Canvas canvasArea;
	protected String name ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	protected int pX, pY;
	protected int oX, oY;
	protected int height, width;
	protected int depth;
	protected boolean isSelected;
	
	protected BasicObject belongGroup = null;
	ArrayList<CompositeObject> compositiObjects;
	ArrayList<SingleObject> singleObjects;

	public abstract void setoX(int oX);
	public abstract void setoY(int oY);
	
	public abstract void drawObject(Graphics g);
	public abstract boolean isInsideClass(int x, int y);
	public abstract void move(int x, int y);
	
	
	public BasicObject(int depth, int h, int w,Canvas canvasArea) {
		this.depth = depth;
		this.height = h;
		this.width = w;
		this.name  = "ObjectName";
		this.canvasArea = canvasArea;
		this.compositiObjects = new ArrayList<>();
		this.singleObjects = new ArrayList<>();
		
	}
	
	public boolean getSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}
	public int getoX() {
		return oX;
	}
	public int getoY() {
		return oY;
	}


	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}
	public void setDepth(int n) {
		this.depth = n;
	}
	//BasicObject Composite and Single Assessor
	public void setCompositiObjects(ArrayList<CompositeObject> compositiObjects) {
		this.compositiObjects = compositiObjects;
	}

	public ArrayList<SingleObject> getBasicObjects() {
		return this.singleObjects;
	}
	
	public ArrayList<CompositeObject> getCompositiObjects( ) {
		return this.compositiObjects;
	}

	public void setBasicObjects(ArrayList<SingleObject> basicObjects) {
		this.singleObjects = basicObjects;
	}
	//-------
	//BelongGroup Assessor
	public BasicObject getBelongGroup() {
		return belongGroup;
	}
	public void setBelongGroup(BasicObject belongGroup) {
		this.belongGroup = belongGroup;
	}
	public abstract void setObjectSelected();
	public abstract void setObjectUnSelected();
}
