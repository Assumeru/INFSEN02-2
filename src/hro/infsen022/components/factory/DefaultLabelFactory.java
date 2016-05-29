package hro.infsen022.components.factory;

import hro.infsen022.api.components.Label;
import hro.infsen022.api.components.factory.LabelFactory;
import hro.infsen022.api.graphics.Color;
import hro.infsen022.components.DefaultLabel;

public class DefaultLabelFactory implements LabelFactory {
	@Override
	public Label createLabel(String text) {
		return new DefaultLabel(text, Color.BLACK);
	}

	@Override
	public Label createLabel(String text, Color color) {
		return new DefaultLabel(text, color);
	}
}
