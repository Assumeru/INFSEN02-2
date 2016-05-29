package hro.infsen022.api.graphics;

public class Matrix {
	private final int x;
	private final int y;
	private final double rotation;

	public Matrix(int x, int y) {
		this(x, y, 0);
	}

	public Matrix(int x, int y, double rotation) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getRotation() {
		return rotation;
	}

	public Matrix add(Matrix matrix) {
		return new Matrix(x + matrix.x, y + matrix.y, rotation + matrix.rotation);
	}

	public Matrix subtract(Matrix matrix) {
		return new Matrix(x - matrix.x, y - matrix.y, rotation - matrix.rotation);
	}
}
