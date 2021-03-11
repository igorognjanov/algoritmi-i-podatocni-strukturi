package AuditoriskiVezbi.aud11.lista_netezinski_nasocen;

//import java.util.Iterator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;




import java.util.LinkedList;

class GraphNode<E> {
    private int index;//index (reden broj) na temeto vo grafot
    private E info;
    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E info) {
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<GraphNode<E>>();
    }

    boolean containsNeighbor(GraphNode<E> o){
        return neighbors.contains(o);
    }

    void addNeighbor(GraphNode<E> o){
        neighbors.add(o);
    }


    void removeNeighbor(GraphNode<E> o){
        if(neighbors.contains(o))
            neighbors.remove(o);
    }


    @Override
    public String toString() {
        String ret= "INFO:"+info+" SOSEDI:";
        for(int i=0;i<neighbors.size();i++)
            ret+=neighbors.get(i).info+" ";
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

class Graph<E> {

    int num_nodes;
    GraphNode<E> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes, E[] list) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i, list[i]);
    }

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i, null);
    }

    int adjacent(int x, int y) {
        // proveruva dali ima vrska od jazelot so
        // indeks x do jazelot so indeks y
        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        // dodava vrska od jazelot so indeks x do jazelot so indeks y
        if (!adjList[x].containsNeighbor(adjList[y])) {
            adjList[x].addNeighbor(adjList[y]);
        }
    }

    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }

    /************************TOPOLOGICAL SORT*******************************************************************/

    void dfsVisit(Stack<E> s, int i, boolean[] visited){
        if(!visited[i]){
            visited[i] = true;
            System.out.println ("dfsVisit: " + i + " Stack=" + s);
            Iterator<GraphNode<E>> iterator = adjList[i].getNeighbors ().listIterator ();
            while (iterator.hasNext ()){
                dfsVisit (s, iterator.next ().getIndex (), visited);
            }
            s.push (adjList[i].getInfo ());
            System.out.println ("--dfsVisit: " + i + " Stack=" + s);
        }
    }

    void topological_sort_dfs(){
        boolean [] visited = new boolean[num_nodes];
        for(int i=0; i<num_nodes; i++)
            visited[i] = false;

        Stack<E> stack = new Stack<> ();

        for(int i=0; i<num_nodes; i++){
            dfsVisit (stack, adjList[i].getIndex (), visited);
        }

        while (!stack.isEmpty ()){
            System.out.println (stack.pop () + " ");
        }
    }

    /***********************************************************************************************************/

    @Override
    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.num_nodes; i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }

}


public class TopologicalSortTester {

    public static void main(String[] args) {

        int maximumVertices = 9;

        String[] obleka = new String[maximumVertices];

        obleka[0] = "DolenVesh";
        obleka[1] = "Chorapi";
        obleka[2] = "Chevli";
        obleka[3] = "Chasovnik";
        obleka[4] = "Pantaloni";
        obleka[5] = "Remen";
        obleka[6] = "Koshula";
        obleka[7] = "Palto";
        obleka[8] = "Mashna";

        Graph<String> g = new Graph<String>(maximumVertices, obleka);


        //adding edges
        g.addEdge(0, 4);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(4, 5);
        g.addEdge(6, 5);
        g.addEdge(6, 8);
        g.addEdge(8, 7);
        g.addEdge(5, 7);
        g.addEdge(4, 2);


        g.topological_sort_dfs();


    }

}

