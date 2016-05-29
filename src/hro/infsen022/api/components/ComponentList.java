package hro.infsen022.api.components;

import java.util.Collection;

import hro.infsen022.api.layout.Layout;

public interface ComponentList extends Collection<Component>, Component {
	Layout getLayout();
}
