package hro.infsen022.api.collection;

class CollectionAdapter<T> implements Collection<T> {
	private java.util.Collection<T> collection;

	public CollectionAdapter(java.util.Collection<T> collection) {
		this.collection = collection;
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	@Override
	public boolean add(T element) {
		return collection.add(element);
	}

	@Override
	public Iterator<T> iterator() {
		return Iterator.of(collection.iterator());
	}
}
