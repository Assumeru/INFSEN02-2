package hro.infsen022.api.components;

public interface Window extends ComponentList {
	void setTitle(String title);

	void setVisible(boolean visible);

	void setSize(int width, int height);

	boolean isVisible();
}
