package coursera_stanford_2013.week5.rb;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: npapirniy
 * Date: 20.08.13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public class RBTree {
    private final RBNode nil = new RBNode();
    private RBNode rootNode;
    private int size;


    public void rightRotate(RBNode from, RBNode to) {
        RBNode toRight = to.getRight();

        setParents(from, to);

        to.setRight(from);
        from.setLeft(toRight);
        toRight.setParent(from);
    }

    public void leftRotate(RBNode from, RBNode to) {
        RBNode toLeft = to.getLeft();

        setParents(from, to);

        to.setLeft(from);
        from.setRight(toLeft);
        toLeft.setParent(from);
    }

    private void setParents(RBNode from, RBNode to) {
        RBNode fromParent = from.getParent();
        if (fromParent == null) {
            rootNode = to;
            to.setParent(null);
        } else {
            setFromParentChild(to, fromParent);
            to.setParent(fromParent);
        }
        from.setParent(to);
    }

    private void setFromParentChild(RBNode to, RBNode fromParent) {
        if (isLeftChildOfParent(fromParent))
            fromParent.setLeft(to);
        else
            fromParent.setRight(to);
    }

    // ------------------------------------------

    public void add(Integer key) {
        bstAdd(key);
        RBNode insertedNode = search(key);
        insertedNode.setRed();
        rbInsertFixup(insertedNode);
    }

    private void rbInsertFixup(RBNode insertedNode) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void bstAdd(Integer key) {
        if (rootNode == null)
            addRootNode(key);
        else
            addNonRootNode(key);
    }

    private void addNonRootNode(Integer key) {
        RBNode currentNode = rootNode;

        while (currentNode != null) {
            currentNode = processTreeLevel(currentNode, new RBNode(key));
        }
    }

    private void addRootNode(Integer key) {
        rootNode = new RBNode(key);
        increaseSizeOfTree();
    }

    private int increaseSizeOfTree() {
        return size++;
    }

    private RBNode processTreeLevel(RBNode currentNode, RBNode nodeToAdd) {
        if (shouldGoToTheLeft(currentNode, nodeToAdd)) {
            return processLeft(currentNode, nodeToAdd);
        } else {
            return processRight(currentNode, nodeToAdd);
        }
    }

    private RBNode processLeft(RBNode currentNode, RBNode nodeToAdd) {
        if (currentNode.getLeft() == null) {
            addLeftNode(currentNode, nodeToAdd);
            return null;
        } else {
            return currentNode.getLeft();
        }
    }

    private void addLeftNode(RBNode currentNode, RBNode nodeToAdd) {
        currentNode.setLeft(nodeToAdd);
        nodeToAdd.setParent(currentNode);
        size++;
    }

    private boolean shouldGoToTheLeft(RBNode currentNode, RBNode nodeToAdd) {
        return nodeToAdd.getKey() < currentNode.getKey();
    }

    private RBNode processRight(RBNode currentNode, RBNode nodeToAdd) {
        if (currentNode.getRight() == null) {
            addRightNode(currentNode, nodeToAdd);
            return null;
        } else {
            return currentNode.getRight();
        }
    }

    private void addRightNode(RBNode currentNode, RBNode nodeToAdd) {
        currentNode.setRight(nodeToAdd);
        nodeToAdd.setParent(currentNode);
        size++;
    }


    public RBNode search(Integer key) {
        return search(key, rootNode);
    }

    private RBNode search(Integer key, RBNode currentNode) {
        if (currentNode == null || key.equals(currentNode.getKey()))
            return currentNode;

        if (key < currentNode.getKey())
            return search(key, currentNode.getLeft());
        else
            return search(key, currentNode.getRight());
    }


    public Integer predecessor(int key) {
        RBNode searchResult = search(key);
        if (searchResult == null)
            return null;

        RBNode predecessorNode = findPredecessorNode(searchResult);
        return predecessorNode == null ? null : predecessorNode.getKey();
    }

    private RBNode findPredecessorNode(RBNode searchResult) {
        if (searchResult.getLeft() != null)
            return findMinNode(searchResult.getLeft());
        else
            return getPredecessorNodeUpperInTree(searchResult);
    }

    private RBNode getPredecessorNodeUpperInTree(RBNode searchResult) {
        RBNode currentNode = searchResult.getParent();
        while (currentNode != null && isLeftChildOfParent(currentNode)) {
            currentNode = currentNode.getParent();
        }
        return currentNode == null ? null : currentNode.getParent();
    }


    public Integer successor(int key) {
        RBNode searchResult = search(key);
        if (searchResult == null)
            return null;

        RBNode successorNode = findSuccessorNode(searchResult);
        return successorNode == null ? null : successorNode.getKey();
    }

    private RBNode findSuccessorNode(RBNode searchResult) {
        if (searchResult.getRight() != null)
            return findMinNode(searchResult.getRight());
        else
            return getSuccessorNodeUpperInTree(searchResult);
    }

    private RBNode getSuccessorNodeUpperInTree(RBNode searchResult) {
        RBNode currentNode = searchResult.getParent();
        while (currentNode != null && isRightChildOfParent(currentNode)) {
            currentNode = currentNode.getParent();
        }
        return currentNode == null ? null : currentNode.getParent();
    }

    private boolean isRightChildOfParent(RBNode currentNode) {
        return currentNode.getParent() != null && currentNode.getParent().getRight() == currentNode;
    }

    private boolean isLeftChildOfParent(RBNode currentNode) {
        return currentNode.getParent() != null && currentNode.getParent().getLeft() == currentNode;
    }


    public boolean remove(Integer key) {
        RBNode searchResult = search(key);
        return removeTreeNode(searchResult);
    }

    private boolean removeTreeNode(RBNode searchResult) {
        if (searchResult == null)
            return false;

        removeNode(searchResult);

        size--;
        return true;
    }

    private void removeNode(RBNode nodeToDelete) {
        if (hasNoChildren(nodeToDelete)) {
            deleteWithoutChildren(nodeToDelete);
        } else if (hasTwoChildren(nodeToDelete)) {
            deleteWithTwoChildren(nodeToDelete);
        } else if (hasOneChild(nodeToDelete)) {
            deleteWithOneChild(nodeToDelete);
        }
    }

    private void deleteWithTwoChildren(RBNode searchResult) {
        RBNode minNodeFromRightSubTree = findMinNode(searchResult.getRight());

        searchResult.setKey(minNodeFromRightSubTree.getKey());
        removeNode(minNodeFromRightSubTree);
    }

    private boolean hasTwoChildren(RBNode searchResult) {
        return searchResult.getLeft() != null && searchResult.getRight() != null;
    }

    private void deleteWithOneChild(RBNode searchResult) {
        if (isInRootPosition(searchResult))
            deleteWithOneChildIfRootElement(searchResult);
        else
            deleteWithOneChildIfNotRootElement(searchResult);

    }

    private boolean isInRootPosition(RBNode searchResult) {
        return searchResult.getParent() == null;
    }

    private void deleteWithOneChildIfNotRootElement(RBNode searchResult) {
        RBNode parent = searchResult.getParent();
        getNotNullNode(searchResult).setParent(parent);

        if (parent.getLeft() != null)
            parent.setLeft(null);
        if (parent.getRight() != null)
            parent.setRight(null);

        searchResult.setParent(null);
    }

    private void deleteWithOneChildIfRootElement(RBNode searchResult) {
        RBNode notNullNode = getNotNullNode(searchResult);
        notNullNode.setParent(null);
        rootNode = notNullNode;
    }

    private RBNode getNotNullNode(RBNode searchResult) {
        return searchResult.getLeft() == null ? searchResult.getRight() : searchResult.getLeft();
    }

    private boolean hasOneChild(RBNode searchResult) {
        return searchResult.getLeft() != null || searchResult.getRight() != null;
    }

    private void deleteWithoutChildren(RBNode searchResult) {
        RBNode parent = searchResult.getParent();
        if (parent == null) {
            rootNode = null;
            return;
        }

        if (isNodeLeftParentLeaf(parent, searchResult)) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    private boolean isNodeLeftParentLeaf(RBNode parent, RBNode searchResult) {
        return parent.getLeft() != null && parent.getLeft().getKey() == searchResult.getKey();
    }

    private boolean hasNoChildren(RBNode searchResult) {
        return searchResult.getLeft() == null && searchResult.getRight() == null;
    }


    public void toArray(Integer[] resultArray) {
        List<Integer> resultList = new ArrayList<Integer>(size);
        print(rootNode, resultList);

        for (int i = 0; i < resultList.size(); ++i) {
            resultArray[i] = resultList.get(i);
        }
    }

    public void print(RBNode node, List<Integer> list) {
        if (node == null)
            return;

        print(node.getLeft(), list);
        list.add(node.getKey());
        print(node.getRight(), list);
    }

    public Integer max() {
        return max(rootNode);
    }

    private Integer max(RBNode startNode) {
        RBNode maxNode = findMaxNode(startNode);
        return maxNode == null ? null : maxNode.getKey();
    }

    private RBNode findMaxNode(RBNode startNode) {
        if (startNode == null)
            return null;

        RBNode currentNode = startNode;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }


    public Integer min() {
        return min(rootNode);
    }

    private Integer min(RBNode startNode) {
        RBNode minNode = findMinNode(startNode);
        return minNode == null ? null : minNode.getKey();
    }

    private RBNode findMinNode(RBNode startNode) {
        if (startNode == null)
            return null;

        RBNode currentNode = startNode;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }


    public int getSize() {
        return size;
    }

}
