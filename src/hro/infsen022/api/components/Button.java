package hro.infsen022.api.components;

import hro.infsen022.api.components.event.ClickListener;
import hro.infsen022.api.components.event.MouseEvent;
import hro.infsen022.api.components.event.MouseListener;
import hro.infsen022.api.optional.Option;

public interface Button extends Label, MouseListener {
	@Override
	default Option<MouseListener> getMouseListener() {
		return Option.of(this);
	}

	void setClickListener(ClickListener listener);

	void setText(String text);

	@Override
	default void onMove(MouseEvent e) {
	}
}
