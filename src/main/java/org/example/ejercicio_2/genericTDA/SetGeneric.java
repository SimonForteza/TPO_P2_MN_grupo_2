package org.example.ejercicio_2.genericTDA;

import java.util.Random;

public class SetGeneric<T> implements ISetGeneric<T> {

    public static final int MAX = 10000;
    private T[] array;
    private int count;

    public SetGeneric() {
        array = (T[]) new Object[MAX];
        count = 0;
    }
    @Override
    public void add(T a) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }

        for (int i = 0; i < count; i++) {
            if (array[i] == a) { // verificamos si el elemento se repite en el conjunto
                return;
            }
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove(T a) {

        // Reemplazamos el elemento eliminado por el último elemento del array (no importa el orden de los elementos)
        for (int i = 0; i < count; i++) {
            if (array[i] == a) {
                array[i] = array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T choose() {
        if (count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vació");
        }

        Random random = new Random();
        return array[random.nextInt(count)];
    }
}
