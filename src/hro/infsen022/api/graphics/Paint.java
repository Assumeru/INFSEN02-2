package hro.infsen022.api.graphics;

public class Paint {
	private final Color lineColor;
	private final Color fillColor;
	private final float lineWidth;

	public Paint() {
		this(Color.BLACK, Color.TRANSPARENT, 1);
	}

	public Paint(Color lineColor, Color fillColor, float lineWidth) {
		this.lineColor = lineColor;
		this.fillColor = fillColor;
		this.lineWidth = lineWidth;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public float getLineWidth() {
		return lineWidth;
	}
}
