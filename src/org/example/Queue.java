package org.example;

public class Queue {

    private final Integer[] queue;

    private int top;

    public Queue(int size) {
        queue = new Integer[size];
    }

    public void enqueue(int data) {
        top++;

        queue[queue.length - top] = data;
    }

    public int deque() {
        int data = queue[queue.length - 1];

        int temp = queue.length - 1;

        while (temp > 0) {
            queue[temp] = queue[temp - 1];

            temp--;
        }

        top--;

        return data;
    }

}
