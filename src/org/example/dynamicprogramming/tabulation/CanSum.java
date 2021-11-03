package org.example.dynamicprogramming.tabulation;

public class CanSum {
    public static void main(String[] args) {
        int[] numbers = {2, 4};

        int target = 7;

        boolean[] result = new boolean[target+1];

        result[0] = true;

        for (int loopCounter = 0; loopCounter < result.length; loopCounter++) {
            if(result[loopCounter]){
                for (int number : numbers) {
                    int newResult = loopCounter + number;

                    if(newResult < result.length){
                        result[newResult] = true;
                    }
                }
            }
        }

        System.out.println(result[target]);
    }
}
