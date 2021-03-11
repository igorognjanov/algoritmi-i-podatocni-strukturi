package AuditoriskiVezbi.aud08;

public class BTree<E> {
    private BNode<E> root;

    public BTree(){
        root = null;
    }

    public BTree(E element){
        root = new BNode<> (element);
    }

    public void makeRoot(E element){
        root = new BNode<> (element);
    }

    public BNode<E> addChild(BNode<E> node, int where, E element){
        BNode<E> newNode = new BNode<> (element);
        if(where == BNode.LEFT){
            if(node.left != null)
                return null;
            node.left = newNode;
        }
        else if(where == BNode.RIGHT) {
            if(node.right != null)
                return null;
            node.right = newNode;
        }
        return newNode;
    }

    public void inorder(){
        System.out.print ("INORDER: ");
        inorderR (root);
        System.out.println ();
    }

    public void inorderR(BNode<E> curr){
        if(curr != null){
            inorderR (curr.left);
            System.out.print (curr.element + " ");
            inorderR (curr.right);
        }
    }

    public void preorder(){
        System.out.print ("PREORDER: ");
        preorderR (root);
        System.out.println ();
    }

    public void preorderR(BNode<E> curr){
        if(curr != null){
            System.out.print (curr.element + " ");
            preorderR (curr.left);
            preorderR (curr.right);
        }
    }


    public void postorder(){
        System.out.print ("POSTORDER: ");
        postorderR(root);
        System.out.println ();
    }

    public void postorderR(BNode<E> curr){
        if(curr != null){
            postorderR (curr.left);
            postorderR (curr.right);
            System.out.print (curr.element + " ");
        }
    }


    public void inorderNonRecursive(){
        BNode<E> curr = root;
        Stack<BNode<E>> stack = new ArrayStack<> (100);
        while(true){
            while (curr != null){
                stack.push (curr);
                curr = curr.left;
            }
            if(stack.isEmpty ()) {
                break;
            }
            curr = stack.pop ();
            System.out.print (curr.element + " ");
            curr = curr.right;
        }
        System.out.println ();
    }

    public void preorderNonRecursive(){
        BNode<E> temp = root;
        Stack<BNode<E>> stack = new ArrayStack<> (100);
        while (true){
            while (temp != null){
                System.out.print (temp.element + " ");
                stack.push (temp);
                temp = temp.left;
            }
            if(stack.isEmpty ()) {
                break;
            }

            temp = stack.pop ().right;
        }
    }

    private void postorderNonRecursive() {

    }

    public int insideNodes(){
        return insideNodesR (root);
    }
    public int insideNodesR(BNode<E> curr){
        if(curr != null){
            if(!(curr.right == null && curr.left == null)) return 1 + insideNodesR (curr.right) + insideNodesR (curr.left);
        }
        return 0;
    }

    public int leaves(){
        return leavesR (root);
    }
    public int leavesR(BNode<E> curr){
        if(curr != null){
            if((curr.right == null && curr.left == null)) return 1;
            return leavesR (curr.left) + leavesR (curr.right);
        }
        return 0;
    }

    public int depth(){
        return depthR (root)-1;
    }
    public int depthR(BNode<E> node){
        if(node != null){
            return 1 + Math.max (depthR (node.left), depthR (node.right));
        }
        return 0;
    }

    public void mirror(){
        mirror (root);
    }
    public void mirror(BNode<E> t){
        if(t == null) return;
        BNode<E> temp = t.right;
        t.right = t.left;
        t.left = temp;
        mirror (t.left);
        mirror (t.right);

    }

    public static void main(String[] args) {
        BNode<Character> a, b, c;
        BTree<Character> tree = new BTree<Character>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');

        tree.inorder();
        tree.preorder();
        tree.postorder();
        tree.inorderNonRecursive();
        tree.preorderNonRecursive ();
        tree.postorderNonRecursive ();

        System.out.println("Brojot na vnatresni jazli e " + tree.insideNodes());
        System.out.println("Brojot na listovi e " + tree.leaves());
        System.out.println("Dlabocinata na drvoto e " + tree.depth());
//
        tree.mirror();
        tree.inorder();
    }


}
