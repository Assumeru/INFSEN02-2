package hro.infsen022.api.components.factory;

import hro.infsen022.api.components.Button;
import hro.infsen022.api.components.event.ClickListener;

public interface ButtonFactory {
	Button createButton(String text);

	default Button createButton(String text, ClickListener listener) {
		Button button = createButton(text);
		button.setClickListener(listener);
		return button;
	}
}
