package org.example.heap;

public class Heap {

    private Node root;

    public void insert(Node node, int data) {
        if (node.getLeftNode() == null) {
            node.setLeftNode(new Node(data));
        } else if (node.getRightNode() == null) {
            node.setRightNode(new Node(data));
        } else if (node.getLeftNode() != null) {
            insert(node.getLeftNode(), data);
        } else if (node.getRightNode() != null) {
            insert(node.getRightNode(), data);
        }
    }
}
