package hro.infsen022.api.components;

import java.util.Optional;

import hro.infsen022.api.components.event.MouseListener;
import hro.infsen022.api.graphics.Drawable;
import hro.infsen022.api.shape.Rectangle;

public interface Component extends Drawable {
	Rectangle getBounds();

	default Optional<MouseListener> getMouseListener() {
		return Optional.empty();
	}
}
