package hro.infsen022.api.graphics;

import hro.infsen022.api.shape.Point;
import hro.infsen022.api.shape.Rectangle;

public interface DrawContext {
	void drawLine(Paint paint, Point x, Point y);

	default void drawCircle(Paint paint, Point center, int diameter) {
		drawEllipse(paint, center, diameter, diameter);
	}

	void drawEllipse(Paint paint, Point center, int width, int height);

	void drawRectangle(Paint paint, Rectangle rectangle);

	void drawText(Paint paint, Point point, CharSequence text);

	Rectangle getBounds(Paint paint, CharSequence text);

	void pushMatrix(Matrix matrix);

	void popMatrix();
}
