package hro.infsen022.api.components.factory;

import hro.infsen022.api.components.Label;
import hro.infsen022.api.graphics.Color;

public interface LabelFactory {
	Label createLabel(String text);

	default Label createLabel(String text, Color color) {
		Label label = createLabel(text);
		label.setColor(color);
		return label;
	}
}
