package stack;

import definitions.IStack;

public class Stack<T> implements IStack<T> {

    private static final int MAX = 10000;

    private Object[] array; // Use Object[] to store elements of any type
    private int count;

    public Stack() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(T item) {
        if (this.count >= MAX) {
            throw new RuntimeException("Stack overflow");
        }
        this.array[this.count++] = item;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        this.count--;
    }

    @Override
    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Cast the Object to T
        return (T) this.array[this.count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
