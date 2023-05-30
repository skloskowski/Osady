package org.example;

import static java.lang.Math.sqrt;

public class Vector {
    private final double x;
    private final double y;

    public Vector add(Vector other) {
        double x = this.x + other.getX();
        double y = this.y + other.getY();
        return new Vector(x, y);
    }

    public double getVectorLength() {
        return sqrt(x * x + y * y);
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector normalize() {
        double x = this.x / getVectorLength();
        double y = this.y / getVectorLength();
        return new Vector(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
