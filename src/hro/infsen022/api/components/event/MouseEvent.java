package hro.infsen022.api.components.event;

import hro.infsen022.api.shape.Point;

public class MouseEvent {
	public static enum Button {
		NONE, LEFT, MIDDLE, RIGHT
	}
	private final Point screenPos;
	private final Point componentPos;
	private final Button button;

	public MouseEvent(Point screenPos, Point componentPos, Button button) {
		this.screenPos = screenPos;
		this.componentPos = componentPos;
		this.button = button;
	}

	public Point getScreenPosition() {
		return screenPos;
	}

	public Point getPosition() {
		return componentPos;
	}

	public Button getButton() {
		return button;
	}
}
