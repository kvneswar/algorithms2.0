package org.example.recursion;

public class RecursionExample {
    public static void main(String[] args) {
        System.out.println(new RecursionExample().factorial(3));
    }

    private int factorial(int n){
        if(n == 0)
            return 1;

        return n * factorial(n-1);
    }
}
