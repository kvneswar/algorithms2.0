package org.example.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        CountConstruct countConstruct = new CountConstruct();

        System.out.println(countConstruct.countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef"), new HashMap<>()));
        System.out.println(countConstruct.countConstruct("", List.of("ab", "abc", "cd", "def", "abcd"), new HashMap<>()));
        System.out.println(countConstruct.countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"), new HashMap<>()));
        System.out.println(countConstruct.countConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"), new HashMap<>()));
        System.out.println(countConstruct.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), new HashMap<>()));
    }

    private int countConstruct(String target, List<String> workBank, Map<String, Integer> memo) {
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        if (target.length() == 0) {
            return 1;
        }

        int count = 0;

        for (String word : workBank) {
            if (target.startsWith(word)) {
                int result = countConstruct(target.substring(word.length()), workBank, memo);

                count += result;
            }
        }

        memo.put(target, count);

        return count;
    }
}
