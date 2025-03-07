package org.example.ejercicio_5.monteCarlo;

import org.example.ejercicio_5.monteCarlo.Coordinate;
import org.example.ejercicio_5.monteCarlo.ISetOfCoordinates;

import java.util.Random;

public class SetOfCoordinates implements ISetOfCoordinates {
    public static final int MAX = 100000;
    private Coordinate[] array;
    private int count;

    public SetOfCoordinates() {
        array = new Coordinate[MAX];
        count = 0;
    }
    @Override
    public void add(Coordinate a) {
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
    public void remove(Coordinate a) {

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
    public Coordinate choose() {
        if (count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vació");
        }

        Random random = new Random();
        return array[random.nextInt(count)];
    }
}
