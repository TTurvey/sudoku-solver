package org.example;

public class Printer {

    public String print(int[][] arr){
        StringBuilder output = new StringBuilder();
        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + " ");
                output.append(y);
                output.append(" ");
            }
            System.out.println();
        }
        return output.toString();
    }
}
