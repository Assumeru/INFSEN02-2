package hro.infsen022.layout;

import hro.infsen022.components.Component;
import hro.infsen022.graphics.DrawContext;
import hro.infsen022.graphics.Matrix;
import hro.infsen022.shape.Rectangle;

public class VerticalLayout implements Layout {
	@Override
	public void draw(DrawContext context, Rectangle bounds, Iterable<Component> components) {
		context.pushMatrix(new Matrix(bounds.getX(), bounds.getY()));
		int depth = 0;
		for(Component component : components) {
			component.draw(context);
			bounds = component.getBounds();
			depth++;
			context.pushMatrix(new Matrix(0, bounds.getHeight()));
		}
		while(depth > 0) {
			context.popMatrix();
			depth--;
		}
		context.popMatrix();
	}
}
