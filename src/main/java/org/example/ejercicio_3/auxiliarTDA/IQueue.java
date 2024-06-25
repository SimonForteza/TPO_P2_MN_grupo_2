package org.example.ejercicio_3.auxiliarTDA;

/**
 *precondition: to use any of this methods the structure must be initialized
 */
public interface IQueue {
    void add(int a);
    void remove();
    boolean isEmpty();
    int getFirst();
}