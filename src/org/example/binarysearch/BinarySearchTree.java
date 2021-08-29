package org.example.binarysearch;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = new TreeNode(10);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert();

        System.out.println(binarySearchTree.find(5).getData());
        binarySearchTree.delete(5);
        System.out.println(binarySearchTree.find(5));
        System.out.println(binarySearchTree.find(15).getData());
        binarySearchTree.delete(15);
        System.out.println(binarySearchTree.find(15));
        System.out.println(binarySearchTree.find(10).getData());
        binarySearchTree.delete(10);
        System.out.println(binarySearchTree.find(10));
    }

    public void insert() {
        this.root.insert(5);
        this.root.insert(15);
    }

    public TreeNode findData(int data) {
        if (root != null) {
            return root.find(data);
        }

        return null;
    }

    public TreeNode find(int data) {
        if (root != null) {
            TreeNode current = root;

            while (current != null) {
                if (current.getData() == data) {
                    return current;
                } else {
                    if (data < current.getData()) {
                        current = current.getLeftNode();
                    } else {
                        current = current.getRightNode();
                    }
                }
            }
        }

        return null;
    }

    public void delete(int data) {
        TreeNode currentNode = this.root;
        TreeNode parentNode = this.root;

        while (currentNode != null) {
            if (data < currentNode.getData() && currentNode.getLeftNode() != null) {
                parentNode = currentNode;

                currentNode = currentNode.getLeftNode();
            } else if (data > currentNode.getData() && currentNode.getRightNode() != null) {
                parentNode = currentNode;

                currentNode = currentNode.getRightNode();
            } else {
                if (currentNode == this.root) {
                    root = null;
                }

                if (data < parentNode.getData()) {
                    parentNode.setLeftNode(currentNode.getLeftNode());
                } else {
                    parentNode.setRightNode(currentNode.getLeftNode());
                }

                break;
            }
        }
    }
}
