package hro.infsen022.components.swing;

import javax.swing.JFrame;

import hro.infsen022.api.components.AbstractComponentList;
import hro.infsen022.api.components.Window;
import hro.infsen022.api.components.event.ListMouseEventListener;
import hro.infsen022.api.components.event.MouseListener;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.optional.Option;
import hro.infsen022.api.shape.Rectangle;
import hro.infsen022.layout.AbsoluteLayout;

public class SwingWindow extends AbstractComponentList implements Window {
	private final MouseListener mouseListener;
	private final JFrame window;

	public SwingWindow() {
		super(new AbsoluteLayout());
		mouseListener = new ListMouseEventListener(this);
		window = new JFrame();
		window.add(new Canvas(this));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void setTitle(String title) {
		window.setTitle(title);
	}

	@Override
	public void setVisible(boolean visible) {
		window.setVisible(visible);
	}

	@Override
	public boolean isVisible() {
		return window.isVisible();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(window.getX(), window.getY(), window.getWidth(), window.getHeight());
	}

	@Override
	public void setSize(int width, int height) {
		window.setSize(width, height);
	}

	@Override
	public Option<MouseListener> getMouseListener() {
		return Option.of(mouseListener);
	}

	@Override
	public void setBounds(DrawContext context) {
	}
}
