package org.example;

public class Printer {

    public static String print(int[][] arr){
        StringBuilder output = new StringBuilder();
        String horizontalLine = "+---".repeat(9);

        output.append(horizontalLine);
        output.append("\n");

        for (int[] x : arr) {
            for (int y : x) {
                output.append("| ");
                output.append(y);
                output.append(" ");
            }
            output.append("\n");
            output.append(horizontalLine);
            output.append("\n");
        }
        return output.toString();
    }

}
