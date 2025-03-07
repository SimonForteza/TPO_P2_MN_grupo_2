package org.example.ejercicio_2.genericTDA;

public interface ISetGeneric<T> {
    void add(T a);
    void remove(T a);
    boolean isEmpty();
    T choose();
}
