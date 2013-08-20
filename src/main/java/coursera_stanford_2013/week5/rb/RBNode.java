package coursera_stanford_2013.week5.rb;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public class RBNode {
    private RBNode left;
    private RBNode right;
    private RBNode parent;
    private Integer key;
    private boolean isBlack = true;


    public RBNode() {
    }

    public RBNode(Integer key) {
        this.key = key;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack() {
        isBlack = true;
    }

    public void setRed() {
        isBlack = false;
    }
}
