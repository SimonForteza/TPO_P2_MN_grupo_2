package org.example.ejercicio_3;

import org.example.tda.IQueue;

public interface IQueueOfQueue {
    void add(IQueue a);
    void remove();
    boolean isEmpty();
    IQueue getFirst();
    void concatenate (IQueueOfQueue... queueOfQueues);
    IQueue getFlat();
    void reverseWithDepth();
}
