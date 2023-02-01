package Panels;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import UMLObjects.BasicLine;
import UMLObjects.BasicObject;
import UMLObjects.SingleObject;
import UMLObjects.CompositeObject;

public class Canvas extends JLayeredPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4736365925770026136L;
	protected int highestLevel;
	// �Ҧ�����@����
	protected ArrayList<SingleObject> basicClasses;
	// �Ҧ����զX����
	protected ArrayList<CompositeObject> compositeObjects;
	// �Ҧ����u�q
	protected ArrayList<BasicLine> basicLines;
	// �Ҧ����򥻪���
	protected ArrayList<BasicObject> allObjects;

	// ��쪺����
	protected BasicObject selectedObject;
	// �ǳƴꦨ�@�ӲզX��Object
	protected CompositeObject readyToAddGroup;

	// �Ҧ��b�d�򤺳Q��쪺Object
	protected ArrayList<BasicObject> selectedBasicClasses;

	// �Ҧ��b�d�򤺳Q��쪺Single Object
	protected ArrayList<SingleObject> selectedSingleObjects;
	// �Ҧ��b�d�򤺳Q��쪺Composite Object
	protected ArrayList<CompositeObject> selectedCompositeObjects;

	public void addReadyGroup() {
		if (selectedBasicClasses != null) {
			
			this.allObjects.add(readyToAddGroup);
			compositeObjects.add(readyToAddGroup); // ��o�ǳQ��쪺Object�]�w��Group;
			for (BasicObject b : selectedBasicClasses) {
				b.setBelongGroup(readyToAddGroup);
			}

			readyToAddGroup.setCompositiObjects(selectedCompositeObjects);
			readyToAddGroup.setBasicObjects(selectedSingleObjects);
			readyToAddGroup.resetDepth(readyToAddGroup.getDepth());
			readyToAddGroup.setObjectUnSelected();
			
			
			allObjects.removeAll(selectedBasicClasses);
			compositeObjects.removeAll(selectedCompositeObjects);
			basicClasses.removeAll(selectedSingleObjects);
			
			selectedCompositeObjects = null;
			selectedBasicClasses = null;
			selectedCompositeObjects = null;
		}
		for (BasicObject b2 : allObjects) {
			System.out.println(b2.getClass());
		}
		System.out.println("after:" + allObjects.size());
	}

	public void destructGroup() {
		if (selectedObject != null && (selectedObject.getBasicObjects().size() > 1 || selectedObject.getCompositiObjects().size() >= 1)) {
			System.out.println( selectedObject.getBasicObjects().size() + "<>" + selectedObject.getCompositiObjects().size());
			for (SingleObject b : selectedObject.getBasicObjects()) {
				allObjects.add(b);
				basicClasses.add(b);
				b.setBelongGroup(null);
			}
			for (CompositeObject b : selectedObject.getCompositiObjects()) {
				allObjects.add(b);
				compositeObjects.add(b);
				b.setBelongGroup(null);
			}
			selectedObject.setObjectUnSelected();
			allObjects.remove(selectedObject);
			compositeObjects.remove(selectedObject);
			selectedObject = null;
			
			repaint();
			revalidate();
		}
	}

	public Canvas(Rectangle R) {
		super();
		this.setBounds(R);
		this.setLayout(null);
		this.highestLevel = 0;
		this.basicClasses = new ArrayList<>();
		this.basicLines = new ArrayList<>();
		this.allObjects = new ArrayList<>();
		this.compositeObjects = new ArrayList<>();
		this.selectedBasicClasses = new ArrayList<>();
		this.selectedSingleObjects = new ArrayList<>();
		this.selectedCompositeObjects = new ArrayList<>();
	}

	public ArrayList<SingleObject> getBasicClasses() {
		return basicClasses;
	}

	public void setBasicClasses(ArrayList<SingleObject> basicClasses) {
		this.basicClasses = basicClasses;
	}

	// allObjects Assessor
	public ArrayList<BasicObject> getAllObjects() {
		return allObjects;
	}

	public void setAllObjects(ArrayList<BasicObject> compositeObjects) {
		this.allObjects = compositeObjects;
	}
	// -------------------//

	public CompositeObject getReadyToAddGroup() {
		return readyToAddGroup;
	}

	public void setReadyToAddGroup(CompositeObject readyToAddGroup) {
		this.readyToAddGroup = readyToAddGroup;
	}

	// selectedObject Assessor
	public BasicObject getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(BasicObject selectedObject) {
		this.selectedObject = selectedObject;
	}
	// ----------------------//

	// allLines Assessor
	public ArrayList<BasicLine> getBasicLines() {
		return basicLines;
	}

	public void setBasicLines(ArrayList<BasicLine> basicLines) {
		this.basicLines = basicLines;
	}
	// ------------------//

	// highestLevel Assessor
	public int getHighestLevel() {
		return highestLevel;
	}

	public void setHighestLevel(int highestLevel) {
		this.highestLevel = highestLevel;
	}
	// -----------------//

	// selectedBasicClasses Assessor
	public ArrayList<BasicObject> getSelectedBasicClasses() {
		return selectedBasicClasses;
	}

	public void setSelectedBasicClasses(ArrayList<BasicObject> selectedBasicClasses) {
		this.selectedBasicClasses = selectedBasicClasses;
	}
	// -----------------------------//

	// selectedCompositeObjects Assessor
	public ArrayList<CompositeObject> getSelectedCompositeObjects() {
		return selectedCompositeObjects;
	}

	public void setSelectedCompositeObjects(ArrayList<CompositeObject> selectedCompositeObjects) {
		this.selectedCompositeObjects = selectedCompositeObjects;
	}

	// ------------------------------//

	public ArrayList<CompositeObject> getCompositeObjects() {
		return compositeObjects;
	}

	public void setCompositeObjects(ArrayList<CompositeObject> compositeObjects) {
		this.compositeObjects = compositeObjects;
	}

	public ArrayList<SingleObject> getSelectedSingleObjects() {
		return selectedSingleObjects;
	}

	public void setSelectedSingleObjects(ArrayList<SingleObject> selectedSingleObjects) {
		this.selectedSingleObjects = selectedSingleObjects;
	}

	// paint method
	public void paint(Graphics g) {
		super.paint(g);
		for (BasicLine b : basicLines) {
			b.drawLine(g);
		}
		
		for (BasicObject b : allObjects) {
			
			b.drawObject(g);
		}

	}
}
