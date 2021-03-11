package AuditoriskiVezbi.aud02.SLLPolinom;

public class PolinomAdd {

    public Polinom soberi(Polinom polinom1, Polinom polinom2){
        Node node1 = polinom1.getFirst ();
        Node node2 = polinom2.getFirst ();

        Polinom result = new Polinom ();

        while(node1 != null && node2 != null){
            if(node1.eksponent.compareTo (node2.eksponent) == 0){
                result.insertLast (node1.koeficient+node2.koeficient, node1.eksponent);
                node1 = node1.succ;
                node2 = node2.succ;
            }
            else if(node1.eksponent.compareTo (node2.eksponent) < 0){
                result.insertLast (node2.koeficient, node2.eksponent);
                node2 = node2.succ;
            }
            else if(node1.eksponent.compareTo (node2.eksponent) > 0){
                result.insertLast (node1.koeficient, node1.eksponent);
                node1 = node1.succ;
            }
        }
        while (node1 != null){
            result.insertLast (node1.koeficient, node1.eksponent);
            node1 = node1.succ;
        }
        while (node2 != null){
            result.insertLast (node2.koeficient, node2.eksponent);
            node2 = node2.succ;
        }
        return result;
    }

    public static void main(String[] args) {
        Polinom polinom1 = new Polinom ();
        Polinom polinom2 = new Polinom ();
        Polinom rezultat = new Polinom ();

        PolinomAdd temp = new PolinomAdd ();

        polinom1.insertLast (10, 5);
        polinom1.insertLast (4, 4);
        polinom1.insertLast (8, 3);
        polinom1.insertLast (6, 2);
        polinom1.insertLast (9, 1);
        polinom1.insertLast (1, 0);
        polinom2.insertLast (11, 7);
        polinom2.insertLast (22, 4);
        polinom2.insertLast (33, 3);
        polinom2.insertLast (44, 2);
        polinom2.insertLast (55, 0);
        rezultat = temp.soberi (polinom1, polinom2);
        System.out.println (rezultat);


    }

}
