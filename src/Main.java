import queue.Queue;
import queue.QueueUtil;
import stack.Stack;
import stack.StackUtil;

public class Main {

    public static void main(String[] args) {


//    Task 02
//      Dada una Queue de ´ındices (pueden elegir el orden en que lo consideran) y
//      los elementos de una Stack (el primero de la Queue es el ´ındice del tope de la
//      Stack), ordene la Stack en base a sus ´ındices.

        Queue queue = new Queue();
        Stack<Integer> stack = new Stack<>();

        queue.add(1);
        queue.add(0);
        queue.add(4);
        queue.add(3);
        queue.add(2);

        stack.add(3);
        stack.add(6);
        stack.add(1);
        stack.add(8);
        stack.add(4);

        System.out.println("Dada una Queue de ´ındices (pueden elegir el orden en que lo consideran) y\n"
                + "los elementos de una Stack (el primero de la Queue es el ´ındice del tope de la\n"
                + "Stack), ordene la Stack en base a sus ´ındices.");
        System.out.println("Queue de indices: ");
        QueueUtil.print(queue);
        System.out.println("Stack Original: ");
        StackUtil.print(stack);
        Stack<Integer> sortedStack = StackUtil.sortStack(stack, queue);
        System.out.println("Stack Ordenado: ");
        StackUtil.print(sortedStack);


        Queue actividad2 = new Queue();
        actividad2.add(0);
        actividad2.add(1);
        actividad2.add(2);
        actividad2.add(4);
        actividad2.add(5);
        actividad2.add(9);
        actividad2.add(3);
        actividad2.add(3);
        actividad2.add(1);
        actividad2.add(2);
        actividad2.add(8);
        actividad2.add(4);

        System.out.println("------");
        System.out.println("Subcola larga: "+QueueUtil.subColaLarga(actividad2));

    }

}