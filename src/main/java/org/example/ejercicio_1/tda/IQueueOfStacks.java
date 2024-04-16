package org.example.ejercicio_1.tda;

public interface IQueueOfStacks {
    void add(IStack stack);
    void remove();
    IStack getFirst();
    boolean isEmpty();
}
