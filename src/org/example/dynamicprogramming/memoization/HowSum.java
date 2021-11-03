package org.example.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        HowSum howSum = new HowSum();

        System.out.println(howSum.howSum(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(howSum.howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(howSum.howSum(7, new int[]{2, 4}, new HashMap<>()));
        System.out.println(howSum.howSum(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(howSum.howSum(300, new int[]{7, 14}, new HashMap<>()));
        System.out.println(howSum.howSum(0, new int[]{1, 2, 3}, new HashMap<>()));
    }

    private List<Integer> howSum(int target, int[] numbers, Map<Integer, List<Integer>> memo) {
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        for (int number : numbers) {
            int newNode = target - number;

            List<Integer> resultSlate = howSum(newNode, numbers, memo);

            if (resultSlate != null) {
                resultSlate.add(number);

                memo.put(newNode, resultSlate);

                return memo.get(newNode);
            }
        }

        memo.put(target, null);

        return memo.get(target);
    }
}
