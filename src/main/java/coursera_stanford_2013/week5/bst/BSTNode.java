package coursera_stanford_2013.week5.bst;

public class BSTNode<E> {
    private BSTNode left;
    private BSTNode right;
    private BSTNode parent;
    private E key;
    private E maxInSubTree;

    public BSTNode() {
    }

    public BSTNode(E key) {
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

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public E getMaxInSubTree() {
        return maxInSubTree;
    }

    public void setMaxInSubTree(E maxInSubTree) {
        this.maxInSubTree = maxInSubTree;
    }
}
