package org.example.dynamicprogramming.tabulation;

public class GridNavigator {
    public static void main(String[] args) {
        int[][] grid = new int[4][4];

        grid[1][1] = 1;

        for (int rowIndex = 1; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 1; columnIndex < grid[rowIndex].length; columnIndex++) {
                if(rowIndex == 1 && columnIndex == 1){
                    continue;
                }

                grid[rowIndex][columnIndex] = grid[rowIndex][columnIndex - 1] + grid[rowIndex - 1][columnIndex];
            }
        }

        System.out.println(grid[3][3]);
    }
}
