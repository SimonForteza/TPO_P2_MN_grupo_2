package org.example.ejercicio_3.auxiliarTDA;

public class Queue implements IQueue{

    private final int[] array;
    private int count;

    public Queue() {
        this.array = new int[10000];
        this.count = 0;
    }

    @Override
    public void add(int a) {
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
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return array[0];
    }
}
