package org.example.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        BestSum bestSum = new BestSum();

        HashMap<Integer, List<Integer>> memo = new HashMap<>();

        System.out.println(bestSum.bestSum(7, new int[]{2, 3, 7}, memo));
    }

    private List<Integer> bestSum(int target, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        List<Integer> minResult = null;

        for (int number : numbers) {
            int newNode = target - number;

            List<Integer> result = bestSum(newNode, numbers, memo);

            if (result != null) {
                result.add(number);

                if (minResult == null || result.size() < minResult.size()) {
                    minResult = result;
                }
            }
        }

        memo.put(target, minResult);

        return minResult;
    }
}
