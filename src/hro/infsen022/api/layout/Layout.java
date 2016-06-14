package hro.infsen022.api.layout;

import java.util.Map;

import hro.infsen022.api.collection.Collection;
import hro.infsen022.api.components.Component;
import hro.infsen022.api.components.ComponentList;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.shape.Rectangle;

public interface Layout {
	void draw(DrawContext context, Rectangle bounds, Collection<Component> components);

	Map<Component, Rectangle> getBounds(Rectangle bounds, Collection<Component> components);

	default Map<Component, Rectangle> getBounds(ComponentList list) {
		return getBounds(list.getBounds(), list);
	}
}
