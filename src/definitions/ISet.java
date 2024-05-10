package definitions;

public interface ISet<T> {

    void add(T item);

    void remove(T item);

    boolean isEmpty();

    T choose();

}
