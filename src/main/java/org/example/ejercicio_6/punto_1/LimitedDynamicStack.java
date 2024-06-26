package org.example.ejercicio_6.punto_1;

import java.util.Objects;

public class LimitedDynamicStack implements IStack {

    private Node first;
    private int limit; // cantidad maxima de elementos que puede tener
    private int count;

    public LimitedDynamicStack(int limit) {
        this.limit = limit;
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (count == limit) {
            throw new RuntimeException("La pila está llena");
        }
        Node node = new Node(a, first);
        first = node;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }

        first = first.getNext();
        count--;
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(first);
    }
}
