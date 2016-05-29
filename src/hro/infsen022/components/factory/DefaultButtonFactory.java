package hro.infsen022.components.factory;

import hro.infsen022.api.components.Button;
import hro.infsen022.api.components.factory.ButtonFactory;
import hro.infsen022.components.DefaultButton;

public class DefaultButtonFactory implements ButtonFactory {
	@Override
	public Button createButton(String text) {
		return new DefaultButton(text);
	}
}
