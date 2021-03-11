package LaboratoriskiVezbi.vezba9.BinarnoDrvo;

import AuditoriskiVezbi.aud09.BinarySearchTree;

import java.util.Scanner;

public class BinarnoDrvo {


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<> ();
        Scanner scanner = new Scanner (System.in);

        int n = scanner.nextInt ();
        for(int i=0; i<n; i++) {
            bst.insert (scanner.nextInt ());
        }
        int element = scanner.nextInt ();

        int visina = bst.getHeight (element);
        System.out.println ("Visinata na elementot " + element +" e: " + visina);
        System.out.println ("Brojot na elementi na dlabocina " + visina +" e: " + bst.getNumberOfElementsOnDepth (visina));
    }
}
