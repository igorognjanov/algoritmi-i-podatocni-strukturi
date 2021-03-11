package LaboratoriskiVezbi.vezba10.GraphCreate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Graph <E> {

    int numNodes;
    E nodes[];
    int adjMat[][];

    public Graph(int numNodes){
        this.numNodes = numNodes;
        nodes = (E[]) new Object [numNodes];

        createNewAdjMat(numNodes);
    }

    public Graph(int numNodes, E[] nodes){
        this.numNodes = numNodes;
        this.nodes = nodes;

        createNewAdjMat (numNodes);
    }

    public void createNewAdjMat(int numNodes){
        adjMat = new int[numNodes][numNodes];

        for(int i=0; i<numNodes; i++)
            for (int j=0; j<numNodes; j++)
                adjMat[i][j] = 0;
    }

    public int adjecent(int x, int y){
        return adjMat[x][y];
    }

    public void addEdge(int x, int y){
        adjMat[x][y] = 1;
        adjMat[y][x] = 1;
    }

    public void removeEdge(int x, int y){
        adjMat[x][y] = 0;
        adjMat[y][x] = 0;
    }

    public int getNum_nodes(){
        return numNodes;
    }
    public void setNum_nodes(int num_nodes){
        this.numNodes = num_nodes;
    }

    public E getNodes(int i) {
        if(i>=0 && i<nodes.length){
            return nodes[i];
        }
        return null;
    }

    public void printMatrix(){
        for(int i=0; i<numNodes; i++){
            for(int j=0; j<numNodes; j++){
                System.out.print (adjMat[i][j] + " ");
            }
            System.out.println ();
        }
    }

}

public class GraphCreate {

    public static Graph<Character> create(int n){
        Character [] niza = new Character[n];
        for(int j=0; j<n; j++) {
            niza[j] = (char) ('A' + (j % 26));
        }
        return new Graph<Character> (n, niza);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));
        Graph<Character> graph = null;
        int N = Integer.parseInt (bufferedReader.readLine ());
        for(int i=0; i<N; i++){
            String [] parts = bufferedReader.readLine ().split (" ");
            if(parts[0].equals ("CREATE")) {
                graph = create (Integer.parseInt (parts[1]));
            }
            else if(parts[0].equals ("ADDEDGE")){
                int n1 = Integer.parseInt (parts[1]);
                int n2 = Integer.parseInt (parts[2]);
                graph.addEdge (n1, n2);
            }
            else if(parts[0].equals ("DELETEEDGE")){
                int n1 = Integer.parseInt (parts[1]);
                int n2 = Integer.parseInt (parts[2]);
                graph.removeEdge (n1, n2);
            }
            else if(parts[0].equals ("ADJACENT")){
                int n1 = Integer.parseInt (parts[1]);
                int n2 = Integer.parseInt (parts[2]);
                System.out.println (graph.adjecent (n1, n2));
            }
            else if(parts[0].equals ("PRINTMATRIX")){
                graph.printMatrix ();
            }
            else if(parts[0].equals ("PRINTNODE")){
                int n1 = Integer.parseInt (parts[1]);
                System.out.println (graph.nodes[n1]);
            }
        }

    }
}
