package hro.infsen022.shape;

public class Rectangle {
	private final Point topLeft;
	private final Point bottomRight;

	public Rectangle(Point topLeft, Point bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	public int getWidth() {
		return bottomRight.getX() - topLeft.getX();
	}

	public int getHeight() {
		return bottomRight.getY() - topLeft.getY();
	}

	public int getX() {
		return topLeft.getX();
	}

	public int getY() {
		return topLeft.getY();
	}
}
