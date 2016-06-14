package hro.infsen022.api.components.event;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import hro.infsen022.api.components.Component;
import hro.infsen022.api.components.ComponentList;
import hro.infsen022.api.shape.Point;
import hro.infsen022.api.shape.Rectangle;

public class ListMouseEventListener implements MouseListener {
	private final ComponentList list;
	private final Set<Component> inside;

	public ListMouseEventListener(ComponentList list) {
		this.list = list;
		inside = new HashSet<>();
	}

	@Override
	public void onClick(MouseEvent e) {
		Map<Component, Rectangle> bounds = list.getLayout().getBounds(list);
		list.forEach(c -> {
			if(bounds.containsKey(c) && bounds.get(c).contains(e.getPosition())) {
				c.getMouseListener().onSome(l -> l.onClick(e));
			}
		});
	}

	@Override
	public void onMove(MouseEvent e) {
		Map<Component, Rectangle> bounds = list.getLayout().getBounds(list);
		list.forEach(c -> {
			if(bounds.containsKey(c) && bounds.get(c).contains(e.getPosition())) {
				c.getMouseListener().onSome(l -> l.onMove(moveInside(e, bounds.get(c))));
				if(inside.add(c)) {
					c.getMouseListener().onSome(l -> l.onEnter(e));
				}
			} else {
				if(inside.remove(c)) {
					c.getMouseListener().onSome(l -> l.onExit(e));
				}
			}
		});
	}

	private MouseEvent moveInside(MouseEvent e, Rectangle rectangle) {
		int x = e.getPosition().getX() - rectangle.getX();
		int y = e.getPosition().getY() - rectangle.getY();
		return new MouseEvent(e.getScreenPosition(), new Point(x, y), e.getButton());
	}

	@Override
	public void onEnter(MouseEvent e) {
	}

	@Override
	public void onExit(MouseEvent e) {
		inside.forEach(c -> c.getMouseListener().onSome(l -> l.onExit(e)));
		inside.clear();
	}
}
