package org.example.sorting.bruteforce;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        selectionSort.version1(new int[]{8, 5, 9, 6});
        selectionSort.version2(new int[]{8, 5, 9, 6});
    }

    private void version1(int[] numbers) {
        for (int outerLoopCounter = 0; outerLoopCounter < numbers.length; outerLoopCounter++) {
            int position = outerLoopCounter;

            for (int innerLoopCounter = outerLoopCounter + 1; innerLoopCounter < numbers.length; innerLoopCounter++) {
                if (numbers[innerLoopCounter] < numbers[position]) {
                    position = innerLoopCounter;
                }
            }

            if (position != outerLoopCounter) {
                int tmp = numbers[position];

                numbers[position] = numbers[outerLoopCounter];
                numbers[outerLoopCounter] = tmp;
            }
        }

        for (int number : numbers) {
            System.out.print(number + ",");
        }
    }

    private void version2(int[] numbers) {
        for (int outerLoopCounter = 0; outerLoopCounter < numbers.length; outerLoopCounter++) {
            for (int innerLoopCounter = outerLoopCounter + 1; innerLoopCounter < numbers.length; innerLoopCounter++) {
                if (numbers[innerLoopCounter] < numbers[outerLoopCounter]) {
                    int tmp = numbers[outerLoopCounter];

                    numbers[outerLoopCounter] = numbers[innerLoopCounter];
                    numbers[innerLoopCounter] = tmp;
                }
            }
        }

        for (int number : numbers) {
            System.out.print(number + ",");
        }
    }
}
