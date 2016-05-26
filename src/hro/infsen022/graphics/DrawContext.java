package hro.infsen022.graphics;

import hro.infsen022.shape.Point;
import hro.infsen022.shape.Rectangle;

public interface DrawContext {
	void drawLine(Paint paint, Point x, Point y);

	default void drawCircle(Paint paint, Point center, int diameter) {
		drawEllipse(paint, center, diameter, diameter);
	}

	void drawEllipse(Paint paint, Point center, int width, int height);

	void drawRectangle(Paint paint, Rectangle rectangle);

	void pushMatrix(Matrix matrix);

	void popMatrix();
}
