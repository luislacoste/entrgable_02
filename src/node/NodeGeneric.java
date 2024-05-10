package node;

import java.util.Objects;

public class NodeGeneric<T> {

    private T value;
    private NodeGeneric<T> next;

    public NodeGeneric(T value, NodeGeneric<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeGeneric<T> getNext() {
        return next;
    }

    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeGeneric<T> nodeGeneric = (NodeGeneric<T>) o;
        return getValue() == nodeGeneric.getValue() && Objects.equals(getNext(), nodeGeneric.getNext());
    }
}