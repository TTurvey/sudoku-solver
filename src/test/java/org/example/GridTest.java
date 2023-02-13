package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private Grid grid_SuperEasy;

    @BeforeEach
    public void init() throws IOException {
        this.grid_SuperEasy = new Grid(read("src/test/java/input-SuperEasy.txt"));
    }

    @Test
    public void should_initialize_with_9_by_9(){
        assertEquals(9, grid_SuperEasy.getSize());
    }

    @Test
    public void should_throw_NullPointerException_if_null_input(){
        assertThrows(NullPointerException.class, ()-> new Grid(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 10})
    public void should_throw_IllegalArgumentException_if_input_array_is_not_size_9x9(int i) {
        int[][] arr = new int[i][i];
        assertThrows(IllegalArgumentException.class, ()-> new Grid(arr));
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 2", "2, 4", "3, 5", "4, 3", "5, 6", "6, 1", "7, 9", "8, 7", "8, 8"})
    public void should_return_true_if_number_is_in_row_already(int row, int number) {
        assertTrue(grid_SuperEasy.isInRow(row, number));
    }

    @ParameterizedTest
    @CsvSource({"0, 8", "1, 8", "2, 2", "3, 8", "4, 8", "5, 8", "6, 8", "7, 8", "8, 2", "8, 2"})
    public void should_return_false_if_number_is_not_in_row_already(int row, int number) {
        assertFalse(grid_SuperEasy.isInRow(row, number));
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 2", "2, 3", "3, 4", "4, 5", "5, 9", "6, 6", "7, 8", "8, 7"})
    public void should_return_true_if_number_is_in_column_already(int column, int number) {
        assertTrue(grid_SuperEasy.isInColumn(column, number));
    }

    @ParameterizedTest
    @CsvSource({"0, 2", "1, 9", "2, 1", "3, 8", "4, 7", "5, 6", "6, 5", "7, 4", "8, 3"})
    public void should_return_false_if_number_is_not_in_column_already(int column, int number) {
        assertFalse(grid_SuperEasy.isInColumn(column, number));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1",
            "0, 3, 2",
            "4, 1, 3",
            "0, 6, 4",
            "4, 3, 5",
            "4, 7, 9",
            "7, 0, 7",
            "8, 3, 6",
            "8, 8, 8"
    })
    public void should_return_true_if_number_is_in_3x3_box_already(int row, int column, int number) {
        assertTrue(grid_SuperEasy.isInBox(row,column, number));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 9",
            "0, 3, 3",
            "0, 6, 2",
            "4, 1, 1",
            "4, 3, 6",
            "4, 7, 7",
            "7, 0, 8",
            "8, 3, 4",
            "8, 8, 5"
    })
    public void should_return_false_if_number_is_not_in_3x3_box_already(int row, int column, int number) {
        assertFalse(grid_SuperEasy.isInBox(row,column, number));
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
