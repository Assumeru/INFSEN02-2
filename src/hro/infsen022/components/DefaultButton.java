package hro.infsen022.components;

import java.util.Optional;

import hro.infsen022.api.components.Button;
import hro.infsen022.api.components.DrawForBounds;
import hro.infsen022.api.components.Label;
import hro.infsen022.api.components.event.ClickListener;
import hro.infsen022.api.components.event.MouseEvent;
import hro.infsen022.api.graphics.Color;
import hro.infsen022.api.graphics.DrawContext;
import hro.infsen022.api.graphics.Matrix;
import hro.infsen022.api.graphics.Paint;
import hro.infsen022.api.shape.Point;
import hro.infsen022.api.shape.Rectangle;
import hro.infsen022.components.factory.Factory;

public class DefaultButton implements Button, DrawForBounds {
	private static final Paint COLOR1 = new Paint(Color.TRANSPARENT, new Color(0xFFC6C6C6), 0);
	private static final Paint COLOR2 = new Paint(Color.TRANSPARENT, new Color(0xFFE5E5E5), 0);
	private static int MARGIN_BOTTOM = 3;
	private static int MARGIN_TOP = 0;
	private static int MARGIN_LEFT = 3;
	private static int MARGIN_RIGHT = 3;
	private Optional<ClickListener> listener = Optional.empty();
	private Rectangle bounds;
	private Label label;
	private Paint color1 = COLOR1;
	private Paint color2 = COLOR2;

	public DefaultButton(String text) {
		setLabel(text);
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public void draw(DrawContext context) {
		setBounds(context);
		Rectangle bounds = getBounds();
		Rectangle half = new Rectangle(bounds.getTopLeft(), bounds.getWidth(), bounds.getHeight() / 2);
		context.drawRectangle(color1, half);
		context.drawRectangle(color2, new Rectangle(new Point(half.getX(), half.getHeight()), bounds.getBottomRight()));
		context.pushMatrix(new Matrix(MARGIN_LEFT, MARGIN_TOP));
		label.draw(context);
		context.popMatrix();
	}

	@Override
	public void onEnter(MouseEvent e) {
		color1 = COLOR2;
		color2 = COLOR1;
	}

	@Override
	public void onExit(MouseEvent e) {
		color1 = COLOR1;
		color2 = COLOR2;
	}

	@Override
	public void onClick(MouseEvent e) {
		listener.ifPresent(l -> l.onClick(this, e));
	}

	@Override
	public void setClickListener(ClickListener listener) {
		this.listener = Optional.ofNullable(listener);
	}

	@Override
	public void setText(String text) {
		if(text == null) {
			text = "";
		}
		if(!text.equals(getText())) {
			setLabel(text);
		}
	}

	private void setLabel(String text) {
		label = Factory.createLabel(text);
		bounds = null;
	}

	@Override
	public void setBounds(DrawContext context) {
		if(bounds == null) {
			if(label instanceof DrawForBounds) {
				((DrawForBounds) label).setBounds(context);
			}
			Rectangle b = label.getBounds();
			bounds = new Rectangle(Point.ORIGIN, b.getWidth() + MARGIN_LEFT + MARGIN_RIGHT, b.getHeight() + MARGIN_BOTTOM + MARGIN_TOP);
		}
	}

	@Override
	public String getText() {
		return label.getText();
	}

	@Override
	public void setColor(Color color) {
		label.setColor(color);
	}
}
