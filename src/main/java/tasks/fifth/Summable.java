package tasks.fifth;


@FunctionalInterface
public interface Summable<T extends Number> {
    T sum(T a, T b);
}
