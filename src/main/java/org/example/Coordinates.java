package org.example;

import java.util.List;
import java.util.Random;

public class Coordinates {

    /***
     * set x of coordinate to x
     * @param x x coordinate to set to
     */
    public void setX(int x) {
        this.x = x;
    }

    /***
     * set y of coordinate to y
     * @param y y coordinate to set to
     */
    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    /***
     * checks if 2 coordinates are equal
     * @param cords1 first coordinate
     * @param cords2 second coordinate
     * @return true if coordinates are equal otherwise false
     */
    static public boolean equals(Coordinates cords1, Coordinates cords2){
        if (cords1.x == cords2.x && cords1.y == cords2.y) return true;
        return false;
    }

    /***
     * checks if the given coordinate is occupied by other instance in list spaceOccupied
     * @param spaceOccupied list of occupied spaces
     * @return true if space is occupied otherwise false
     */
    public boolean alreadyOccupied(List<Coordinates> spaceOccupied){

        for (Coordinates cords : spaceOccupied){
            if (Coordinates.equals(cords, new Coordinates(this.x, this.y))) return true;
        }

        return false;
    }

    /***
     * get coordinates randomly between 0-mapSize
     * @return random coordinates
     */
    static public Coordinates randomCoordinates(){
        Random rand = new Random();
        Coordinates randomCords = new Coordinates(rand.nextInt(MapCreation.size.x), rand.nextInt(MapCreation.size.y));
        return randomCords;
    }

    /***
     *
     * @return x of coordinate
     */
    public int getX() {
        return x;
    }

    /***
     *
     * @return y of coordinate
     */
    public int getY() {
        return y;
    }
}
