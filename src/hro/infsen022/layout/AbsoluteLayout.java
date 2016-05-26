package hro.infsen022.layout;

import hro.infsen022.components.Component;
import hro.infsen022.graphics.DrawContext;
import hro.infsen022.shape.Rectangle;

public class AbsoluteLayout implements Layout {
	@Override
	public void draw(DrawContext context, Rectangle bounds, Iterable<Component> components) {
		components.forEach(c -> c.draw(context));
	}
}
