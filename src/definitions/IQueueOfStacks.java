package definitions;

import stack.Stack;

public interface IQueueOfStacks<T> {

//    @param queueOfStacks la cola de pilas que quiero calcular la traza
    void addStack(Stack<T> stack);


//    Calcula la longitud de la cola
    void removeStack();

//    @param queueOfStacks la cola de pilas que quiero invertir
    boolean isEmpty();


//     a cola de pilas que quiero sumar matricialmente
    Stack<T> getFirst();
}
