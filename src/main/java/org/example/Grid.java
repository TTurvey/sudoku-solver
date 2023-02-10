package org.example;

public class Grid {

    private final int[][] squares;

    public Grid(int[][] input) {
        if (input == null) {
            throw new NullPointerException();
        }
        if (input.length != 9) {
            throw new IllegalArgumentException
                    ("input array must be 9x9");
        }
        this.squares = input;
    }

    public int getSize() {
        return squares.length;
    }

    public boolean isInRow(int row, int number){
        for(int i = 0; i < getSize(); i++){
            if(squares[row][i] == number){
                return true;
            }
        }
        return false;
    }

}