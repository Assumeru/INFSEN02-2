package hro.infsen022.layout;

import java.util.LinkedHashMap;
import java.util.Map;

import hro.infsen022.api.collection.Collection;
import hro.infsen022.api.components.Component;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.layout.Layout;
import hro.infsen022.api.shape.Rectangle;

public class AbsoluteLayout implements Layout {
	@Override
	public void draw(DrawContext context, Rectangle bounds, Collection<Component> components) {
		components.forEach(c -> c.draw(context));
	}

	@Override
	public Map<Component, Rectangle> getBounds(Rectangle bounds, Collection<Component> components) {
		Map<Component, Rectangle> out = new LinkedHashMap<>();
		components.forEach(c -> out.put(c, c.getBounds()));
		return out;
	}
}
