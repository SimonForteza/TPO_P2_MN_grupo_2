package org.example.ejercicio_2.genericTDA;

public interface ISet <T> {
    void add(T a);
    void remove(T a);
    boolean isEmpty();
    T choose();
}
