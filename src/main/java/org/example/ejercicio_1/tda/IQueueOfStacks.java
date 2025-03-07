package org.example.ejercicio_1.tda;

import org.example.tda.IStack;

public interface IQueueOfStacks {
    void add(IStack stack);
    void remove();
    IStack getFirst();
    boolean isEmpty();
}
