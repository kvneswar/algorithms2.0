package org.example;

public class LinkedList<T> {
    private Node<T> head;

    public void insert(T data){
        Node<T> newNode = new Node<>(data);

        newNode.setNextNode(this.head);

        this.head = newNode;
    }

    @Override
    public String toString() {
        Node<T> currentNode = this.head;

        StringBuilder stringBuilder = new StringBuilder();

        while (currentNode != null){
            stringBuilder.append(currentNode.getData()).append(" ");

            currentNode = currentNode.getNextNode();
        }

        return stringBuilder.toString();
    }
}

class Node<T> {
    private final T data;

    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
