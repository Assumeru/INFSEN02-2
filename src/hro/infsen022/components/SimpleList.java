package hro.infsen022.components;

import java.util.Collection;
import java.util.function.Predicate;

import hro.infsen022.layout.VerticalLayout;
import hro.infsen022.shape.Point;
import hro.infsen022.shape.Rectangle;

public class SimpleList extends AbstractComponentList {
	private Rectangle bounds;

	public SimpleList() {
		super(new VerticalLayout());
	}

	@Override
	public Rectangle getBounds() {
		if(bounds == null) {
			calculateBounds();
		}
		return bounds;
	}

	private synchronized void calculateBounds() {
		if(bounds == null) {
			int w = 0;
			int h = 0;
			for(Component c : this) {
				Rectangle b = c.getBounds();
				w = Math.max(w, b.getWidth());
				h += b.getHeight();
			}
			bounds = new Rectangle(new Point(0, 0), new Point(w, h));
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
