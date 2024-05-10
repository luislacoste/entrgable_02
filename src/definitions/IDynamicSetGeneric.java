package definitions;

public interface IDynamicSetGeneric<T> {

    void add(T a);

    void remove(T a);

    boolean contains(T a);

    boolean isEmpty();

    T choose();

    boolean equals(Object o);

}