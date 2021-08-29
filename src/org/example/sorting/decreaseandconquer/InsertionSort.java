package org.example.sorting.decreaseandconquer;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 9, 5};

        for (int outerLoopCounter = 1; outerLoopCounter < numbers.length; outerLoopCounter++) {
            int innerLoopCounter = outerLoopCounter;

            int value = numbers[innerLoopCounter];

            while (innerLoopCounter >= 1 && numbers[innerLoopCounter - 1] > value) {
                numbers[innerLoopCounter] = numbers[innerLoopCounter - 1];

                innerLoopCounter--;
            }

            numbers[innerLoopCounter] = value;
        }

        for (int number : numbers) {
            System.out.print(number + ",");
        }
    }
}
