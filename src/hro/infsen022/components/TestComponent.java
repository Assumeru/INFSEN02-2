package hro.infsen022.components;

import java.util.Objects;

import hro.infsen022.graphics.DrawContext;
import hro.infsen022.graphics.Paint;
import hro.infsen022.shape.Point;
import hro.infsen022.shape.Rectangle;

public class TestComponent implements Component {
	private final Rectangle rectangle;
	private Paint paint;

	public TestComponent(int w, int h) {
		this.rectangle = new Rectangle(new Point(0, 0), new Point(w, h));
		paint = new Paint();
	}

	public void setPaint(Paint paint) {
		this.paint = Objects.requireNonNull(paint);
	}

	@Override
	public void draw(DrawContext context) {
		context.drawRectangle(paint, rectangle);
	}

	@Override
	public Rectangle getBounds() {
		return rectangle;
	}
}
