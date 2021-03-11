package AuditoriskiVezbi.aud09;

import AuditoriskiVezbi.aud08.SLLTree;
import AuditoriskiVezbi.aud08.Tree;

import java.util.Random;

public class BinarySearchTree<E extends Comparable<E>>{



// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order

    private BNode<E> root;

    public BinarySearchTree(){root = null;}

    private E elementAt(BNode<E> e){
        if(e == null)
            return null;
    else
        return e.element;
    }

    public E findMin(){
        return elementAt (findMin (root));
    }

    private BNode<E> findMin(BNode<E> x){
        if(x == null) return null;
        if(x.left == null) return x;
        return findMin (x.left);
    }

    public E findMax(){
        return elementAt (findMax (root));
    }

    private BNode<E> findMax(BNode<E> x){
        if(x == null) return null;
        if(x.right == null) return x;
        return findMax(x.right);
    }

    public void insert(E x){
        root = insert (x, root);
    }

    public BNode<E> insert(E x, BNode<E> t){
        if(t == null){
            t = new BNode<> (x);
        }
        if(t.element.compareTo (x) > 0){
            t.left = insert (x, t.left);
        }
        if(t.element.compareTo (x) < 0){
            t.right = insert (x, t.right);
        }
        return t;
    }


    public void remove(E x){
        root = remove (x, root);
    }


    public BNode<E> remove(E x, BNode<E> t){
        if(t == null) return null;
        if(x.compareTo (t.element) < 0){
            t.left = remove (x, t.left);
        }
        else if(x.compareTo (t.element) > 0){
            t.right = remove (x, t.right);
        }
        else if(t.left != null && t.right != null){
            t.element = findMin (t.right).element;
            t.right = remove (t.element, t.right);
        }
        else {
            if(t.left != null)
                return t.left;
            return t.right;
        }
        return t;
    }


    private BNode<E> find(E x, BNode<E> t){
        if(t == null) return null;
        if(t.element.equals (x)) return t;
        if(t.element.compareTo (x) > 0) return find(x, t.left);
        if(t.element.compareTo (x) < 0) return find(x, t.right);
        return null;
    }


    public int getHeight(E x){
        return getHeight (find (x, root));
    }
    public int getHeight(BNode<E> t){
        if(t == null) return 0;
        if(t.left == null && t.right == null) return 1;
        if(t.left == null) return 1 + getHeight (t.right);
        if(t.right == null) return 1 + getHeight (t.left);
        return 1 + Math.max (getHeight (t.left), getHeight (t.right));
    }

    public int getNumberOfElementsOnDepth(int n){
        return getNumberOfElementsOnDepth (0, n, root);
    }

    public int getNumberOfElementsOnDepth(int level, int n, BNode<E> t){
        if(t == null) return 0;
        if(level != n){
            int count = 0;
            if(t.left != null) count += getNumberOfElementsOnDepth (level+1, n, t.left);
            if(t.right != null) count += getNumberOfElementsOnDepth (level+1, n, t.right);
            return count;
        }
        return 1;

    }





    public void printTree(){
        if(root == null) System.out.println ("Empty tree");
        else System.out.println ("Printing tree in increasing order:");
        printTree (root);
        System.out.println ();
    }
    public void printTree(BNode<E> t){
        if(t != null){
            printTree (t.left);
            System.out.println (t.element);
            printTree (t.right);
        }
    }

    public static void main(String[] args) {
        int i,j,k;

        Random r = new Random(System.currentTimeMillis());
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        for (i=0;i<1000;i++)
            bst.insert(i*2-1);

        bst.remove (1997);
        bst.remove (1997);
        bst.remove (1997);
        bst.remove (1997);

        bst.printTree();

    }

}