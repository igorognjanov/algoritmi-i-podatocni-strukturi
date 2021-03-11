package Exercises.PrvKolokvium.TrikSoKarti;

import AuditoriskiVezbi.aud05.Queue.LinkedQueue;
import LaboratoriskiVezbi.vezba1.zadaca1.Patuvanje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class card_trick {
    public static int count(int N){
        // Vasiot kod tuka
        LinkedQueue<Integer> cards = new LinkedQueue<> ();
        for(int i=1; i<=51; i++){
            cards.enqueue (i);
        }

        int counter = 1;
        Stack<Integer> stack = new Stack<> ();

        while (true){

            boolean temp = false;

            for(int i=0; i<7; i++){
                stack.push (cards.dequeue ());
            }
            for(int i=0; i<7; i++){
                cards.enqueue (cards.dequeue ());
                cards.enqueue (stack.pop ());
            }
            if(cards.peek () == N)
                break;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
