package hro.infsen022.api.components;

import java.util.Optional;

import hro.infsen022.api.components.event.ClickListener;
import hro.infsen022.api.components.event.MouseEvent;
import hro.infsen022.api.components.event.MouseListener;

public interface Button extends Label, MouseListener {
	@Override
	default Optional<MouseListener> getMouseListener() {
		return Optional.of(this);
	}

	void setClickListener(ClickListener listener);

	void setText(String text);

	@Override
	default void onMove(MouseEvent e) {
	}
}
