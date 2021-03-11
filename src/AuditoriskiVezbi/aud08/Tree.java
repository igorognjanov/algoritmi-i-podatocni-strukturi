package AuditoriskiVezbi.aud08;

import java.util.Iterator;

public interface Tree<T> {
    interface Node<T>{
        T getElement();

        void setElement(T element);
    }

    Tree.Node<T> root();

    Tree.Node<T> parent(Tree.Node<T> node);

    int childCount(Tree.Node<T> node);

    void makeRoot(T elem);

    void remove(Tree.Node<T> node);

    Tree.Node<T> addChild(Tree.Node<T> node, T elem);

    public Iterator<T> children(Tree.Node<T> node);
}
