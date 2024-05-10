package definitions;

public interface IStack<T> {

    void add(T item);

    void remove();

    T getTop();

    boolean isEmpty();

}
