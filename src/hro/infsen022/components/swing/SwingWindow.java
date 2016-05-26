package hro.infsen022.components.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hro.infsen022.components.AbstractComponentList;
import hro.infsen022.components.Window;
import hro.infsen022.graphics.awt.AwtDrawContext;
import hro.infsen022.layout.AbsoluteLayout;
import hro.infsen022.shape.Point;
import hro.infsen022.shape.Rectangle;

public class SwingWindow extends AbstractComponentList implements Window {
	private JFrame window;

	public SwingWindow() {
		super(new AbsoluteLayout());
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
		int x = window.getX();
		int y = window.getY();
		int h = window.getHeight();
		int w = window.getWidth();
		return new Rectangle(new Point(x, y), new Point(x + w, y + h));
	}

	@Override
	public void setSize(int width, int height) {
		window.setSize(width, height);
	}

	private static class Canvas extends JPanel {
		private static final long serialVersionUID = -6928349957430108414L;
		private final SwingWindow window;

		public Canvas(SwingWindow window) {
			this.window = window;
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			window.draw(new AwtDrawContext((Graphics2D) g));
		}
	}
}
