package org.example.ejercicio_2;

public interface IStack <T> {
    void add(T a);
    void remove();
    boolean isEmpty();
    T getTop();
}
