package org.example.ejercicio_6.punto_5.auxiliarTDA;

public interface ISimpleDictionary {
    void add(int key, int value);

    void remove(int key);

    ISet getKeys();

    int get(int key);

    boolean isEmpty();
}
