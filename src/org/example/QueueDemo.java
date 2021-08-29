package org.example;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());

        queue.enqueue(50);
        System.out.println(queue.deque());

    }
}
