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

    public boolean isInColumn(int column, int number){
        for(int i = 0; i < getSize(); i++){
            if(squares[i][column] == number){
                return true;
            }
        }
        return false;
    }

    public boolean isInBox(int row, int column, int number) {
//        get the lowest index in the box ...0, 3 or 6.
        int r = row - row % 3;
        int c = column - column % 3;

//        iterate through the 3x3 box from the lowest index to index+3
        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(squares[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

}
