package hro.infsen022.layout;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import hro.infsen022.api.collection.Collection;
import hro.infsen022.api.components.Component;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.graphics.Matrix;
import hro.infsen022.api.layout.Layout;
import hro.infsen022.api.shape.Rectangle;

public class VerticalLayout implements Layout {
	@Override
	public void draw(DrawContext context, Rectangle bounds, Collection<Component> components) {
		context.pushMatrix(new Matrix(bounds.getX(), bounds.getY()));
		AtomicInteger depth = new AtomicInteger(0);
		components.forEach(component -> {
			component.draw(context);
			Rectangle b = component.getBounds();
			depth.incrementAndGet();
			context.pushMatrix(new Matrix(0, b.getHeight()));
		});
		while(depth.get() > 0) {
			context.popMatrix();
			depth.decrementAndGet();
		}
		context.popMatrix();
	}

	@Override
	public Map<Component, Rectangle> getBounds(Rectangle bounds, Collection<Component> components) {
		Map<Component, Rectangle> out = new LinkedHashMap<>();
		AtomicInteger height = new AtomicInteger(0);
		components.forEach(component -> {
			Rectangle b = component.getBounds();
			out.put(component, new Rectangle(b.getX(), b.getY() + height.get(), b.getWidth(), b.getHeight()));
			height.addAndGet(b.getHeight());
		});
		return out;
	}
}
