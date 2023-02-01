package UMLObjects;
import Panels.Canvas;
import java.awt.Graphics;
import java.awt.Point;


public abstract class SingleObject extends BasicObject {

	protected Point[] connectPointsLocation;

	public abstract boolean isInsideClass(int x, int y);

	public abstract void drawObject(Graphics g);

	public SingleObject(int depth, int h, int w, Canvas canvasArea) {
		super(depth, h, w, canvasArea);
		// �|���I
		connectPointsLocation = new Point[4];
	}
	public void setPointsLocation(Point[] p) {
		connectPointsLocation[0] = p[0];
		connectPointsLocation[1] = p[1];
		connectPointsLocation[2] = p[2];
		connectPointsLocation[3] = p[3];
	}

	public Point getConnectPoingLocation(int n) {
		return connectPointsLocation[n];
	}

	public int getNearestConnectPoint(int x, int y) {
		int lowerLeftX, lowerRightX;
		int upperLeftX = lowerLeftX = pX;
		int upperRightX = lowerRightX = pX + width;

		int lowerRightY, upperRightY;
		int upperLeftY = upperRightY = pY;
		int lowerLeftY = lowerRightY = pY + height;
		// �t�ײv
		// (y1 �V y2) * x + (x2 �V x1) * y + x1 * y2 �V x2 * y1
		int firstLineSide = (upperLeftY - lowerRightY) * x + (lowerRightX - upperLeftX) * y + upperLeftX * lowerRightY
				- lowerRightX * upperLeftY;
		// ���ײv
		int secondLineSide = (upperRightY - lowerLeftY) * x + (lowerLeftX - upperRightX) * y + upperRightX * lowerLeftY
				- lowerLeftX * upperRightY;
		if (isInsideClass(x, y)) {

			if (firstLineSide < 0 && secondLineSide > 0) {
				// �bfirst�k�bsecond��
				return 0;
			} else if (firstLineSide > 0 && secondLineSide < 0) {
				// �bfirst���bsecond�k

				return 1;
			} else if (firstLineSide > 0 && secondLineSide > 0) {
				// �bfirst���bsecond��

				return 2;
			} else if (firstLineSide < 0 && secondLineSide < 0) {
				// �bfirst�k�bsecond�k

				return 3;
			}
		}

		return -1;

	}

	public void move(int x, int y) {
		int newX = x - oX;
		int newY = y - oY;
		setpX(pX + newX);
		setpY(pY + newY);
		setoX(x);
		setoY(y);
	}

	public void setoX(int oX) {
		this.oX = oX;
	}

	public void setoY(int oY) {
		this.oY = oY;
	}

}	
