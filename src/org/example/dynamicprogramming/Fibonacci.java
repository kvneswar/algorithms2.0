package org.example.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        Map<Integer, Integer> memo = new HashMap<>();

        memo.put(0, 0);
        memo.put(1, 1);

        Fibonacci fibonacci = new Fibonacci();

        System.out.println("fib(0): " + fibonacci.fib(0, memo));
        System.out.println("fib(1): " + fibonacci.fib(1, memo));
        System.out.println("fib(2): " + fibonacci.fib(2, memo));
        System.out.println("fib(3): " + fibonacci.fib(3, memo));
        System.out.println("fib(4): " + fibonacci.fib(4, memo));
        System.out.println("fib(5): " + fibonacci.fib(5, memo));
        System.out.println("fib(6): " + fibonacci.fib(6));
        System.out.println("fib(7): " + fibonacci.fib(7));
    }

    /**
     * TOP DOWN APPROACH
     * -Memoization
     */
    private int fib(int number, Map<Integer, Integer> memo) {
        if (memo.get(number) != null) {
            return memo.get(number);
        }

        int result = fib(number - 1, memo) + fib(number - 2, memo);

        memo.put(number, result);

        return result;
    }

    /**
     * BOTTOM DOWN APPROACH
     * - Directed acyclic graph
     * - Dependency Graph
     */

    private int fib(int number) {
        /*int[] fibSeries = new int[number + 1];

        fibSeries[0] = 0;
        fibSeries[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
        }

        return fibSeries[number];*/

        int[] fibSeries = new int[3];

        fibSeries[0] = 0;
        fibSeries[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibSeries[i % 3] = fibSeries[(i - 1) % 3] + fibSeries[(i - 2) % 3];
        }

        return fibSeries[number % 3];
    }


}
