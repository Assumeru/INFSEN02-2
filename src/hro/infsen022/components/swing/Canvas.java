package hro.infsen022.components.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import hro.infsen022.api.components.event.MouseEvent;
import hro.infsen022.api.shape.Point;
import hro.infsen022.graphics.awt.AwtDrawContext;

class Canvas extends JPanel implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener {
	private static final long serialVersionUID = -6928349957430108414L;
	private final SwingWindow window;

	public Canvas(SwingWindow window) {
		this.window = window;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		window.draw(new AwtDrawContext((Graphics2D) g));
	}

	private MouseEvent getMouseEvent(java.awt.event.MouseEvent e) {
		MouseEvent.Button button;
		switch(e.getButton()) {
		case java.awt.event.MouseEvent.BUTTON1:
			button = MouseEvent.Button.LEFT;
			break;
		case java.awt.event.MouseEvent.BUTTON2:
			button = MouseEvent.Button.RIGHT;
			break;
		case java.awt.event.MouseEvent.BUTTON3:
			button = MouseEvent.Button.MIDDLE;
			break;
		default:
			button = MouseEvent.Button.NONE;
		}
		return new MouseEvent(
				new Point(e.getXOnScreen(), e.getYOnScreen()),
				new Point(e.getX(), e.getY()), button);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		window.getMouseListener().ifPresent(l -> l.onClick(getMouseEvent(e)));
		repaint();
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		window.getMouseListener().ifPresent(l -> l.onEnter(getMouseEvent(e)));
		repaint();
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		window.getMouseListener().ifPresent(l -> l.onExit(getMouseEvent(e)));
		repaint();
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		window.getMouseListener().ifPresent(l -> l.onMove(getMouseEvent(e)));
		repaint();
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
	}
}
