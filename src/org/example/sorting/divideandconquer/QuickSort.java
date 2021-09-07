package org.example.sorting.divideandconquer;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {5, 7, 6, 3, 1, 2, 4};

        QuickSort quickSort = new QuickSort();

        quickSort.quickSort(numbers);

        for (int number : numbers) {
            System.out.print(number + ", ");
        }
    }

    private void quickSort(int[] numbers) {
        if (numbers.length <= 1) {
            return;
        }

        int pivot = numbers[0];

        int leftPointer = 0;
        int rightPointer = 0;

        while (rightPointer < numbers.length) {
            rightPointer++;

            if (rightPointer + 1 < numbers.length && numbers[rightPointer] < pivot) {
                leftPointer = leftPointer++;

                int tmp = numbers[leftPointer];

                numbers[leftPointer] = numbers[rightPointer];
                numbers[rightPointer] = tmp;
            }
        }

        numbers[leftPointer] = pivot;

        quickSort(Arrays.copyOfRange(numbers, 0, numbers.length / 2));
        quickSort(Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length));
    }
}
