package org.example.ejercicio_1.tda;

import org.example.tda.IStack;

public interface IStackOfStacks {
    void add(IStack stack);
    void remove();
    boolean isEmpty();
    IStack getTop();
}
