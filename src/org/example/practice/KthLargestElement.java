package org.example.practice;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] numbers = {8, 5, 9, 2};

        KthLargestElement kthLargestElement = new KthLargestElement();

        //kthLargestElement.findUsingSelectionSort(numbers, 4);
        //kthLargestElement.findUsingInsertionSort(numbers, 4);
        kthLargestElement.findUsingBubbleSort(numbers, 1);
    }

    private void findUsingSelectionSort(int[] numbers, int position) {
        for (int outerLoopCounter = 0; outerLoopCounter <= numbers.length - position; outerLoopCounter++) {
            int smallestPosition = outerLoopCounter;

            for (int innerLoopCounter = outerLoopCounter; innerLoopCounter < numbers.length; innerLoopCounter++) {
                if (numbers[smallestPosition] > numbers[innerLoopCounter]) {
                    smallestPosition = innerLoopCounter;
                }
            }

            if (smallestPosition != outerLoopCounter) {
                int temp = numbers[outerLoopCounter];

                numbers[outerLoopCounter] = numbers[smallestPosition];
                numbers[smallestPosition] = temp;
            }
        }

        System.out.println(numbers[numbers.length - position]);
    }

    //Not efficient
    private void findUsingInsertionSort(int[] numbers, int position) {
        for (int outerLoopCounter = 1; outerLoopCounter < numbers.length - position; outerLoopCounter++) {
            int temp = numbers[outerLoopCounter];

            int innerLoopCounter = outerLoopCounter;

            int minimumPosition = outerLoopCounter;

            while (innerLoopCounter >= 0) {
                if (temp < numbers[innerLoopCounter]) {
                    numbers[innerLoopCounter + 1] = numbers[innerLoopCounter];

                    minimumPosition--;
                }

                innerLoopCounter--;
            }

            numbers[minimumPosition] = temp;
        }

        for (int number : numbers) {
            System.out.println(number + ", ");
        }
    }

    private void findUsingBubbleSort(int[] numbers, int position) {
        for (int outerLoopCounter = 0; outerLoopCounter < numbers.length; outerLoopCounter++) {
            for (int innerLoopCounter = 0; innerLoopCounter < numbers.length - outerLoopCounter - 1; innerLoopCounter++) {
                if (numbers[innerLoopCounter] > numbers[innerLoopCounter + 1]) {
                    int temp = numbers[innerLoopCounter + 1];

                    numbers[innerLoopCounter + 1] = numbers[innerLoopCounter];
                    numbers[innerLoopCounter] = temp;
                }
            }

            if (outerLoopCounter + 1 == position) {
                break;
            }
        }

        System.out.println(numbers[numbers.length - position]);
    }

    //TODO
    private void findUsingHeapSort(int[] numbers, int position) {

    }
}
