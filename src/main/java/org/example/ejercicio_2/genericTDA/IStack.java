package org.example.ejercicio_2.genericTDA;

public interface IStack <T> {
    void add(T a);
    void remove();
    boolean isEmpty();
    T getTop();
}
