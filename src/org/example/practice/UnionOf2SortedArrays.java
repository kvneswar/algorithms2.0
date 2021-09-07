package org.example.practice;

public class UnionOf2SortedArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 5, 7, 9};

        UnionOf2SortedArrays unionOf2SortedArrays = new UnionOf2SortedArrays();

        int[] result = unionOf2SortedArrays.unionOf2SortedArrays2PointerPass(array1, array2);

        for (int i : result) {
            System.out.println(i + ", ");
        }
    }

    private int[] unionOf2SortedArrays2PointerPass(int[] array1, int[] array2) {
        int array1Pointer = 0;
        int array2Pointer = 0;
        int resultPointer = 0;

        int[] result = new int[array1.length + array2.length];

        while (array1Pointer < array1.length && array2Pointer < array2.length) {
            if (array1[array1Pointer] < array2[array2Pointer]) {
                resultPointer = appendResult(result, resultPointer, array1[array1Pointer]);

                array1Pointer++;
            } else if (array1[array1Pointer] > array2[array2Pointer]) {
                resultPointer = appendResult(result, resultPointer, array2[array2Pointer]);

                array2Pointer++;
            } else {
                resultPointer = appendResult(result, resultPointer, array1[array1Pointer]);

                array1Pointer++;
                array2Pointer++;
            }
        }

        while (array1Pointer < array1.length) {
            resultPointer = appendResult(result, resultPointer, array1[array1Pointer]);

            array1Pointer++;
        }

        while (array2Pointer < array2.length) {
            resultPointer = appendResult(result, resultPointer, array2[array2Pointer]);

            array2Pointer++;
        }

        return result;
    }

    private int appendResult(int[] result, int resultPointer, int number) {
        if (resultPointer == 0 || (resultPointer > 0 && result[resultPointer - 1] != number)) {
            result[resultPointer] = number;

            resultPointer++;
        }

        return resultPointer;
    }

}
