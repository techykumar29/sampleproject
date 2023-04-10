@FunctionalInterface
public interface HandleExceptionForFunction<T, E extends Exception>{

	void apply(T t) throws E;
}
