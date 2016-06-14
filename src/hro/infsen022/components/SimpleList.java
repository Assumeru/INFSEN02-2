package hro.infsen022.components;

import java.util.concurrent.atomic.AtomicInteger;

import hro.infsen022.api.components.AbstractComponentList;
import hro.infsen022.api.components.Component;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.shape.Point;
import hro.infsen022.api.shape.Rectangle;
import hro.infsen022.layout.VerticalLayout;

public class SimpleList extends AbstractComponentList {
	private Rectangle bounds;

	public SimpleList() {
		super(new VerticalLayout());
	}

	@Override
	public void setBounds(DrawContext context) {
		if(bounds == null) {
			calculateBounds(context);
		}
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	private synchronized void calculateBounds(DrawContext context) {
		if(bounds == null) {
			AtomicInteger w = new AtomicInteger(0);
			AtomicInteger h = new AtomicInteger(0);
			forEach(c -> {
				c.setBounds(context);
				Rectangle b = c.getBounds();
				w.set(Math.max(w.get(), b.getWidth()));
				h.addAndGet(b.getHeight());
			});
			bounds = new Rectangle(Point.ORIGIN, w.get(), h.get());
		}
	}

	@Override
	public boolean add(Component e) {
		boolean out = super.add(e);
		if(out) {
			bounds = null;
		}
		return out;
	}
}
