package hro.infsen022.api.components;

import hro.infsen022.api.components.event.MouseListener;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.graphics.Drawable;
import hro.infsen022.api.optional.Option;
import hro.infsen022.api.shape.Rectangle;

public interface Component extends Drawable {
	Rectangle getBounds();

	default Option<MouseListener> getMouseListener() {
		return Option.none();
	}

	void setBounds(DrawContext context);
}
