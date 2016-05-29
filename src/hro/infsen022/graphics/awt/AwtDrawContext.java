package hro.infsen022.graphics.awt;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Deque;
import java.util.LinkedList;

import hro.infsen022.api.graphics.Color;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.graphics.Matrix;
import hro.infsen022.api.graphics.Paint;
import hro.infsen022.api.shape.Point;
import hro.infsen022.api.shape.Rectangle;

public class AwtDrawContext implements DrawContext {
	private final Graphics2D graphics;
	private final Deque<AffineTransform> matrices;

	public AwtDrawContext(Graphics2D graphics) {
		this.graphics = graphics;
		matrices = new LinkedList<>();
	}

	private java.awt.Color getColor(Color color) {
		return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}

	private void setFill(Paint paint) {
		graphics.setColor(getColor(paint.getFillColor()));
	}

	private void setStroke(Paint paint) {
		graphics.setColor(getColor(paint.getLineColor()));
		graphics.setStroke(new BasicStroke(paint.getLineWidth()));
	}

	@Override
	public void drawLine(Paint paint, Point x, Point y) {
		setStroke(paint);
		graphics.drawLine(x.getX(), x.getY(), y.getX(), y.getY());
	}

	@Override
	public void drawEllipse(Paint paint, Point center, int width, int height) {
		setStroke(paint);
		graphics.drawOval(center.getX(), center.getY(), width, height);
		setFill(paint);
		graphics.fillOval(center.getX(), center.getY(), width, height);
	}

	@Override
	public void drawRectangle(Paint paint, Rectangle rectangle) {
		int x = rectangle.getX();
		int y = rectangle.getY();
		int w = rectangle.getWidth();
		int h = rectangle.getHeight();
		setStroke(paint);
		graphics.drawRect(x, y, w, h);
		setFill(paint);
		graphics.fillRect(x, y, w, h);
	}

	@Override
	public void pushMatrix(Matrix matrix) {
		matrices.push(graphics.getTransform());
		if(matrix.getRotation() == 0) {
			graphics.translate(matrix.getX(), matrix.getY());
		} else {
			graphics.rotate(matrix.getRotation(), matrix.getX(), matrix.getY());
		}
	}

	@Override
	public void popMatrix() {
		graphics.setTransform(matrices.pop());
	}

	@Override
	public void drawText(Paint paint, Point point, CharSequence text) {
		setFill(paint);
		graphics.drawString(text.toString(), point.getX(), point.getY());
	}

	@Override
	public Rectangle getBounds(Paint paint, CharSequence text) {
		Rectangle2D bounds = graphics.getFontMetrics().getStringBounds(text.toString(), graphics);
		return new Rectangle(Point.ORIGIN, (int) bounds.getWidth(), (int) bounds.getHeight());
	}
}
