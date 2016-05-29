package hro.infsen022.components.factory;

import java.util.Objects;

import hro.infsen022.api.components.Button;
import hro.infsen022.api.components.Component;
import hro.infsen022.api.components.Label;
import hro.infsen022.api.components.Window;
import hro.infsen022.api.components.event.ClickListener;
import hro.infsen022.api.components.factory.ButtonFactory;
import hro.infsen022.api.components.factory.LabelFactory;
import hro.infsen022.api.components.factory.WindowFactory;
import hro.infsen022.api.graphics.Color;

public class Factory {
	private static WindowFactory windowFactory;
	private static ButtonFactory buttonFactory;
	private static LabelFactory labelFactory;
	static {
		setWindowFactory(new SwingWindowFactory());
		setButtonFactory(new DefaultButtonFactory());
		setLabelFactory(new DefaultLabelFactory());
	}

	private Factory() {
	}

	public static void setWindowFactory(WindowFactory windowFactory) {
		Factory.windowFactory = Objects.requireNonNull(windowFactory);
	}

	public static void setButtonFactory(ButtonFactory buttonFactory) {
		Factory.buttonFactory = Objects.requireNonNull(buttonFactory);
	}

	public static void setLabelFactory(LabelFactory labelFactory) {
		Factory.labelFactory = labelFactory;
	}

	public static Window createWindow() {
		return windowFactory.createWindow();
	}

	public static Button createButton(String text) {
		return buttonFactory.createButton(text);
	}

	public static Button createButton(String text, ClickListener listener) {
		return buttonFactory.createButton(text, listener);
	}

	public static Label createLabel(String text) {
		return labelFactory.createLabel(text);
	}

	public static Component createLabel(String text, Color color) {
		return labelFactory.createLabel(text, color);
	}
}
