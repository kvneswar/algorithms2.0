package org.example.dynamicprogramming.tabulation;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        fibonacci.v1();

        System.out.println("\n");

        fibonacci.v2();
    }

    private void v1() {
        long[] fibSeries = new long[51];

        fibSeries[0] = 0;
        fibSeries[1] = 1;

        for (int i = 2; i <= 50; i++) {
            fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
        }

        for (long number : fibSeries) {
            System.out.print(number + ", ");
        }
    }

    private void v2() {
        int[] fibSeries = new int[3];

        fibSeries[0] = 0;
        fibSeries[1] = 1;

        for (int i = 2; i <= 6; i++) {
            fibSeries[i % 3] = fibSeries[(i - 1) % 3] + fibSeries[(i - 2) % 3];

            System.out.print(fibSeries[i % 3] + ", ");
        }

    }
}
