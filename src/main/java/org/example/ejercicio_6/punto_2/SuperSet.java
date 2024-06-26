package org.example.ejercicio_6.punto_2;

import org.example.ejercicio_6.punto_2.auxiliar_tda.ISet;
import org.example.ejercicio_6.punto_2.auxiliar_tda.Set;

import java.util.Random;

public class SuperSet implements ISuperSet{

    public static final int MAX = 10000;
    private int[] array;
    private int count;

    public SuperSet() {
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

    @Override
    public boolean isSubSet(ISet set) {
        ISet aux = copySet(set);
        ISet superSetElements = SetOfArray(array);

        while (!aux.isEmpty()) {
            int element = aux.choose();
            if (!inSet(superSetElements, element)) {
                return false;
            }
            aux.remove(element);
        }
        return true;
    }

    @Override
    public ISet complement(ISet set) {
        if (!isSubSet(set)) {
            throw new RuntimeException("El conjunto no es subconjunto del universal");
        }
        ISet complement = new Set();
        ISet superSetElements = SetOfArray(array);
        while (!superSetElements.isEmpty()) {
            int element = superSetElements.choose();
            if (!inSet(set, element)) {
                complement.add(element);
            }
            superSetElements.remove(element);
        }
        return complement;
    }

    private static ISet SetOfArray(int[] array) {
        ISet set = new Set();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }


    private static ISet copySet(ISet set) {
        ISet copy = new Set();
        ISet aux = new Set();

        while (!set.isEmpty()) {
            int element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while (!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }

    private static boolean inSet(ISet set, int a) {
        ISet copy = copySet(set);

        while (!copy.isEmpty()) {
            int element = copy.choose();
            if (element == a) {
                return true;
            }
            copy.remove(element);
        }
        return false;
    }
}


