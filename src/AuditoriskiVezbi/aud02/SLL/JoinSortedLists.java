package AuditoriskiVezbi.aud02.SLL;

class JoinSortedLists{

    public SLL<Monom> join(SLL<Monom> list1, SLL<Monom> list2){
        SLL<Monom> result = new SLL<> ();
        SLLNode<Monom> node1 = list1.getFirst ();
        SLLNode<Monom> node2 = list2.getFirst ();

        while(node1 != null && node2 != null){
            if((node1.element.compareTo (node2.element)) < 0){
                result.insertLast (node2.element);
                node2 = node2.succ;
            }
            else if(node1.element.compareTo (node2.element) == 0){
                result.insertLast (node1.element.soberi(node2.element));
                node1 = node1.succ;
                node2 = node2.succ;
            }
            else{
                result.insertLast (node1.element);
                node1 = node1.succ;
            }
        }
        while (node1 != null){
            result.insertLast (node1.element);
            node1 = node1.succ;
        }
        while (node2 != null){
            result.insertLast (node2.element);
            node2 = node2.succ;
        }
        return result;
    }

    public static void main(String[] args) {
        SLL<Monom> polinom1 = new SLL<> ();
        SLL<Monom> polinom2 = new SLL<> ();
        SLL<Monom> rezultat = new SLL<> ();

        Monom m1 = new Monom (3, 5);
        Monom m2 = new Monom (4, 4);
        Monom m3 = new Monom (5, 3);
        Monom m4 = new Monom (6, 2);
        Monom m5 = new Monom (7, 1);
        Monom m6 = new Monom (10, 3);
        Monom m7 = new Monom (90, 2);
        Monom m8 = new Monom (34, 1);
        Monom m9 = new Monom (23, 0);

        polinom1.insertLast (m1);
        polinom1.insertLast (m2);
        polinom1.insertLast (m3);
        polinom1.insertLast (m4);
        polinom1.insertLast (m5);
        polinom2.insertLast (m6);
        polinom2.insertLast (m7);
        polinom2.insertLast (m8);
        polinom2.insertLast (m9);

        JoinSortedLists temp = new JoinSortedLists ();
        rezultat = temp.join (polinom1, polinom2);
        System.out.println (rezultat);
    }
}
