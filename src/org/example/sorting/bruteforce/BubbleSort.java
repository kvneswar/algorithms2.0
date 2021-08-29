package org.example.sorting.bruteforce;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {6, 9, 5, 7};

        for (int outerLoopCounter = 0; outerLoopCounter < numbers.length; outerLoopCounter++) {
            for (int innerLoopCounter = 0; innerLoopCounter < numbers.length - outerLoopCounter -1; innerLoopCounter++) {
                if (numbers[innerLoopCounter] > numbers[innerLoopCounter + 1]) {
                    int tmp = numbers[innerLoopCounter + 1];

                    numbers[innerLoopCounter + 1] = numbers[innerLoopCounter];
                    numbers[innerLoopCounter] = tmp;
                }
            }
        }

        for (int number : numbers) {
            System.out.print(number + ",");
        }
    }
}
