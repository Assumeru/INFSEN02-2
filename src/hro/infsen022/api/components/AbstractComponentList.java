package hro.infsen022.api.components;

import java.util.LinkedHashSet;

import hro.infsen022.api.collection.Collection;
import hro.infsen022.api.collection.Iterator;
import hro.infsen022.api.components.event.ListMouseEventListener;
import hro.infsen022.api.components.event.MouseListener;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.layout.Layout;
import hro.infsen022.api.optional.Option;

public abstract class AbstractComponentList implements ComponentList {
	private final Option<MouseListener> mouseListener;
	private final Collection<Component> components;
	private final Layout layout;

	public AbstractComponentList(Layout layout) {
		components = Collection.of(new LinkedHashSet<>());
		this.layout = layout;
		mouseListener = Option.of(new ListMouseEventListener(this));
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
	public boolean add(Component e) {
		return components.add(e);
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
	public Option<MouseListener> getMouseListener() {
		return mouseListener;
	}

	@Override
	public Iterator<Component> iterator() {
		return components.iterator();
	}
}
