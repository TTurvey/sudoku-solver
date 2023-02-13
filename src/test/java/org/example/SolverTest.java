package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    private Grid grid_SuperEasy;
    private Grid grid_SuperEasy_Solution;

    @BeforeEach
    public void init() throws IOException {
        int[][] input_SuperEasy = Read2DArrayFromFile.read("src/test/java/input-SuperEasy.txt");
        this.grid_SuperEasy = new Grid(input_SuperEasy);

        int[][] output_SuperEasy = Read2DArrayFromFile.read("src/test/java/output-SuperEasySolution.txt");
        this.grid_SuperEasy_Solution = new Grid(output_SuperEasy);
    }

    @Test
    public void
    should_solve_the_SuperEasy_grid(){
        Solver.execute(grid_SuperEasy);
        int[][] solution = grid_SuperEasy_Solution.getSquares();
        int[][] actual = grid_SuperEasy.getSquares();
        assertArrayEquals(solution, actual);
    }

}
