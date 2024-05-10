package queue;

import definitions.IQueueWithPriority;

public class QueueWithPriority implements IQueueWithPriority {

    private static final int TOTAL_VALUES = 10000;

    private int[] values;
    private int[] priorities;
    private int count;

    public QueueWithPriority() {
        values = new int[TOTAL_VALUES];
        priorities = new int[TOTAL_VALUES];
        count = 0;
    }

    // add (6, 0.5)
    // [(1, 0), (2, 0), (6, 0.5),(3, 1), (4, 3)]
    // [(1, 0), (2, 0),    , (3, 1),(5, 2), (4, 3)]

    @Override
    public void add(int a, int priority) {
        if(priorities[count - 1] < priority) {
            values[count] = a;
            priorities[count] = priority;
            count++;
            return;
        }

        if(priority <= priorities[0]) {
            for(int i = count - 1; i >= 0; i--) {
                values[i + 1] = values[i];
                priorities[i + 1] = priorities[i];
            }
            values[0] = a;
            priorities[0] = priority;
            count++;
            return;
        }

        int index = -1;
        for(int i = 1; i < count; i++) {
            if(priorities[i] > priority) {
                index = i;
                break;
            }
        }

        for(int i = count - 1; i >= index; i--) {
            values[i + 1] = values[i];
            priorities[i + 1] = priorities[i];
        }
        values[index] = a;
        priorities[index] = priority;
        count++;
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        return values[0];
    }

    @Override
    public int getPriority() {
        return priorities[0];
    }
}
