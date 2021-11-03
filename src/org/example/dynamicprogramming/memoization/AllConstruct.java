package org.example.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * To be fixed
*/
public class AllConstruct {
    public static void main(String[] args) {
        AllConstruct allConstruct = new AllConstruct();

        System.out.println(allConstruct.allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef"), new HashMap<>()));

    }

    private List<List<String>> allConstruct(String target, List<String> wordBank, Map<String, List<List<String>>> memo) {
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        if (target.length() == 0) {
            List<List<String>> result = new ArrayList<>();

            result.add(new ArrayList<>());

            return result;
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String newNode = target.substring(word.length());

                List<List<String>> partialResult = allConstruct(newNode, wordBank, memo);

                if (partialResult != null) {
                    for (List<String> strings : partialResult) {
                        strings.add(word);

                        result.add(strings);
                    }
                }
            }
        }

        memo.put(target, result);

        return result;
    }
}
