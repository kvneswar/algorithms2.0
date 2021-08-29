package org.example;

public class Stack {

    private final Integer[] stack;

    private int top = -1;

    public Stack(int size) {
        stack = new Integer[size];
    }

    public void push(int data) {
        top++;

        stack[top] = data;
    }

    public int pop() {
        if (top >= 0) {
            int data = stack[top];

            stack[top] = null;

            top--;

            return data;
        }

        throw new RuntimeException("Empty stack exception");
    }
}
