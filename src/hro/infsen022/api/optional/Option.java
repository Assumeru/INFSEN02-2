package hro.infsen022.api.optional;

import java.util.function.Consumer;

public interface Option<T> {
	<O> O visit(OnSome<T, O> onSome, OnNone<O> onNone);

	default void onSome(Consumer<T> onSome) {
		visit(i -> {
			onSome.accept(i);
			return null;
		}, () -> null);
	}

	default void onNone(Runnable onNone) {
		visit(i -> null, () -> {
			onNone.run();
			return null;
		});
	}

	boolean isSome();

	public static <T> Option<T> of(T value) {
		return new Some<>(value);
	}

	@SuppressWarnings("unchecked")
	public static <T> Option<T> none() {
		return (Option<T>) None.INSTANCE;
	}
}
