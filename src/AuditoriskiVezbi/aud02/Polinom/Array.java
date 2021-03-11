package AuditoriskiVezbi.aud02.Polinom;

import java.util.Scanner;

public class Array<E> {
    private E[] data;
    int size;

    public Array(int size) {
        this.size = size;
        this.data = (E[]) new Object [size];
    }

    public void set(int n, E o){
        if(n >= 0 && n < size) data[n] = o;
        else System.out.println ("Ne moze da se vmetne objekt na taa pozicija");
    }

    public boolean isNull(int i){
        return this.data[i] == null;
    }

    public E get(int n){
        return data[n];
    }

    public int getLength(){
        return size;
    }

    public int find(E o){
        int ind = -1;
        for(int i=0; i<size; i++){
            o.equals (data[i]);
            ind = i;
        }
        return ind;
    }

    public void insert(int n, E o){
        if(!(n >= 0 && n < size)){
            System.out.println ("Vnesovte nevaliden indeks");
            return;
        }
        E []  temp = (E[]) new Object [size+1];
        for (int i=0; i<n; i++){
            temp[i] = data[i];
        }
        temp[n] = o;
        for(int i=n+1; i<size+1; i++)
            temp[i] = data[i-1];
        data = temp;
        size++;
    }
    public void delete(int n){
        if(!(n >= 0 && n < size)){
            System.out.println ("Vnesovte nevaliden indeks");
            return;
        }
        E [] temp = (E[]) new Object [size-1];
        for(int i=0; i<n; i++)
            temp[i] = data[i];
        for(int i=n; i<size-1; i++){
            temp[i] = data[i+1];
        }
        data = temp;
        size--;
    }

    public void resize(int newSize){
        if(newSize < size){
            E [] temp = (E[]) new Object [newSize];
            for(int i=0; i<newSize; i++) temp[i] = data[i];
            data = temp;
        }
        else if(newSize > size){
            E [] temp = (E[]) new Object [newSize];
            for(int i=0; i<size; i++) temp[i] = data[i];
            data = temp;
        }
        size = newSize;
    }
}
