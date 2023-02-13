package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    private Grid grid_SuperEasy;
    private Grid grid_SuperEasy_Solution;
    private Solver solver;
    private final Printer printer = new Printer();

    @BeforeEach
    public void init() throws IOException {
        this.grid_SuperEasy = new Grid(read("src/test/java/input-SuperEasy.txt"));
        this.solver = new Solver();

        this.grid_SuperEasy_Solution = new Grid(read("src/test/java/output-SuperEasySolution.txt"));
    }

    @Test
    public void
    should_solve_the_SuperEasy_grid(){
        solver.execute(grid_SuperEasy);
        int[][] solution = grid_SuperEasy_Solution.getSquares();
        int[][] actual = grid_SuperEasy.getSquares();
        assertArrayEquals(solution, actual);
    }

    public int[][] read(String src) throws IOException {
        int[][] inputArray = new int[9][9];
        BufferedReader br = new BufferedReader(new FileReader(src));

        for (int i = 0; i < 9; i++) {
            String[] st = br.readLine().trim().split(" ");
            for (int j = 0; j < 9; j++) {
                inputArray[i][j] = Integer.parseInt(st[j]);
            }
        }
        return inputArray;
    }

}