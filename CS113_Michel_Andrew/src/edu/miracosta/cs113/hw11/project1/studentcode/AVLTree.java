package edu.miracosta.cs113.hw11.project1.studentcode;

/*<listing chapter="9" section="2">*/
/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @author Koffman and Wolfgang
 */
public class AVLTree<E extends Comparable<E>>
         extends BinarySearchTreeWithRotate<E> {

    // Insert nested class AVLNode<E> here.
    /*<listing chapter="9" number="2">*/
    /** Class to represent an AVL Node. It extends the
     * BinaryTree.Node by adding the balance field.
     */
    private static class AVLNode<E> extends Node<E> {

        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height - left subtree height */
        private int balance;

        // Methods
        /**
         * Construct a node with the given item as the data field.
         * @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         * @return String representation of this object
         */
        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
    /*</listing>*/
    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

// Insert solution to programming project 5, chapter -1 here

    // Methods
    /**
     * add starter method.
     * @pre the item to insert implements the Comparable interface.
     * @param item The item being inserted.
     * @return true if the object is inserted; false
     *         if the object already exists in the tree
     * @throws ClassCastException if item is not Comparable
     */
    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }

    /**
     * Recursive add method. Inserts the given object into the tree.
     * @post addReturn is set true if the item is inserted,
     *       false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root of the subtree with the item
     *         inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        } else { // item > data
// Insert solution to programming exercise 2, section 2, chapter 9 here

            localRoot.right = add((AVLNode<E>) localRoot.right, item);

            if(increase){
                incrementBalance(localRoot);

                if(localRoot.balance > AVLNode.RIGHT_HEAVY)
                {
                    increase = false;
                    // REBALANCE RIGHT
                    return rebalanceRight(localRoot);
                }
            }

            return localRoot;
        }
    }

    /*<listing chapter="9" number="3">*/
    /**
     * Method to rebalance left.
     * @pre localRoot is the root of an AVL subtree that is
     *      critically left-heavy.
     * @post Balance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            // Adjust the balances to be their new values after
            // the rotations are performed.
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case
            // In this case the leftChild (the new root)
            // and the root (new right child) will both be balanced
            // after the rotation.
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }
    /*</listing>*/

// Insert solution to programming exercise 1, section 2, chapter 9 here

    /**
     * Opposite version of rebalanceLeft method at page 487
     * @param localRoot the root of the AVL tree that is being rebalanced
     * @return updated root
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
    {
        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;

        if(rightChild.balance < AVLNode.BALANCED)
        {
            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;

            if(rightLeftChild.balance > AVLNode.BALANCED)
            {
                rightChild.balance = AVLNode.RIGHT_HEAVY;

                rightLeftChild.balance = AVLNode.BALANCED;

                localRoot.balance = AVLNode.BALANCED;
            }
            else if(rightLeftChild.balance > AVLNode.BALANCED)
            {
                rightChild.balance = AVLNode.BALANCED;

                rightLeftChild.balance = AVLNode.BALANCED;

                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else
            {
                rightChild.balance = AVLNode.BALANCED;

                localRoot.balance = AVLNode.BALANCED;
            }

            localRoot.right = rotateRight(rightChild);

        }
        else
        {
            rightChild.balance = AVLNode.BALANCED;

            localRoot.balance = AVLNode.BALANCED;
        }

        return (AVLNode<E>) rotateLeft(localRoot);
    }

    /**
     * Method to decrement the balance field and to reset the value of
     * increase.
     * @pre The balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the left[
     *      or removed from the right].
     * @post The balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }

    /**
     * Method to increment the balance field and to reset the value of
     * increase.
     * @pre The balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the left[
     *      or removed from the right].
     * @post The balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be decremented
     */
    private void incrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance++;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }

// Insert solution to programming exercise 3, section 2, chapter 9 here

// Insert solution to programming project 5, chapter -1 here



// Programming project 1. Page 534

/* Algorithm for insertion into an AVL tree page 483

    1.  if the root is null
    2.      Create a new tree with the item at the root and return true.
        else if the item is equal to root.data
    3.      The item is already in the tree; return false.
        else if the item is less than root.data
    4.      Recursively insert the item in the left subtree.
    5.      if the height of the left subtree has increased (increase is true)
    6.          Decrement balance
    7.          if balance is zero, reset increase to false.
    8.          if balance is less than -1
    9.              Reset increase to false.
    10.             Perform a rebalanceleft.
        else if the item is greater than root.data
    11.     The processing is symmetric to Steps 4 through 10. Note that balance
            is incremented if increase is true.
*/

/*
    public boolean insert(E item)
    {
        if(root == null)
        {
            root = new AVLNode<E>(item);
            return true;
        }
        else if(item.compareTo(root.data) == 0)
        {
            return false;
        }
        else if(item.compareTo(root.data) < 0)
        {
            // recursively insert the item in the left subtree
            // insert(item);
            increase = insert(item);


            if(increase == true)
            {
                decrementBalance();
                if()
            }
        }
        else if(item.compareTo(root.data) > 0)
        {

        }

        return false;
    }
*/
}
