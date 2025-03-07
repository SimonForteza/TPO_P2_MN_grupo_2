package org.example.ejercicio_5.monteCarlo;

import org.example.ejercicio_5.monteCarlo.Coordinate;
import org.example.ejercicio_5.monteCarlo.ISetOfCoordinates;
import org.example.ejercicio_5.monteCarlo.MonteCarloTDA;
import org.example.ejercicio_5.monteCarlo.SetOfCoordinates;

public class TestMonteCarlo {
    public static void main(String[] args) {
        ISetOfCoordinates points = new SetOfCoordinates();

        for (int i = 0; i <= 10000; i++) {
            Coordinate point = new Coordinate(Math.random(), Math.random());
            points.add(point);
        }

        MonteCarloTDA pi = new MonteCarloTDA(points);
        System.out.println(pi.approximatePi());
    }
}
