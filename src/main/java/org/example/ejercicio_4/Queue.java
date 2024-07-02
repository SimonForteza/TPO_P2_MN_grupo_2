package org.example.ejercicio_4;

public class Queue implements IQueue {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public Queue() {
        this.array = new int[MAX];
        this.count = 0;
    }
    public Queue(int... elements) { //constructor con parametros variables
        this.array = new int[MAX];
        this.count = 0;
        if (elements.length > MAX) {
            throw new RuntimeException("La cantidad de elementos sobrepasa el limite de la cola");
        }
        for (int element : elements) {
            add(element);
        }
    }


    @Override
    public void add(int a) {
        if (count == MAX) {
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
