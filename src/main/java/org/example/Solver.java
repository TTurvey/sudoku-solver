package org.example;

public class Solver {

    public static boolean execute(Grid grid){
        int size = grid.getSize();
        int[][] squares = grid.getSquares();

        for(int row = 0; row < size; row++){
            for(int column = 0; column < size; column++){
                if(squares[row][column] == 0){
                    for(int numberToTry = 1; numberToTry <= size; numberToTry++){
                        if(grid.checkIfPossible(row, column, numberToTry)){
                            grid.putNumber(row, column, numberToTry);
                            if (execute(grid)){
                                return true;
                            } else {
                                grid.putNumber(row, column, 0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
