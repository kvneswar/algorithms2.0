package org.example.recursion.basics;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<String> nameList = List.of("John Doe", "John Smith");

        Example example = new Example();

        //example.printName(nameList, 0);
        //System.out.println(example.raiseMoney(100000));
        //System.out.println(example.factorial(5));
        System.out.println(example.fibonacci(6, 0, 1));
    }

    private void printName(List<String> nameList, int index) {
        if (index == nameList.size() - 1) {
            //Do nothing
        } else {
            printName(nameList, index + 1);
        }

        System.out.println(nameList.get(index));
    }

    private int raiseMoney(int target) {
        if (target == 100) {
            return target;
        } else {
            int collectedMoney = 0;

            for (int i = 0; i < 10; i++) {
                collectedMoney += raiseMoney(target / 10);
            }

            return collectedMoney;
        }
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    private int fibonacci(int n, int b1, int b2) {
        if (n == 0) {
            return b1;
        }

        return fibonacci(n - 1, b2, b1 + b2);
    }
}
