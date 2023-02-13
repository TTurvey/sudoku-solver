package org.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] input_SuperEasy = Read2DArrayFromFile.read("src/test/java/input-SuperEasy.txt");

//        Print the input to the terminal
        System.out.println(Printer.print(input_SuperEasy));

//        Pass the inpout into the Grid class
        Grid grid_SuperEasy = new Grid(input_SuperEasy);

//        Execute the solver with the grid as input
        Solver.execute(grid_SuperEasy);

        int[][] output_SuperEasy = grid_SuperEasy.getSquares();

//        Print the output to the terminal
        System.out.println(Printer.print(output_SuperEasy));

        int[][] solution_SuperEasy = Read2DArrayFromFile.read("src/test/java/output-SuperEasySolution.txt");

        System.out.println(Printer.print(solution_SuperEasy));
    }
}