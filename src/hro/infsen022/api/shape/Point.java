package hro.infsen022.api.shape;

public class Point {
	public static final Point ORIGIN = new Point(0, 0);
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}
}
