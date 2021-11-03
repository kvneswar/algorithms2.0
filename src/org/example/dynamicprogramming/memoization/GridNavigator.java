package org.example.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridNavigator {
    public static void main(String[] args) {
        GridNavigator gridNavigator = new GridNavigator();

        System.out.println(gridNavigator.navigate(3, 2, new HashMap<>()));
    }

    private int navigate(int m, int n, Map<String, Integer> memo) {
        String key = m + "_" + n;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        if (m == 0 || n == 0) {
            return 0;
        }

        memo.put(key, navigate(m - 1, n, memo) + navigate(m, n - 1, memo));

        return memo.get(key);
    }
}
