package LaboratoriskiVezbi.vezba8.WindowsExplorer;

import LaboratoriskiVezbi.vezba2.zadaca2.SLL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.NoSuchElementException;

interface Tree<E> {
    ////////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator ////////////
    public Iterator<E> children(Node<E> node);

}

interface Node<E> {

    public E getElement();

    public void setElement(E elem);
}


class SLLTree<E> implements Tree<E> {

    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }


    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {

        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i=0;i<level;i++)
            System.out.print(" ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>)node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level+1);
            tmp = tmp.sibling;
        }
    }



    public void printTree() {
        printTreeRecursive(root, 0);
    }

}

class SLLNode<P> implements Node<P> {

    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }
}

public class WindowsExplorer {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i=0;i<N;i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");

        // vasiot kod stoi ovde

        SLLNode<String> curr = tree.root;
        for(i=0; i<N; i++){
            String[] parts = commands[i].split (" ");
            String command = parts[0];
            String name;

            if ("CREATE".equals (command)) {
                name = parts[1];
                SLLNode<String> newNode = new SLLNode<> (name);
                SLLNode<String> temp = curr.firstChild;
                SLLNode<String> prev = curr.firstChild;
                if (temp == null || temp.element.compareTo (newNode.element) >= 0)
                    tree.addChild (curr, name);
                else {
                    while (temp != null && temp.element.compareTo (newNode.element) < 0) {
                        prev = temp;
                        temp = temp.sibling;
                    }
                    newNode.parent = curr;
                    SLLNode<String> t = prev.sibling;
                    prev.sibling = newNode;
                    newNode.sibling = t;
                }
            } else if ("PATH".equals (command)) {
                SLLNode<String> tmp = curr;
                String[] path = new String[100];
                j = 0;
                while (tmp != tree.root) {
                    path[j] = tmp.element;
                    tmp = tmp.parent;
                    j++;
                }
                path[j] = tmp.element;
                for (; j >= 0; j--) {
                    System.out.print (path[j] + "\\");
                }
                System.out.println ();
            } else if ("PRINT".equals (command)) {
                tree.printTree ();
            } else if ("OPEN".equals (command)) {
                name = parts[1];
                SLLNode<String> temp = curr.firstChild;
                while (temp != null && !temp.element.equals (name)) {
                    temp = temp.sibling;
                }
                if (temp != null) {
                    curr = temp;
                }
            } else if ("BACK".equals (command)) {
                curr = curr.parent;
            } else if ("DELETE".equals (command)) {
                name = parts[1];
                SLLNode<String> temp = curr.firstChild;
                while (temp != null && !temp.element.equals (name)) {
                    temp = temp.sibling;
                }
                if (temp != null)
                    tree.remove (temp);
            }
        }

    }

}
