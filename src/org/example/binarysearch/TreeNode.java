package org.example.binarysearch;

public class TreeNode {
    private final int data;

    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode find(int data) {
        if (data == this.data) {
            return this;
        }

        if (data < this.data && leftNode != null) {
            return leftNode.find(data);
        } else if (rightNode != null) {
            return rightNode.find(data);
        }

        return null;
    }

    public void insert(int data) {
        if (data < this.data) {
            if (leftNode != null) {
                leftNode.insert(data);
            } else {
                this.setLeftNode(new TreeNode(data));
            }
        } else {
            if (rightNode != null) {
                rightNode.insert(data);
            } else {
                this.setRightNode(new TreeNode(data));
            }
        }
    }

    /*public void delete(TreeNode parent, int data) {
        if (leftNode != null && data < leftNode.getData()) {
            leftNode.delete(this, data);
        } else if (rightNode != null && data > rightNode.getData()) {
            rightNode.delete(this, data);
        } else {
            if(leftNode != null){
                parent.setLeftNode(this.leftNode);
            }else{
                parent.setLeftNode(null);
            }
        }
    }*/
}
