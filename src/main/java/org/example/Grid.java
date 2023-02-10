package org.example;

public class Grid {

    private final int[][] squares;

    public Grid(int[][] input) {
        this.squares = input;
    }

    public int getSize() {
        return squares.length;
    }
}
