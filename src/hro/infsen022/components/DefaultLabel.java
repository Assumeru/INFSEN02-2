package hro.infsen022.components;

import hro.infsen022.api.components.Label;
import hro.infsen022.api.graphics.Color;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.graphics.Paint;
import hro.infsen022.api.shape.Point;
import hro.infsen022.api.shape.Rectangle;

public class DefaultLabel implements Label {
	private final String text;
	private Paint paint;
	private Rectangle bounds;
	private Point point;

	public DefaultLabel(String text, Color color) {
		this.text = text;
		setColor(color);
	}

	@Override
	public void draw(DrawContext context) {
		setBounds(context);
		context.drawText(paint, point, text);
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public void setBounds(DrawContext context) {
		if(bounds == null) {
			bounds = context.getBounds(paint, text);
			point = new Point(bounds.getX(), bounds.getHeight());
		}
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setColor(Color color) {
		this.paint = new Paint(Color.BLACK, color, 1);
	}
}
