package org.example.recursion;

public class RecursionExample {
    public static void main(String[] args) {
        RecursionExample recursionExample = new RecursionExample();

        System.out.println("3!: " + recursionExample.factorial(3));
        System.out.println("3 ^ 3: " + recursionExample.raiseToThePower(3, 3));
    }

    private int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    private int raiseToThePower(int n, int power) {
        if (power == 0) {
            return 1;
        } else {
            return n * raiseToThePower(n, power - 1);
        }
    }
}
