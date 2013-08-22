package coursera_stanford_2013.week5.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BSTImpl<E> implements BST<E> {
    private Comparator<E> comparator;
    private BSTNode<E> rootNode;
    private int size;

    public BSTImpl(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(E key) {
        if (rootNode == null)
            addRootNode(key);
        else
            addNonRootNode(key);
    }

    private void addNonRootNode(E key) {
        BSTNode<E> currentNode = rootNode;
        BSTNode<E> nodeToAdd = new BSTNode<E>(key);

        while (currentNode != null) {
            BSTNode<E> retrievedNode = processTreeLevel(currentNode, nodeToAdd);
//            currentNode.setMaxInSubTree(nodeToAdd.getKey());
            currentNode = retrievedNode;
        }
    }

    private void addRootNode(E key) {
        rootNode = new BSTNode<E>(key);
        size++;
    }

    private BSTNode<E> processTreeLevel(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        setMaxInSubTree(currentNode, nodeToAdd);

        if (shouldGoToTheLeft(currentNode, nodeToAdd)) {
            return processLeft(currentNode, nodeToAdd);
        } else {
            return processRight(currentNode, nodeToAdd);
        }
    }

    private void setMaxInSubTree(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        E currentMaxInSubTree = currentNode.getMaxInSubTree();
        if(currentMaxInSubTree == null || greaterThan(nodeToAdd.getKey(), currentMaxInSubTree))
            currentNode.setMaxInSubTree(nodeToAdd.getKey());
    }

    private BSTNode<E> processLeft(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        if (currentNode.getLeft() == null) {
            addLeftNode(currentNode, nodeToAdd);
            return null;
        } else {
            return currentNode.getLeft();
        }
    }

    private BSTNode<E> processRight(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        if (currentNode.getRight() == null) {
            addRightNode(currentNode, nodeToAdd);
            return null;
        } else {
            return currentNode.getRight();
        }
    }

    private void addLeftNode(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        currentNode.setLeft(nodeToAdd);
        nodeToAdd.setParent(currentNode);
        size++;
    }

    private boolean shouldGoToTheLeft(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        return lessThan(nodeToAdd.getKey(), currentNode.getKey());
    }

    private boolean lessThan(E o1, E o2) {
        return comparator.compare(o1, o2) < 0;
    }

    private boolean equals(E o1, E o2) {
        return comparator.compare(o1, o2) == 0;
    }

    private boolean greaterThan(E o1, E o2) {
        return comparator.compare(o1, o2) > 0;
    }

    private void addRightNode(BSTNode<E> currentNode, BSTNode<E> nodeToAdd) {
        currentNode.setRight(nodeToAdd);
        nodeToAdd.setParent(currentNode);
        size++;
    }

    @Override
    public BSTNode<E> search(E key) {
        return search(key, rootNode);
    }

    private BSTNode<E> search(E key, BSTNode<E> currentNode) {
        if (currentNode == null || key.equals(currentNode.getKey()))
            return currentNode;

        if (lessThan(key, currentNode.getKey()))
            return search(key, currentNode.getLeft());
        else
            return search(key, currentNode.getRight());
    }

   // public int countOfIntervalsThatKeyIn(E key) {

    //}


    @Override
    public E predecessor(E key) {
        BSTNode<E> searchResult = search(key);
        if (searchResult == null)
            return null;

        BSTNode<E> predecessorNode = findPredecessorNode(searchResult);
        return predecessorNode == null ? null : predecessorNode.getKey();
    }

    private BSTNode<E> findPredecessorNode(BSTNode<E> searchResult) {
        if (searchResult.getLeft() != null)
            return findMinNode(searchResult.getLeft());
        else
            return getPredecessorNodeUpperInTree(searchResult);
    }

    private BSTNode<E> getPredecessorNodeUpperInTree(BSTNode<E> searchResult) {
        BSTNode<E> currentNode = searchResult.getParent();
        while (currentNode != null && isLeftChildOfParent(currentNode)) {
            currentNode = currentNode.getParent();
        }
        return currentNode == null ? null : currentNode.getParent();
    }

    @Override
    public E successor(E key) {
        BSTNode<E> searchResult = search(key);
        if (searchResult == null)
            return null;

        BSTNode<E> successorNode = findSuccessorNode(searchResult);
        return successorNode == null ? null : successorNode.getKey();
    }

    private BSTNode<E> findSuccessorNode(BSTNode<E> searchResult) {
        if (searchResult.getRight() != null)
            return findMinNode(searchResult.getRight());
        else
            return getSuccessorNodeUpperInTree(searchResult);
    }

    private BSTNode<E> getSuccessorNodeUpperInTree(BSTNode<E> searchResult) {
        BSTNode<E> currentNode = searchResult.getParent();
        while (currentNode != null && isRightChildOfParent(currentNode)) {
            currentNode = currentNode.getParent();
        }
        return currentNode == null ? null : currentNode.getParent();
    }

    private boolean isRightChildOfParent(BSTNode<E> currentNode) {
        return currentNode.getParent() != null && currentNode.getParent().getRight() == currentNode;
    }

    private boolean isLeftChildOfParent(BSTNode<E> currentNode) {
        return currentNode.getParent() != null && currentNode.getParent().getLeft() == currentNode;
    }

    @Override
    public boolean remove(E key) {
        BSTNode<E> searchResult = search(key);
        return removeTreeNode(searchResult);
    }

    private boolean removeTreeNode(BSTNode<E> searchResult) {
        if (searchResult == null)
            return false;

        removeNode(searchResult);

        size--;
        return true;
    }

    private void removeNode(BSTNode<E> nodeToDelete) {
        BSTNode parentOfDeletedNode = nodeToDelete.getParent();

        if (hasNoChildren(nodeToDelete)) {
            deleteWithoutChildren(nodeToDelete);
        } else if (hasTwoChildren(nodeToDelete)) {
            deleteWithTwoChildren(nodeToDelete);
        } else if (hasOneChild(nodeToDelete)) {
            deleteWithOneChild(nodeToDelete);
        }
        recomputeMaxSubTreeValue(parentOfDeletedNode);
    }
    private void recomputeMaxSubTreeValue(BSTNode<E> parentOfDeletedNode) {
        BSTNode<E> currentNode = parentOfDeletedNode;
        while(currentNode != null) {
            E maxInSubTree = null;
            if(parentOfDeletedNode.getRight() != null)
                maxInSubTree = max(parentOfDeletedNode.getRight());
            else if(parentOfDeletedNode.getLeft() != null)
                maxInSubTree = max(parentOfDeletedNode.getLeft());

            currentNode.setMaxInSubTree(maxInSubTree);

            currentNode = currentNode.getParent();
        }
    }

    private void deleteWithTwoChildren(BSTNode<E> searchResult) {
        BSTNode<E> minNodeFromRightSubTree = findMinNode(searchResult.getRight());

        searchResult.setKey(minNodeFromRightSubTree.getKey());
        removeNode(minNodeFromRightSubTree);
    }

    private boolean hasTwoChildren(BSTNode<E> searchResult) {
        return searchResult.getLeft() != null && searchResult.getRight() != null;
    }

    private void deleteWithOneChild(BSTNode<E> searchResult) {
        if (isInRootPosition(searchResult))
            deleteWithOneChildIfRootElement(searchResult);
        else
            deleteWithOneChildIfNotRootElement(searchResult);

    }

    private boolean isInRootPosition(BSTNode<E> searchResult) {
        return searchResult.getParent() == null;
    }

    private void deleteWithOneChildIfNotRootElement(BSTNode<E> searchResult) {
        BSTNode<E> parent = searchResult.getParent();
        getNotNullNode(searchResult).setParent(parent);

        if (parent.getLeft() != null)
            parent.setLeft(getNotNullNode(searchResult));
        if (parent.getRight() != null)
            parent.setRight(getNotNullNode(searchResult));

        searchResult.setParent(null);
    }

    private void deleteWithOneChildIfRootElement(BSTNode<E> searchResult) {
        BSTNode<E> notNullNode = getNotNullNode(searchResult);
        notNullNode.setParent(null);
        rootNode = notNullNode;
    }

    private BSTNode<E> getNotNullNode(BSTNode<E> searchResult) {
        return searchResult.getLeft() == null ? searchResult.getRight() : searchResult.getLeft();
    }

    private boolean hasOneChild(BSTNode<E> searchResult) {
        return searchResult.getLeft() != null || searchResult.getRight() != null;
    }

    private void deleteWithoutChildren(BSTNode<E> searchResult) {
        BSTNode<E> parent = searchResult.getParent();
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

    private boolean isNodeLeftParentLeaf(BSTNode<E> parent, BSTNode<E> searchResult) {
        return parent.getLeft() != null && parent.getLeft().getKey() == searchResult.getKey();
    }

    private boolean hasNoChildren(BSTNode<E> searchResult) {
        return searchResult.getLeft() == null && searchResult.getRight() == null;
    }

    @Override
    public void toArray(E[] resultArray) {
        List<E> resultList = new ArrayList<E>(size);
        print(rootNode, resultList);

        for (int i = 0; i < resultList.size(); ++i) {
            resultArray[i] = resultList.get(i);
        }
    }


    public void print(BSTNode<E> node, List<E> list) {
        if (node == null)
            return;

        print(node.getLeft(), list);
        list.add(node.getKey());
        print(node.getRight(), list);
    }

    @Override
    public E max() {
        return max(rootNode);
    }

    private E max(BSTNode<E> startNode) {
        BSTNode<E> maxNode = findMaxNode(startNode);
        return maxNode == null ? null : maxNode.getKey();
    }

    private BSTNode<E> findMaxNode(BSTNode<E> startNode) {
        if (startNode == null)
            return null;

        BSTNode<E> currentNode = startNode;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    @Override
    public E min() {
        return min(rootNode);
    }

    private E min(BSTNode<E> startNode) {
        BSTNode<E> minNode = findMinNode(startNode);
        return minNode == null ? null : minNode.getKey();
    }

    private BSTNode<E> findMinNode(BSTNode<E> startNode) {
        if (startNode == null)
            return null;

        BSTNode<E> currentNode = startNode;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    @Override
    public int getSize() {
        return size;
    }
}