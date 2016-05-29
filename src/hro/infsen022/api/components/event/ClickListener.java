package hro.infsen022.api.components.event;

import hro.infsen022.api.components.Button;

@FunctionalInterface
public interface ClickListener {
	void onClick(Button b, MouseEvent e);
}
