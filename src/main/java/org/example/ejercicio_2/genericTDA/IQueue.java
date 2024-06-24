package org.example.ejercicio_2.genericTDA;

/**
 *precondition: to use any of this methods the structure must be initialized
 */
public interface IQueue <T> {
    void add(T a);
    void remove();
    boolean isEmpty();
    T getFirst();
}
