package org.example;

import java.util.Arrays;

public class Grid {

    private int[][] squares;

    public Grid() {
        this.squares = new int[9][9];
    }

    public int getSize() {
        return squares.length;
    }
}
