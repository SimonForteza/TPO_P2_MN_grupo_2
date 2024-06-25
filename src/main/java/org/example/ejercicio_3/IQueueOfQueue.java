package org.example.ejercicio_3;

import org.example.ejercicio_3.auxiliarTDA.IQueue;

public interface IQueueOfQueue {
    void add(IQueue a);
    void remove();
    boolean isEmpty();
    IQueue getFirst();
    void concatenate (IQueueOfQueue... queueOfQueues);
    IQueue getFlat();
    void reverseWithDepth();
}
