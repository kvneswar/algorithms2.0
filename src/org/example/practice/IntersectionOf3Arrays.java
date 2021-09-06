package org.example.practice;

public class IntersectionOf3Arrays {
    public static void main(String[] args) {
        IntersectionOf3Arrays intersectionOf3Arrays = new IntersectionOf3Arrays();

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 5, 7, 9};
        int[] array3 = {1, 3, 4, 5, 8};

        //intersectionOf3Arrays.intersectionOf2ArraysBruteForce(array1, array2);
        int[] result = intersectionOf3Arrays.intersectionOf2Arrays2PointerApproach(array1, array2);

        result = intersectionOf3Arrays.intersectionOf2Arrays2PointerApproach(result, array3);

        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    private void intersectionOf2ArraysBruteForce(int[] array1, int[] array2) {
        for (int outerLoopCounter = 0; outerLoopCounter < array1.length; outerLoopCounter++) {
            for (int innerLoopCounter = 0; innerLoopCounter < array2.length; innerLoopCounter++) {
                if (array1[outerLoopCounter] == array2[innerLoopCounter]) {
                    System.out.print(array1[outerLoopCounter]);
                }
            }
        }
    }

    private int[] intersectionOf2Arrays2PointerApproach(int[] array1, int[] array2) {
        int array1Counter = 0;
        int array2Counter = 0;

        int resultArrayLength = array1.length > array2.length ? array1.length : array2.length;

        int[] result = new int[resultArrayLength];

        int resultPointer = 0;

        while (array1Counter < array1.length && array2Counter < array2.length) {
            if (array1[array1Counter] < array2[array2Counter]) {
                array1Counter++;
            } else if (array1[array1Counter] > array2[array2Counter]) {
                array2Counter++;
            } else {
                if (resultPointer == 0 || (resultPointer >= 1 && result[resultPointer - 1] != array1[array1Counter])) {
                    result[resultPointer] = array1[array1Counter];

                    resultPointer++;
                }

                array1Counter++;
                array2Counter++;
            }
        }

        return result;
    }
}
