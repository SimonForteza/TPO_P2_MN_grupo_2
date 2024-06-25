package org.example.ejercicio_5.auxiliarTDA;

public class Stack implements IStack {

    private static final int MAX = 10000; // limite maximo de la pila
    private int[] array; // si no le doy un valor causa error
    private int count;  // como es un dato primitivo se llena con un cero
    public Stack() {
        this.array = new int[MAX];
        this.count = 0; // esta linea no es necesaria, solo aclara el codigo.
    }

    @Override
    public void add(int a) {
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
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return this.array[this.count - 1];
    }
}
