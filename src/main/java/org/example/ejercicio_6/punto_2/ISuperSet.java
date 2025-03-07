package org.example.ejercicio_6.punto_2;

import org.example.tda.ISet;

public interface ISuperSet {
    void add(int a);
    void remove(int a);
    boolean isEmpty();
    int choose();
    boolean isSubSet(ISet set);

    /**
     * Precondicion: no se puede calcular el complemento de un conjunto que no es subconjunto del superconjunto.
    * */
    ISet complement(ISet set);
}
