package hro.infsen022.components.factory;

import hro.infsen022.api.components.Window;
import hro.infsen022.api.components.factory.WindowFactory;
import hro.infsen022.components.swing.SwingWindow;

public class SwingWindowFactory implements WindowFactory {
	@Override
	public Window createWindow() {
		return new SwingWindow();
	}
}
