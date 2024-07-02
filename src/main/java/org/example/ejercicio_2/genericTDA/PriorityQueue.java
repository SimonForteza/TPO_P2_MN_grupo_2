package org.example.ejercicio_2.genericTDA;

import org.example.ejercicio_2.genericTDA.IPriorityQueue;

public class PriorityQueue<T, P extends Comparable<P>> implements IPriorityQueue<T, P> {

    private static final int MAX_VALUES = 10000;
    private T[] values;
    private P[] priorities;
    private int count;

    public PriorityQueue() {
        values = (T[]) new Object[MAX_VALUES];
        priorities = (P[]) new Comparable[MAX_VALUES];
        count = 0;
    }

    @Override
    public void add(T a, P priority) {
        //caso 1 - la cola está vacía y es el primer elemento a agregar
        if (count == 0) {
            values[count] = a;
            priorities[count] = priority;
            count++;
            return;
        }

        //caso 2 priority es mayor a la ultima prioridad (se coloca a lo ultimo)
        if (priority.compareTo(priorities[count - 1]) > 0) {
            values[count] = a;
            priorities[count] = priority;
            count++;
            return;
        }

        //caso 3 - prioriry es menor que la primer prioridad. hay que desplazar todo un lugar
        if (priority.compareTo(priorities[0]) <= 0) {
            for (int i = count - 1; i >= 0; i--) { // se desplaza los elementos a la derecha, empezando por el ultimo
                values[i + 1] = values[i];
                priorities[i + 1] = priorities[i];
            }
            values[0] = a;
            priorities[0] = priority;
            count++;
            return;
        }

        //caso 4 - la prioridad no se encuentra en los extremos

        //NO SE CHEQUE EL VALOR

        int index = -1; // buscamos una posicion en el array prioritiess
        for (int i = 1; i < count; i++) {
            if (priorities[i].compareTo(priority) > 0) {
                index = i; // posicion donde quiero copiar el elemento
                break;
            }
        }

        for (int i = count - 1; i >= index; i--) {
            values[i + 1] = values[i];
            priorities[i + 1] = priorities[i];
        }

        values[index] = a;
        priorities[index] = priority;
        count++;

    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }

        for(int i = 0; i < count - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T getFirst() {
        return values[0];
    }

    @Override
    public P getPriority() {
        return priorities[0];
    }
}
