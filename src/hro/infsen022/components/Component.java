package hro.infsen022.components;

import hro.infsen022.graphics.Drawable;
import hro.infsen022.shape.Rectangle;

public interface Component extends Drawable {
	Rectangle getBounds();
}
