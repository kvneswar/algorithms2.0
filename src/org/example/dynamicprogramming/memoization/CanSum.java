package org.example.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        CanSum canSum = new CanSum();

        System.out.println(canSum.canSum(new int[]{5, 3, 4, 7}, 7, new HashMap<>()));
        System.out.println(canSum.canSum(new int[]{5, 3, 4, 7}, 2, new HashMap<>()));
        System.out.println(canSum.canSum(new int[]{7, 14}, 300, new HashMap<>()));
    }

    private boolean canSum(int[] numbers, int target, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int number : numbers) {
            int newNode = target - number;

            boolean result = canSum(numbers, newNode, memo);

            if (result) {
                memo.put(newNode, true);

                return memo.get(newNode);
            }
        }

        memo.put(target, false);

        return memo.get(target);
    }
}
