package hro.infsen022.api.collection;

import java.util.Objects;
import java.util.function.Consumer;

import hro.infsen022.api.optional.Option;

public interface Collection<T> {
	int size();

	boolean isEmpty();

	boolean add(T element);

	Iterator<T> iterator();

	default void forEach(Consumer<T> consumer) {
		Iterator<T> it = iterator();
		Option<T> value;
		while((value = it.getNext()).isSome()) {
			value.onSome(consumer);
		}
	}

	public static <T> Collection<T> of(java.util.Collection<T> collection) {
		return new CollectionAdapter<>(Objects.requireNonNull(collection));
	}
}
