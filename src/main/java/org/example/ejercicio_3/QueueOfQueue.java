package org.example.ejercicio_3;

import org.example.ejercicio_3.auxiliarTDA.IStack;
import org.example.ejercicio_3.auxiliarTDA.Stack;
import org.example.ejercicio_3.auxiliarTDA.IQueue;
import org.example.ejercicio_3.auxiliarTDA.Queue;
import org.example.ejercicio_3.IQueueOfQueue;

public class QueueOfQueue implements IQueueOfQueue {
    private static final int MAX = 10000;
    private IQueue array[];
    private int  count;

    public QueueOfQueue() {
        array = new IQueue[MAX];
        count = 0;
    }

    @Override
    public void add(IQueue a) {
        if (count == MAX) {
            throw new RuntimeException("La cola está llena");
        }

        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public IQueue getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("la cola está vacía");
        }
        return array[0];
    }

    @Override
    public void concatenate(IQueueOfQueue... queueOfQueues) {
        for (IQueueOfQueue q: queueOfQueues) {
            while (!q.isEmpty()) {
                IQueue queue = q.getFirst();
                array[count] = queue;
                count++;
                q.remove();
            }
        }
    }

    @Override
    public IQueue getFlat() {
        IQueue flat = new Queue();
        for (int i = 0; i < count; i++) {
            IQueue queue = array[i];
            while (!queue.isEmpty()) {
                flat.add(queue.getFirst());
                queue.remove();
            }
        }
        return flat;
    }

    @Override
    public void reverseWithDepth() {
        IStack reverse = new Stack();
        for (int i = 0; i < count; i++) {
            IQueue queue = array[i];
            while (!queue.isEmpty()) {
                reverse.add(queue.getFirst());
                queue.remove();
            }

            while (!reverse.isEmpty()) {
                queue.add(reverse.getTop());
                reverse.remove();
            }
        }

        for(int i = 0; i < count / 2; i++) {
            IQueue temp = array[i];
            array[i] = array[count - i - 1];
            array[count - i - 1] = temp;
        }
    }
}
