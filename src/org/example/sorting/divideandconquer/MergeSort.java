package org.example.sorting.divideandconquer;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {6, 6, 3, 8, 1, 5, 2, 7};

        MergeSort mergeSort = new MergeSort();

        numbers = mergeSort.mergeSort(numbers);

        for (int number : numbers) {
            System.out.println(number + ", ");
        }
    }

    private int[] mergeSort(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        }

        int[] left = mergeSort(Arrays.copyOfRange(numbers, 0, numbers.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        int[] result = new int[left.length + right.length];

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length
                    && left[leftPointer] <= right[rightPointer]) {
                result[resultPointer] = left[leftPointer];

                leftPointer++;
                resultPointer++;
            } else if (rightPointer < right.length) {
                result[resultPointer] = right[rightPointer];

                rightPointer++;
                resultPointer++;
            } else {
                result[resultPointer] = left[leftPointer];

                leftPointer++;
                resultPointer++;
            }
        }

        return result;
    }
}
