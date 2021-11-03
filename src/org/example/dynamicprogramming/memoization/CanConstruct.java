package org.example.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();

        System.out.println(canConstruct.canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), new HashMap<>()));
        System.out.println(canConstruct.canConstruct("", List.of("ab", "abc", "cd", "def", "abcd"), new HashMap<>()));
        System.out.println(canConstruct.canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"), new HashMap<>()));
        System.out.println(canConstruct.canConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"), new HashMap<>()));
        System.out.println(canConstruct.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), new HashMap<>()));
    }

    private boolean canConstruct(String target, List<String> listOfWords, Map<String, Boolean> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        if(target.length() == 0){
            return true;
        }

        for (String word : listOfWords) {
            if(target.startsWith(word)){
                /*if(canConstruct(target.replaceFirst(word, ""), listOfWords)){
                    return true;
                }*/

                if(canConstruct(target.substring(word.length()), listOfWords, memo)){
                    memo.put(target.substring(word.length()), true);

                    return true;
                }
            }
        }

        memo.put(target, false);

        return false;
    }
}
