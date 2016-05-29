package hro.infsen022;

import hro.infsen022.api.components.Window;
import hro.infsen022.api.graphics.Color;
import hro.infsen022.components.SimpleList;
import hro.infsen022.components.factory.Factory;

public class Main {
	public static void main(String[] args) {
		Window window = Factory.createWindow();
		window.setTitle("test");
		window.setSize(400, 300);
		SimpleList list = new SimpleList();
		list.add(Factory.createLabel("Test", Color.BLACK));
		list.add(Factory.createButton("Test", (b, e) -> b.setText("clicked")));
		window.add(list);
		window.setVisible(true);
	}
}
