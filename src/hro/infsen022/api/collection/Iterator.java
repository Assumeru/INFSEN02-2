package hro.infsen022.api.collection;

import hro.infsen022.api.optional.Option;

public interface Iterator<T> {
	Option<T> getNext();

	public static <T> Iterator<T> of(java.util.Iterator<T> iterator) {
		return new IteratorAdapter<>(iterator);
	}
}
