package org.example.ejercicio_2;

public class Stack<T> implements IStack<T> {
    private static final int MAX = 10000;
    private T[] array;
    private int count;
    public Stack() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(T a) {
        if (this.count >= MAX) {
            throw new RuntimeException("Límite excedido");
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return this.array[this.count - 1];
    }
}
