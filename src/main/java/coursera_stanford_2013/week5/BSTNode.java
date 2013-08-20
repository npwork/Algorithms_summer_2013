package coursera_stanford_2013.week5;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class BSTNode {
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
