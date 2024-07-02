package org.example.ejercicio_4;

/**
 *precondition: to use any of these methods the structure must be initialized
 */
public interface IQueue {
    void add(int a);
    void remove();
    boolean isEmpty();
    int getFirst();
}
