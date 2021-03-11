package AuditoriskiVezbi.aud08;

import LaboratoriskiVezbi.vezba2.zadaca2.SLL;

import java.util.Iterator;

public class SLLTree<T> implements Tree<T>{

    public class SLLNode<T> implements Tree.Node<T>{
        private T element;
        SLLNode<T> parent, sibling, firstChild;

        public SLLNode(T element){
            this.element = element;
            parent = sibling = firstChild = null;
        }

        @Override
        public T getElement() {
            return element;
        }

        @Override
        public void setElement(T element) {
            this.element = element;
        }
    }

    protected SLLNode<T> root;

    public SLLTree(){
        root = null;
    }

    @Override
    public Node<T> root() {
        return root;
    }

    @Override
    public Node<T> parent(Tree.Node<T> node) {
        return ((SLLNode<T>) node).parent;
    }

    @Override
    public int childCount(Tree.Node<T> node) {
        int counter = 0;
        SLLNode<T> temp = ((SLLNode<T>)node).firstChild;
        while (temp != null) {
            counter++;
            temp = temp.sibling;
        }
        return counter;
    }

    @Override
    public void makeRoot(T elem) {
        root = new SLLNode<> (elem);
    }

    @Override
    public void remove(Node<T> node) {
        SLLNode<T> curr = (SLLNode<T>) node;
        if(curr.parent == null) root = null;
        else{
            if(curr.parent.firstChild == curr)
                curr.parent.firstChild = curr.sibling;
            else {
                SLLNode<T> temp = curr.parent.firstChild;
                while (temp.sibling != curr){
                    temp = temp.sibling;
                }
                temp.sibling = curr.sibling;
            }
        }
    }

    @Override
    public Node<T> addChild(Tree.Node<T> node, T elem) {
        SLLNode<T> curr = ((SLLNode<T>)node);
        SLLNode<T> temp = new SLLNode<> (elem);
        temp.sibling = curr.firstChild;
        curr.firstChild = temp;
        temp.parent = curr;
        return temp;
    }

    @Override
    public SLLTreeIterator<T> children(Node<T> node) {
        return null;
    }

    class SLLTreeIterator<T> implements Iterator<T> {
        SLLNode<T> curr, next, prev;

        public SLLTreeIterator(SLLNode<T> node){
            prev = null;
            curr = node;
            next = node.sibling;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T ret = next.element;
            prev = curr;
            curr = next;
            return ret;
        }

        @Override
        public void remove() {
            if(curr.sibling != null) curr = curr.sibling;
        }
    }

    public void printTree() {
        printTreeRecursively (root, 0);
    }
    void printTreeRecursively(Tree.Node<T> node, int level){
        SLLNode<T> curr = (SLLNode<T>) node;
        SLLNode<T> temp;
        if(node == null) return;
        for(int i=0; i<level; i++)
            System.out.print ("\t");
        System.out.println (curr.element);
        if(curr.firstChild != null) printTreeRecursively (curr.firstChild, level+1);
        if(curr.sibling != null) printTreeRecursively (curr.sibling, level);
    }

    public int countMaxChildren(){
       return maxChildrenRecursively (root);
    }

    public int maxChildrenRecursively(SLLNode<T> node){
        int t = childCount (node);
        SLLNode<T> curr = ((SLLNode<T>) node).firstChild;
        while (curr != null){
            t = Math.max (t, maxChildrenRecursively (curr));
            curr = curr.sibling;
        }
        return t;
    }


    public static void main(String[] args) {

        Tree.Node<String> a, b, c, d;

        SLLTree<String> t = new SLLTree<String>();

        t.makeRoot("C:");

        a = t.addChild(t.root, "Program files");
        b = t.addChild(a, "CodeBlocks");
        c = t.addChild(b, "codeblocks.dll");
        c = t.addChild(b, "codeblocks.exe");
        b = t.addChild(a, "Nodepad++");
        c = t.addChild(b, "langs.xml");
        c = t.addChild(b, "langs.xml");
        c = t.addChild(b, "IGOR.xml");
        c = t.addChild(b, "OGNJANOV.xml");
        d = c;
        c = t.addChild(b, "readme.txt");
        c = t.addChild(b, "notepad++.exe");
        a = t.addChild(t.root, "Users");
        b = t.addChild(a, "Darko");
        c = t.addChild(b, "Desktop");
        c = t.addChild(b, "Downloads");
        c = t.addChild(b, "My Documents");
        c = t.addChild(b, "My Pictures");
        b = t.addChild(a, "Public");
        a = t.addChild(t.root, "Windows");
        b = t.addChild(a, "Media");

        t.printTree();

        t.remove(d);
        t.printTree();

        System.out.println("The maximum number of children is "
                + t.countMaxChildren());

    }




}
