package queue;

import definitions.IQueue;

public class Queue implements IQueue {

    private int[] array;
    private int count;

    public Queue() {
        array = new int[10000];
        count = 0;
    }

    @Override
    public void add(int a) {
        if(count == 10000) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    // [16, 17, 18, 0, 0, 0]

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }
}
