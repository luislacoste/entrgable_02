package stack;

import definitions.IStack;
import queue.DynamicQueueWithPriority;
import queue.Queue;

public class StackUtil<T> {

    public static <T> IStack<T> copy(IStack<T> stack) {
        IStack<T> stack1 = new Stack<>();
        IStack<T> stack2 = new Stack<>();

        while (!stack.isEmpty()) {
            stack1.add(stack.getTop());
            stack2.add(stack.getTop());
            stack.remove();
        }

        while (!stack1.isEmpty()) {
            stack.add(stack1.getTop());
            stack1.remove();
        }

        while (!stack2.isEmpty()) {
            stack1.add(stack2.getTop());
            stack2.remove();
        }

        return stack1;
    }

    public static <T> void print(IStack<T> stack) {
        IStack<T> copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }

    public static <T> T filter(IStack<T> stack) {
        IStack<T> copy = copy(stack);
        int count = 0;

        IStack<T> stack1 = new Stack<>();
        IStack<T> stack2 = new Stack<>();
        IStack<T> stack3 = new Stack<>();

        while (!copy.isEmpty()) {
            stack3.add(copy.getTop());
            if (count % 2 == 0) {
                stack1.add(copy.getTop());
            } else {
                stack2.add(copy.getTop());
            }
            count++;
            copy.remove();
        }

        while (!stack2.isEmpty() && !stack3.isEmpty()) {
            stack2.remove();
            stack3.remove();
        }

        return (T) stack3.getTop();
    }

    public static <T> Stack<T> invert(Stack<T> stack) {
        IStack<T> aux = copy(stack);
        Stack<T> inverted = new Stack<>();
        while (!aux.isEmpty()) {
            inverted.add(aux.getTop());
            aux.remove();
        }
        return inverted;
    }

    public static <T> int size(Stack<T> stack) {
        int count = 0;
        IStack<T> auxStack = copy(stack);

        while (!auxStack.isEmpty()) {
            count++;
            auxStack.remove();
        }
        return count;
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack, Queue queue) {
        // Creo una queue with priority dandole como valor el tope de la stack
        // y como prioridad el primer elemento de la queue
        // despueso ordeno la queue con prioridad y la vuelvo a pasar a la stack
        DynamicQueueWithPriority queueWithPriority = new DynamicQueueWithPriority();

        while (!queue.isEmpty()) {
            int index = queue.getFirst();
            queue.remove();
            int stackValue = stack.getTop();
            stack.remove();

            queueWithPriority.add(stackValue, index);


        }

        while (!queueWithPriority.isEmpty()) {
            stack.add(queueWithPriority.getFirst());
            queueWithPriority.remove();
        }

        stack = StackUtil.invert(stack);
        return stack;
    }
}