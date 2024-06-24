package org.example.ejercicio_2.genericTDA;

import org.example.ejercicio_2.genericTDA.IQueue;

public class Queue<T> implements IQueue<T> {

    private final T[] array;
    private int count;

    public Queue() {
        this.array = (T[]) new Object[10000];
        this.count = 0;
    }

    @Override
    public void add(T a) {
        if (count == 10000) {
            throw new RuntimeException("La cola está llena");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("pila está vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return array[0];
    }
}
