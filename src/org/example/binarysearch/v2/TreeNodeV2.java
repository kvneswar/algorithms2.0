package org.example.binarysearch.v2;

public class TreeNodeV2 {
    private int data;

    private TreeNodeV2 leftNode;
    private TreeNodeV2 rightNode;

    public TreeNodeV2(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNodeV2 getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNodeV2 leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNodeV2 getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNodeV2 rightNode) {
        this.rightNode = rightNode;
    }
}
