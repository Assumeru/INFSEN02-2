package hro.infsen022.api.optional;

class Some<T> implements Option<T> {
	private final T value;

	public Some(T value) {
		this.value = value;
	}

	@Override
	public <O> O visit(OnSome<T, O> onSome, OnNone<O> onNone) {
		return onSome.visit(value);
	}

	@Override
	public boolean isSome() {
		return true;
	}
}
