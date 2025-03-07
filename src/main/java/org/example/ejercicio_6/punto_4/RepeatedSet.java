package org.example.ejercicio_6.punto_4;

import org.example.tda.ISet;

import java.util.Random;

public class RepeatedSet implements ISet {

    public static final int MAX = 10000;
    private int[][] array; // array[0]: valor y array[1]: cantidad
    private int count;
    public RepeatedSet() {
        array = new int[MAX][2];
        count = 0;
    }
    @Override
    public void add(int a) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }

        for (int i = 0; i < count; i++) {
            if (array[i][0] == a) { // verificamos si el elemento se repite en el set
                array[i][1]++;
                return;
            }
        }

        array[count] = new int[2];
        array[count][0] = a;
        array[count][1] = 1;
        count++;
    }

    @Override
    public void remove(int a) {
        //bucle recorre arreglo
        for (int i = 0; i < count; i++) {
            if (array[i][0] == a) {
                // si el elemento aparece una sola vez - se mueve el último elemento a la posición del eliminado
                if (array[i][1] == 1) {
                    array[i] = array[count-1];
                    count--;
                    return;
                }

                //si el elemento se repite mas de 1 vez
                array[i][1]--;
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
        int[] elementsOfSet = listOfElement(array);
        Random random = new Random();
        return elementsOfSet[random.nextInt(count)];
    }

    private int[] listOfElement(int[][] array) {
        int[] elements = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            elements[i] = array[i][0];
        }
        return elements;
    }
}
