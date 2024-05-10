package queue;

import java.util.HashMap;
import java.util.Map;

public class QueueUtil {

    public static Queue copyQueue(Queue queue) {
        Queue aux = new Queue();
        Queue copy = new Queue();
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            copy.add(queue.getFirst());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst());
            aux.remove();
        }
        return copy;
    }

    public static void print(Queue queue) {
        Queue aux = copyQueue(queue);
        while (!aux.isEmpty()) {
            System.out.println(aux.getFirst());
            aux.remove();
        }
    }

    // TODO: no rompa el queue
    public static int getSize(Queue queue) {
        Queue aux = copyQueue(queue);
        int size = 0;
        while (!aux.isEmpty()) {
            size++;
            aux.remove();
        }
        return size;
    }


    public static int getQueueIndex(Queue queue, int index) {
        Queue aux = new Queue();
        int value = 0;
        while (!queue.isEmpty()) {
            int auxValue = queue.getFirst();
            queue.remove();
            aux.add(auxValue);
            if (index == 0) {
                value = auxValue;
            }
            index--;
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst());
            aux.remove();
        }
        return value;
    }

    public static String subColaLarga(Queue queue) {
//        Map<Queue, Integer> contador = new HashMap<>();
//        secuenciaActual era mi idea... pero por alguna razon cuando la agrego a el map se re agrega en cada interacion
        Map<String, Integer> contador = new HashMap<>();


        int queueSize = QueueUtil.getSize(queue);
        for (int i = 0; i < queueSize; i++) {
            Queue secuenciaActual = new Queue();
            int value = getQueueIndex(queue, i);
            String subColaString = String.valueOf(value);
            secuenciaActual.add(value);
            for (int j = 1 + i; j < queueSize; j++) {
                value = getQueueIndex(queue, j);

                // deberia usar stringbuilder... no clue de que es eso
                subColaString += String.valueOf(value);
                secuenciaActual.add(value);
                contador.put(subColaString, contador.getOrDefault(subColaString, 0) + 1);

            }


        }

        int max = 0;
        String maxString = "";
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxString = entry.getKey();
            }
        }

        return maxString;
    }
}
