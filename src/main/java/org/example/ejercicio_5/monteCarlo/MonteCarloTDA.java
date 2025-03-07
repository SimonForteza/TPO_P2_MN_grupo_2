package org.example.ejercicio_5.monteCarlo;

public class MonteCarloTDA {
    private ISetOfCoordinates coordinates;
    private double count;

    public MonteCarloTDA(ISetOfCoordinates coordinates) {
        this.coordinates = coordinates;
        count = 0;
    }

    public double approximatePi() {
        while (!coordinates.isEmpty()) {
            Coordinate point = coordinates.choose();
            if (Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= 1) {
                count++;
            }
            coordinates.remove(point);
        }
        double p = count / 10000;
        return 4 * p;
    }
}
