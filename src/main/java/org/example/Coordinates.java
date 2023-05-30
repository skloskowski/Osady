package org.example;

import java.util.List;
import java.util.Random;

public class Coordinates {

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    static public boolean equals(Coordinates cords1, Coordinates cords2){
        if (cords1.x == cords2.x && cords1.y == cords2.y) return true;
        return false;
    }

    public boolean alreadyOccupied(List<Coordinates> spaceOccupied){

        for (Coordinates cords : spaceOccupied){
            if (Coordinates.equals(cords, new Coordinates(this.x, this.y))) return true;
        }

        return false;
    }

    static public Coordinates randomCoordinates(){
        Random rand = new Random();
        Coordinates randomCords = new Coordinates(rand.nextInt(MapCreation.size.x), rand.nextInt(MapCreation.size.y));
        return randomCords;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
