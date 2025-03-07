package org.example.tda;

public interface IDictionary {
    void add(int key, int value);

    void remove(int key);

    ISet getKeys();

    int get(int key);

    boolean isEmpty();
}
