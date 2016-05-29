package hro.infsen022.api.graphics;

public class Color {
	public static final Color BLACK = new Color(0xFF000000);
	public static final Color RED = new Color(0xFFFF0000);
	public static final Color GREEN = new Color(0xFF00FF00);
	public static final Color BLUE = new Color(0xFF0000FF);
	public static final Color TRANSPARENT = new Color(0);
	private final int color;

	public Color(int color) {
		this.color = color;
	}

	public Color(int red, int green, int blue) {
		this(255, red, green, blue);
	}

	public Color(int alpha, int red, int green, int blue) {
		this((cap(alpha) << 24) | (cap(red) << 16) | (cap(green) << 8) | cap(blue));
	}

	private static int cap(int value) {
		return Math.max(0, Math.min(255, value));
	}

	public int getAlpha() {
		return getAlpha(color);
	}

	public int getRed() {
		return getRed(color);
	}

	public int getGreen() {
		return getGreen(color);
	}

	public int getBlue() {
		return getBlue(color);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder('#');
		String hex = Integer.toHexString(color);
		while(sb.length() + hex.length() < 8) {
			sb.append('0');
		}
		return sb.append(hex).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(obj instanceof Color) {
			return color == ((Color) obj).color;
		}
		return false;
	}

	public static int getAlpha(int color) {
		return (color >> 24) & 0xFF;
	}

	public static int getRed(int color) {
		return (color >> 16) & 0xFF;
	}

	public static int getGreen(int color) {
		return (color >> 8) & 0xFF;
	}

	public static int getBlue(int color) {
		return color & 0xFF;
	}
}
