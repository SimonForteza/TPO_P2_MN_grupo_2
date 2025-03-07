package org.example.ejercicio_2.genericTDA;

public interface IStackGeneric<T> {
    void add(T a);
    void remove();
    boolean isEmpty();
    T getTop();
}
