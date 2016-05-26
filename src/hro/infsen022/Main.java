package hro.infsen022;

import hro.infsen022.components.SimpleList;
import hro.infsen022.components.TestComponent;
import hro.infsen022.components.Window;
import hro.infsen022.components.swing.SwingWindow;
import hro.infsen022.graphics.Color;
import hro.infsen022.graphics.Paint;

public class Main {
	public static void main(String[] args) {
		Window window = new SwingWindow();
		window.setTitle("test");
		window.setSize(200, 200);
		SimpleList list = new SimpleList();
		TestComponent rect = new TestComponent(100, 100);
		rect.setPaint(new Paint(Color.BLACK, Color.BLUE, 10));
		list.add(rect);
		list.add(new TestComponent(50, 50));
		list.add(new TestComponent(25, 25));
		window.add(list);
		window.setVisible(true);
	}
}
