package org.example.practice;

public class SumTwoIntegers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 7, 11, 13};

        int target = 10;

        int[] result = null;

        for (int i = 0; i < numbers.length; i++) {
            int tempTarget = target - numbers[i];

            int[] tempResult = findSumOfTwoNumbers(numbers, i + 1, tempTarget);

            if (tempResult != null) {
                result = new int[3];

                result[0] = i;
                result[1] = tempResult[0];
                result[2] = tempResult[1];
            }
        }

        if (result != null) {
            for (int index : result) {
                System.out.println(index);
            }
        }
    }

    private static int[] findSumOfTwoNumbers(int[] numbers, int startIndex, int target) {
        int endIndex = numbers.length - 1;


        while (startIndex < endIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];

            if (target == sum) {
                int[] result = new int[2];

                result[0] = startIndex;
                result[1] = endIndex;

                return result;
            } else if (sum > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }

        return null;
    }
}
