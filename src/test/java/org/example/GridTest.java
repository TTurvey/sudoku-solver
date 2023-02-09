package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    public void should_initialize_with_9_by_9(){
        Grid grid = new Grid();
        assertEquals(9, grid.getSize());
    }

}
