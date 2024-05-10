package queue;

public class DynamicQueueWithPriorityUtil {

        public static DynamicQueueWithPriority copyQueue(DynamicQueueWithPriority queue) {
            DynamicQueueWithPriority aux = new DynamicQueueWithPriority();
            DynamicQueueWithPriority copy = new DynamicQueueWithPriority();
            while (!queue.isEmpty()) {
                aux.add(queue.getFirst(), queue.getPriority());
                copy.add(queue.getFirst(), queue.getPriority());
                queue.remove();
            }
            while (!aux.isEmpty()) {
                queue.add(aux.getFirst(), aux.getPriority());
                aux.remove();
            }
            return copy;
        }

        public static void printQueue(DynamicQueueWithPriority queue) {
            DynamicQueueWithPriority aux = copyQueue(queue);
            while (!aux.isEmpty()) {
                System.out.println(aux.getFirst());
                aux.remove();
            }
        }
}
