package hro.infsen022.api.collection;

import hro.infsen022.api.optional.Option;

public class IteratorAdapter<T> implements Iterator<T> {
	private java.util.Iterator<T> iterator;

	public IteratorAdapter(java.util.Iterator<T> iterator) {
		this.iterator = iterator;
	}

	@Override
	public Option<T> getNext() {
		if(iterator.hasNext()) {
			return Option.of(iterator.next());
		}
		return Option.none();
	}
}
