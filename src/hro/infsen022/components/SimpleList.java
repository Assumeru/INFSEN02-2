package hro.infsen022.components;

import java.util.Collection;
import java.util.function.Predicate;

import hro.infsen022.api.components.AbstractComponentList;
import hro.infsen022.api.components.Component;
import hro.infsen022.api.components.DrawForBounds;
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
			int w = 0;
			int h = 0;
			for(Component c : this) {
				if(c instanceof DrawForBounds) {
					((DrawForBounds) c).setBounds(context);
				}
				Rectangle b = c.getBounds();
				w = Math.max(w, b.getWidth());
				h += b.getHeight();
			}
			bounds = new Rectangle(Point.ORIGIN, w, h);
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

	@Override
	public boolean addAll(Collection<? extends Component> c) {
		boolean out = super.addAll(c);
		if(out) {
			bounds = null;
		}
		return out;
	}

	@Override
	public boolean remove(Object o) {
		boolean out = super.remove(o);
		if(out) {
			bounds = null;
		}
		return out;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean out = super.removeAll(c);
		if(out) {
			bounds = null;
		}
		return out;
	}

	@Override
	public boolean removeIf(Predicate<? super Component> filter) {
		boolean out = super.removeIf(filter);
		if(out) {
			bounds = null;
		}
		return out;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean out = super.retainAll(c);
		if(out) {
			bounds = null;
		}
		return out;
	}
}
