package org.example;

import static java.lang.Math.sqrt;

public class Vector {
    private final double x;
    private final double y;

    /***
     * adds 2 vectors
     * @param other other vector to add
     * @return vector after addition
     */
    public Vector add(Vector other) {
        double x = this.x + other.getX();
        double y = this.y + other.getY();
        return new Vector(x, y);
    }

    /***
     *
     * @return length of vector
     */
    public double getVectorLength() {
        return sqrt(x * x + y * y);
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /***
     *
     * @return normalized vector
     */
    public Vector normalize() {
        double x = this.x / getVectorLength();
        double y = this.y / getVectorLength();
        return new Vector(x, y);
    }

    /***
     * get x of vector
     * @return x of vector
     */
    public double getX() {
        return x;
    }

    /***
     * get y of vector
     * @return y of vector
     */
    public double getY() {
        return y;
    }

}
