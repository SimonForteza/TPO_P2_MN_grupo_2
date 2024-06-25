package org.example.ejercicio_5.monteCarlo;

import org.example.ejercicio_5.monteCarlo.Coordinate;

public interface ISetOfCoordinates {
    void add(Coordinate a);
    void remove(Coordinate a);
    boolean isEmpty();
    Coordinate choose();
}
