package LaboratoriskiVezbi.vezba4.SalterNaMVR;
import java.util.NoSuchElementException;
import java.util.Scanner;

interface Queue<E>{

    boolean isEmpty();

    void clear();

    E dequeue();

    void enqueue(E e);

    int size();

    E peek();
}

class SLLNode<E>{
    public E element;
    public SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ) {
        this.element = element;
        this.succ = succ;
    }
}


class LinkedQueue<E> implements Queue<E>{
    private SLLNode<E> front, rear;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        front = rear = null;
        size = 0;
    }

    public E dequeue(){
        if(front == null) throw new NoSuchElementException ();
        E temp = front.element;
        front = front.succ;
        if(front == null) rear = null;
        size--;
        return temp;
    }

    public void enqueue(E e){
        if(front == null){
            front = rear = new SLLNode<> (e, null);
            size++;
            return;
        }
        rear.succ = new SLLNode<> (e, null);
        rear = rear.succ;
        size++;
    }

    public int size(){
        return size;
    }

    public E peek(){
        if(front == null) throw new NoSuchElementException ();
        return front.element;
    }

}


class Gragjanin{
    private String name;
    private int lKarta, pasos, vozacka;

    public Gragjanin(String name, int lKarta, int pasos, int vozacka) {
        this.name = name;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    public String getName() {
        return name;
    }

    public int getlKarta() {
        return lKarta;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozacka() {
        return vozacka;
    }

    @Override
    public String toString(){
        return name;
    }
}

public class MVR {

    public static void main(String[] args) {
        LinkedQueue<Gragjanin> queueLicni = new LinkedQueue<> ();
        LinkedQueue<Gragjanin> queuePasos = new LinkedQueue<> ();
        LinkedQueue<Gragjanin> queueVozacka = new LinkedQueue<> ();
        LinkedQueue<Gragjanin> resultQueue = new LinkedQueue<> ();

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());
        for(int i=1;i<=N;i++){
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime,lKarta,pasos,vozacka);
            if(covek.getlKarta () == 1) queueLicni.enqueue (covek);
            if(covek.getPasos () == 1) queuePasos.enqueue (covek);
            if(covek.getVozacka () == 1) queueVozacka.enqueue (covek);
        }
        while (!queueLicni.isEmpty ()){
            Gragjanin covek = queueLicni.dequeue ();
            if(covek.getPasos () == 0 && covek.getVozacka () == 0) resultQueue.enqueue (covek);
        }
        while (!queuePasos.isEmpty ()){
            Gragjanin covek = queuePasos.dequeue ();
            if(covek.getVozacka () == 0) resultQueue.enqueue (covek);
        }
        while (!queueVozacka.isEmpty ()){
            Gragjanin covek = queueVozacka.dequeue ();
            resultQueue.enqueue (covek);
        }
        while (!resultQueue.isEmpty ()){
            System.out.println (resultQueue.dequeue ().toString ());
        }
    }
}


