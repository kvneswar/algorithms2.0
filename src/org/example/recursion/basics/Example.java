package org.example.recursion.basics;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<String> nameList = List.of("John Doe", "John Smith");

        Example example = new Example();

        //example.printName(nameList, 0);
        System.out.println(example.raiseMoney(100000));
    }

    private void printName(List<String> nameList, int index) {
        if (index == nameList.size() - 1) {
            //Do nothing
        } else {
            printName(nameList, index + 1);
        }

        System.out.println(nameList.get(index));
    }

    private int raiseMoney(int target) {
        if (target == 100) {
            return target;
        } else {
            int collectedMoney = 0;

            for (int i = 0; i < 10; i++) {
                collectedMoney += raiseMoney(target / 10);
            }

            return collectedMoney;
        }
    }
}
