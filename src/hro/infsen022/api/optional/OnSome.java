package hro.infsen022.api.optional;

@FunctionalInterface
public interface OnSome<I, O> {
	O visit(I input);
}
