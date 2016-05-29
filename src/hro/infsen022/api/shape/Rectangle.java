package hro.infsen022.api.shape;

public class Rectangle {
	private final Point topLeft;
	private final Point bottomRight;

	public Rectangle(Point topLeft, Point bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

	public Rectangle(Point topLeft, int width, int height) {
		this(topLeft, new Point(topLeft.getX() + width, topLeft.getY() + height));
	}

	public Rectangle(int x, int y, int width, int height) {
		this(new Point(x, y), width, height);
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

	public boolean contains(Point p) {
		return p.getX() >= getX() && p.getX() <= bottomRight.getX() && p.getY() >= getY() && p.getY() <= bottomRight.getY();
	}

	@Override
	public String toString() {
		return "(" + topLeft + "), (" + bottomRight + ")";
	}
}
