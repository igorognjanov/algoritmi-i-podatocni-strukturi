package AuditoriskiVezbi.aud09;

import javax.swing.plaf.InsetsUIResource;

public class AVLNode<E extends Comparable<E>>{

    E info;
    AVLNode<E> left;
    AVLNode<E> right;
    int height;

    public AVLNode(E info, AVLNode<E> left, AVLNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
        height = 0;
    }

    public AVLNode(E info){this(info, null, null);}
}
