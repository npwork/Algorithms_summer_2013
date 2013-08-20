package coursera_stanford_2013.week5;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private BSTNode rootNode;
    private int size;

    public void add(Integer key) {
        BSTNode nodeToAdd = new BSTNode(key);
        if (rootNode == null) {
            rootNode = nodeToAdd;
            size++;
            return;
        }

        BSTNode currentNode = rootNode;

        while (currentNode != null) {
            currentNode = processTreeLevel(currentNode, nodeToAdd);
        }
    }

    private BSTNode processTreeLevel(BSTNode currentNode, BSTNode nodeToAdd) {
        if (shouldGoToTheLeft(currentNode, nodeToAdd)) {
            return processLeft(currentNode, nodeToAdd);
        } else {
            return processRight(currentNode, nodeToAdd);
        }
    }

    private BSTNode processLeft(BSTNode currentNode, BSTNode nodeToAdd) {
        if (currentNode.getLeft() == null) {
            addLeftNode(currentNode, nodeToAdd);
            return null;
        } else {
            return currentNode.getLeft();
        }
    }

    private void addLeftNode(BSTNode currentNode, BSTNode nodeToAdd) {
        currentNode.setLeft(nodeToAdd);
        nodeToAdd.setParent(currentNode);
        size++;
    }

    private boolean shouldGoToTheLeft(BSTNode currentNode, BSTNode nodeToAdd) {
        return nodeToAdd.getKey() < currentNode.getKey();
    }

    private BSTNode processRight(BSTNode currentNode, BSTNode nodeToAdd) {
        if (currentNode.getRight() == null) {
            addRightNode(currentNode, nodeToAdd);
            return null;
        } else {
            return currentNode.getRight();
        }
    }

    private void addRightNode(BSTNode currentNode, BSTNode nodeToAdd) {
        currentNode.setRight(nodeToAdd);
        nodeToAdd.setParent(currentNode);
        size++;
    }

    public BSTNode search(Integer key) {
        return search(key, rootNode);
    }

    private BSTNode search(Integer key, BSTNode currentNode) {
        if(currentNode == null || key == currentNode.getKey())
            return currentNode;

        if(key < currentNode.getKey())
            return search(key, currentNode.getLeft());
        else
            return search(key, currentNode.getRight());

    }

    public void delete(Integer key) {

    }

    public void toArray(Integer[] resultArray) {
        List<Integer> resultList = new ArrayList<Integer>(size);
        print(rootNode, resultList);

        for (int i = 0; i < resultList.size(); ++i) {
            resultArray[i] = resultList.get(i);
        }
    }


    public void print(BSTNode node, List<Integer> list) {
        if (node == null)
            return;

        print(node.getLeft(), list);
        list.add(node.getKey());
        print(node.getRight(), list);
    }

    public Integer max() {
        if(rootNode == null)
            throw new IllegalStateException("Empty tree");

        BSTNode currentNode = rootNode;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode.getKey();
    }

    public Integer min() {
        if(rootNode == null)
            throw new IllegalStateException("Empty tree");

        BSTNode currentNode = rootNode;
        while(currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode.getKey();
    }

    public int getSize() {
        return size;
    }


    public static class BSTNode {
        private BSTNode left;
        private BSTNode right;
        private BSTNode parent;
        private Integer key;

        public BSTNode() {
        }

        public BSTNode(Integer key) {
            this.key = key;
        }

        public BSTNode getLeft() {
            return left;
        }

        public void setLeft(BSTNode left) {
            this.left = left;
        }

        public BSTNode getRight() {
            return right;
        }

        public void setRight(BSTNode right) {
            this.right = right;
        }

        public BSTNode getParent() {
            return parent;
        }

        public void setParent(BSTNode parent) {
            this.parent = parent;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }
    }
}
