package hro.infsen022.layout;

import java.util.LinkedHashMap;
import java.util.Map;

import hro.infsen022.api.components.Component;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.graphics.Matrix;
import hro.infsen022.api.layout.Layout;
import hro.infsen022.api.shape.Rectangle;

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

	@Override
	public Map<Component, Rectangle> getBounds(Rectangle bounds, Iterable<Component> components) {
		Map<Component, Rectangle> out = new LinkedHashMap<>();
		int height = 0;
		for(Component component : components) {
			Rectangle b = component.getBounds();
			out.put(component, new Rectangle(b.getX(), b.getY() + height, b.getWidth(), b.getHeight()));
			height += b.getHeight();
		}
		return out;
	}
}
