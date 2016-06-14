package hro.infsen022.api.optional;

class None<T> implements Option<T> {
	static final None<?> INSTANCE = new None<>();

	@Override
	public <O> O visit(OnSome<T, O> onSome, OnNone<O> onNone) {
		return onNone.visit();
	}

	@Override
	public boolean isSome() {
		return false;
	}
}
