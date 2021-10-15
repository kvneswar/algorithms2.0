package org.example.graph;

public class IslandCount {
    public static void main(String[] args) {
        IslandCount islandCount = new IslandCount();

        islandCount.islandCount(buildGrid());
    }

    private static char[][] buildGrid() {
        return new char[][]{
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}};
    }

    private void islandCount(char[][] grid) {
        boolean[][] visitors = new boolean[6][5];

        int minIsland = 100;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int count = bfs(grid, row, column, visitors, 0);

                if (count != 0 && count < minIsland) {
                    minIsland = count;
                }
            }
        }

        System.out.println("TotalIslands: " + minIsland);
    }

    private int bfs(char[][] grid, int row, int column, boolean[][] visitors, int count) {
        if (!isIndexWithInTheRange(grid, row, column)) {
            return count;
        }

        if (grid[row][column] == 'W' || visitors[row][column]) {
            return count;
        }

        count += 1;

        visitors[row][column] = true;

        count = bfs(grid, row - 1, column, visitors, count);
        count = bfs(grid, row + 1, column, visitors, count);
        count = bfs(grid, row, column - 1, visitors, count);
        count = bfs(grid, row, column + 1, visitors, count);

        return count;
    }

    private boolean isIndexWithInTheRange(char[][] grid, int newRowIndex, int newColumnIndex) {
        return (newRowIndex >= 0 && newRowIndex < grid.length)
                && (newColumnIndex >= 0 && newColumnIndex < grid.length-1);
    }
}
