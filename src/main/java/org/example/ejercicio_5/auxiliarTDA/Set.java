package org.example.ejercicio_5.auxiliarTDA;

import java.util.Random;

public class Set implements ISet {

    public static final int MAX = 10000;
    private int[] array;
    private int count;

    public Set() {
        array = new int[MAX];
        count = 0;
    }
    @Override
    public void add(int a) {
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
    public void remove(int a) {

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
    public int choose() {
        if (count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vació");
        }

        Random random = new Random();
        return array[random.nextInt(count)];
    }
}
