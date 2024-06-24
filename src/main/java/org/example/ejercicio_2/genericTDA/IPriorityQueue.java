package org.example.ejercicio_2.genericTDA;

public interface IPriorityQueue<T> {

    void add(T a, int priority);
    void remove();
    boolean isEmpty();
    T getFirst();
    int getPriority();

}
