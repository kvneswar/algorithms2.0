package org.example.dynamicprogramming.memoization;

public class ClimbTheStairs {
    public static void main(String[] args) {
        ClimbTheStairs climbTheStairs = new ClimbTheStairs();

        System.out.println("climbTheStairs: 3 = " + climbTheStairs.climb(3));
        System.out.println("climbTheStairs: 4 = " + climbTheStairs.climb(4));
    }

    private int climb(int steps) {
        int[] possibilities = new int[steps + 1];

        possibilities[1] = 1;
        possibilities[2] = 2;

        for(int i = 3; i <= steps; i++) {
            possibilities[i] = possibilities[i - 1] + possibilities[i - 2];
        }

        return possibilities[steps];
    }
}
