package org.example.ejercicio_2.genericTDA;

public interface IPriorityQueueGeneric<T, P> {

    void add(T a, P priority);
    void remove();
    boolean isEmpty();
    T getFirst();
    P getPriority();

}
