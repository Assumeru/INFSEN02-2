package hro.infsen022.api.optional;

@FunctionalInterface
public interface OnNone<O> {
	O visit();
}
