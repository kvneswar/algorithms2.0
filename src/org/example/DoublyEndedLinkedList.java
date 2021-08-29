package org.example;

public class DoublyEndedLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.setNextNode(this.head);

        this.head = newNode;

        if(this.tail == null){
            this.tail = new Node<>(null);

            this.head.setNextNode(this.tail);
        }
    }

    public void insertAtTail(T data){
        Node<T> newNode = new Node<>(data);

        tail.setNextNode(newNode);

        tail = newNode;
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
