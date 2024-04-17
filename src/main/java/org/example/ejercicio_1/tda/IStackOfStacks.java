package org.example.ejercicio_1.tda;

public interface IStackOfStacks {
    void add(IStack stack);
    void remove();
    boolean isEmpty();
    IStack getTop();
}
