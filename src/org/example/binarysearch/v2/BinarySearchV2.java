package org.example.binarysearch.v2;

public class BinarySearchV2 {
    private TreeNodeV2 root;

    public BinarySearchV2() {
        this.root = new TreeNodeV2(10);
    }

    public static void main(String[] args) {
        BinarySearchV2 binarySearch = new BinarySearchV2();

        /*binarySearch.insertUsingRecursion(binarySearch.root, 11);
        binarySearch.insertUsingRecursion(binarySearch.root, 15);
        binarySearch.insertUsingRecursion(binarySearch.root, 20);*/

        binarySearch.insertUsingIter(5);
        binarySearch.insertUsingIter(15);
        binarySearch.insertUsingIter(20);

        /*System.out.println(binarySearch.findUsingRecursion(binarySearch.root, 10));
        System.out.println(binarySearch.findUsingRecursion(binarySearch.root, 100));
        System.out.println(binarySearch.findUsingIteration(10));
        System.out.println(binarySearch.findUsingIteration(100));*/

        binarySearch.delete(binarySearch.root, binarySearch.root, 5);

        System.out.println(binarySearch.findUsingRecursion(binarySearch.root, 5));

        System.out.println(binarySearch.findUsingRecursion(binarySearch.root, 10));

        binarySearch.delete(binarySearch.root, binarySearch.root, 15);

        System.out.println(binarySearch.findUsingRecursion(binarySearch.root, 15));
        System.out.println(binarySearch.findUsingRecursion(binarySearch.root, 20));
    }

    private void insertUsingRecursion(TreeNodeV2 treeNode, int data) {
        if (data < treeNode.getData() && treeNode.getLeftNode() != null) {
            insertUsingRecursion(treeNode.getLeftNode(), data);
        } else if (treeNode.getRightNode() != null) {
            insertUsingRecursion(treeNode.getRightNode(), data);
        } else {
            if (data < treeNode.getData()) {
                treeNode.setLeftNode(new TreeNodeV2(data));
            } else {
                treeNode.setRightNode(new TreeNodeV2(data));
            }
        }
    }

    private void insertUsingIter(int data) {
        TreeNodeV2 currentNode = this.root;

        while (currentNode != null) {
            if (data < currentNode.getData() && currentNode.getLeftNode() != null) {
                currentNode = currentNode.getLeftNode();
            } else if (currentNode.getRightNode() != null) {
                currentNode = currentNode.getRightNode();
            } else {
                if (data < currentNode.getData()) {
                    currentNode.setLeftNode(new TreeNodeV2(data));
                } else {
                    currentNode.setRightNode(new TreeNodeV2(data));
                }

                break;
            }
        }
    }

    private TreeNodeV2 findUsingRecursion(TreeNodeV2 treeNode, int data) {
        if (treeNode == null) {
            return null;
        }

        if (data == treeNode.getData()) {
            return treeNode;
        }
        if (data < treeNode.getData() && treeNode.getLeftNode() != null) {
            return findUsingRecursion(treeNode.getLeftNode(), data);
        } else if (treeNode.getRightNode() != null) {
            return findUsingRecursion(treeNode.getRightNode(), data);
        }

        return null;
    }

    private TreeNodeV2 findUsingIteration(int data) {
        TreeNodeV2 currentNode = this.root;

        while (currentNode != null) {
            if (data == currentNode.getData()) {
                return currentNode;
            } else if (data < currentNode.getData() && currentNode.getLeftNode() != null) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }

        return null;
    }

    private void delete(TreeNodeV2 parentNode, TreeNodeV2 currentNode, int data) {
        if (data == currentNode.getData()) {
            if (currentNode == root) {
                root = null;

                return;
            }

            if (data < parentNode.getData()) {
                if (currentNode.getRightNode() != null) {
                    parentNode.setLeftNode(currentNode.getRightNode());
                } else {
                    parentNode.setLeftNode(currentNode.getLeftNode());
                }
            } else {
                if (currentNode.getRightNode() != null) {
                    parentNode.setRightNode(currentNode.getRightNode());
                } else {
                    parentNode.setRightNode(currentNode.getLeftNode());
                }
            }
        } else if (data < currentNode.getData() && currentNode.getLeftNode() != null) {
            delete(currentNode, currentNode.getLeftNode(), data);
        } else if (currentNode.getRightNode() != null) {
            delete(currentNode, currentNode.getRightNode(), data);
        }
    }


}
