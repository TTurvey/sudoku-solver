package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private Grid grid_SuperEasy;

    @Before
    public void init() throws IOException {
        this.grid_SuperEasy = new Grid(read("src/test/java/input-SuperEasy.txt"));
    }

    @Test
    public void should_initialize_with_9_by_9(){
        assertEquals(9, grid_SuperEasy.getSize());
    }

    @Test
    public void should_throw_NullPointerException_if_null_input(){
        assertThrows(NullPointerException.class, ()->{new Grid(null);});
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 10})
    public void should_throw_IllegalArgumentException_if_input_array_is_not_size_9x9(int i) throws Exception{
        int[][] arr = new int[i][i];
        assertThrows(IllegalArgumentException.class, ()->{new Grid(arr);});
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
