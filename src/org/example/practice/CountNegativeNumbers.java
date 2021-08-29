package org.example.practice;

public class CountNegativeNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        new CountNegativeNumbers().binarySearch(numbers, 0, numbers.length - 1, 10);
    }

    private void binarySearch(int[] numbers, int start, int end, int find) {
        int mid = (end - start) / 2;

        if (find == numbers[mid]) {
            System.out.println("Found");
        } else if (find < numbers[mid]) {
            binarySearch(numbers, 0, end - mid - 1, find);
        } else {
            binarySearch(numbers, end - mid, end, find);
        }
    }
}
