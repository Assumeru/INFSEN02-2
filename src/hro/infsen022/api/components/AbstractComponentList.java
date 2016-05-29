package hro.infsen022.api.components;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import hro.infsen022.api.components.event.ListMouseEventListener;
import hro.infsen022.api.components.event.MouseListener;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.layout.Layout;

public abstract class AbstractComponentList implements ComponentList, DrawForBounds {
	private final Optional<MouseListener> mouseListener;
	private final Set<Component> components;
	private final Layout layout;

	public AbstractComponentList(Layout layout) {
		components = new LinkedHashSet<>();
		this.layout = layout;
		mouseListener = Optional.of(new ListMouseEventListener(this));
	}

	@Override
	public int size() {
		return components.size();
	}

	@Override
	public boolean isEmpty() {
		return components.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return components.contains(o);
	}

	@Override
	public Iterator<Component> iterator() {
		return components.iterator();
	}

	@Override
	public Object[] toArray() {
		return components.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return components.toArray(a);
	}

	@Override
	public boolean add(Component e) {
		return components.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return components.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return components.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Component> c) {
		return components.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return components.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return components.retainAll(c);
	}

	@Override
	public void clear() {
		components.clear();
	}

	@Override
	public Layout getLayout() {
		return layout;
	}

	@Override
	public void draw(DrawContext context) {
		setBounds(context);
		layout.draw(context, getBounds(), components);
	}

	@Override
	public Optional<MouseListener> getMouseListener() {
		return mouseListener;
	}
}
