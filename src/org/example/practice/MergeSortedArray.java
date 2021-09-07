package org.example.practice;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};

        int array1ActualLength = 3;
        int array2ActualLength = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        //mergeSortedArray.mergeUsing2PointerPass(array1, array1ActualLength, array2, array2ActualLength);

        array1 = mergeSortedArray.mergeUsing2PointerPassWithAuxMemory(array1, array1ActualLength, array2, array2ActualLength);

        for (int i : array1) {
            System.out.print(i + ", ");
        }
    }

    private void mergeUsing2PointerPass(int[] array1, int array1ActualLength, int[] array2, int array2ActualLength) {
        int array1Pointer = 0;
        int array2Pointer = 0;

        while (array1Pointer < array1.length && array2Pointer < array2.length) {
            if (array1[array1Pointer] >= array2[array2Pointer]) {
                int tempCounter = array1.length - 2;

                while (tempCounter >= array1Pointer) {
                    array1[tempCounter + 1] = array1[tempCounter];

                    tempCounter--;
                }

                array1[array1Pointer] = array2[array2Pointer];

                array1Pointer++;
                array2Pointer++;
            } else {
                array1Pointer++;
            }
        }

        while (array2Pointer < array2.length) {
            array1[array1ActualLength + array2Pointer] = array2[array2Pointer];

            array1Pointer++;
            array2Pointer++;

        }
    }

    private int[] mergeUsing2PointerPassWithAuxMemory(int[] array1, int array1ActualLength, int[] array2, int array2ActualLength) {
        int array1Pointer = 0;
        int array2Pointer = 0;
        int resultPointer = 0;

        int[] result = new int[array1.length];

        while (array1Pointer < array1ActualLength && array2Pointer < array2ActualLength) {
            if (array1[array1Pointer] < array2[array2Pointer]) {
                result[resultPointer] = array1[array1Pointer];

                resultPointer++;
                array1Pointer++;
            } else if (array1[array1Pointer] > array2[array2Pointer]) {
                result[resultPointer] = array2[array2Pointer];

                resultPointer++;
                array2Pointer++;
            } else {
                result[resultPointer] = array1[array1Pointer];

                resultPointer++;
                array1Pointer++;

                result[resultPointer] = array2[array2Pointer];

                resultPointer++;
                array2Pointer++;
            }
        }

        while (array2Pointer < array2ActualLength) {
            result[resultPointer] = array2[array2Pointer];

            resultPointer++;
            array2Pointer++;
        }

        return result;
    }
}
