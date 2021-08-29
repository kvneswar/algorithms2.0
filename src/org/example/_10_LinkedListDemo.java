package org.example;

public class _10_LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.insert(10);
        linkedList.insert(20);

        System.out.println(linkedList);

        DoublyEndedLinkedList<Integer> doublyEndedLinkedList = new DoublyEndedLinkedList<>();

        doublyEndedLinkedList.insertAtHead(10);
        doublyEndedLinkedList.insertAtHead(20);

        System.out.println(doublyEndedLinkedList);

        doublyEndedLinkedList.insertAtTail(30);
        doublyEndedLinkedList.insertAtTail(40);
        doublyEndedLinkedList.insertAtTail(50);
        doublyEndedLinkedList.insertAtHead(5);

        System.out.println(doublyEndedLinkedList);
    }
}
