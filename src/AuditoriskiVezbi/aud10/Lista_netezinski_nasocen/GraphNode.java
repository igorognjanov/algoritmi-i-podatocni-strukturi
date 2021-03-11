package AuditoriskiVezbi.aud10.Lista_netezinski_nasocen;

import java.util.LinkedList;

public class GraphNode<E> {

    private int index;
    private E info;
    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E info){
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<> ();
    }

    public boolean containsNeighbor(GraphNode<E> x){ return neighbors.contains (x);}

    public void addNeighbor(GraphNode<E> x){ neighbors.add (x);}

    public void removeNeighbor(GraphNode<E> x) { neighbors.remove (x);}

    @Override
    public String toString() {
        String ret = "INFO:" + info + " SOSEDI:";
        for (int i = 0; i < neighbors.size (); i++)
            ret += neighbors.get (i).info + " ";
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNode<E> pom = (GraphNode<E>)obj;
        return (pom.info.equals(this.info));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors = neighbors;
    }


}
