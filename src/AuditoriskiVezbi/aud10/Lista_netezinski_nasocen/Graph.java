package AuditoriskiVezbi.aud10.Lista_netezinski_nasocen;

import java.util.Stack;

public class Graph<E> {

    int numNodes;
    GraphNode<E>[] adjList;

    public Graph(int numNodes, E[] nodes){
        this.numNodes = numNodes;
        this.adjList = (GraphNode<E>[]) new GraphNode[numNodes];
        for(int i=0; i<numNodes; i++){
            adjList[i] = new GraphNode<> (i, nodes[i]);
        }
    }

    public Graph(int numNodes){
        this.numNodes = numNodes;
        this.adjList = (GraphNode<E>[]) new GraphNode[numNodes];
    }

    public int adjecent(int x, int y){
        return adjList[x].containsNeighbor (adjList[y])?1:0;
    }

    public void addEdge(int x, int y){
        if(!adjList[x].containsNeighbor (adjList[y]))
            adjList[x].addNeighbor (adjList[y]);
    }

    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }

    public void dfsNonRecursive(int node){
        boolean [] visited = new boolean[numNodes];
        for(int i=0; i<numNodes; i++)
            visited[i] = false;
        visited[node] = true;
        GraphNode<E> pom = null;
        System.out.println (node + ": " + adjList[node].getInfo ());
        Stack<Integer> stack = new Stack<Integer>();
        stack.push (node);
        while (!stack.isEmpty ()){
            pom = adjList[stack.peek ()];
            GraphNode<E> temp = null;
            for(int i=0; i<pom.getNeighbors ().size (); i++){
                temp = pom.getNeighbors ().get (i);
                if(!visited[temp.getIndex ()]){
                    break;
                }
            }

            if(temp != null && !visited[temp.getIndex ()]){
                visited[temp.getIndex ()] = true;
                System.out.println (temp.getIndex () + ": " + temp.getInfo ());
                stack.push (temp.getIndex ());
            }
            else stack.pop ();
        }

    }

    public void dfs(int node){
        boolean visited[] = new boolean[numNodes];
        for(int i=0; i<numNodes; i++)
            visited[i] = false;
        dfsSearch(node, visited);
    }

    public void dfsSearch(int node, boolean[] visited){
        visited[node] = true;
        System.out.println (node + ": " + adjList[node].getInfo ());

        for (int i=0; i<adjList[node].getNeighbors ().size (); i++){
            int n = adjList[node].getNeighbors ().get (i).getIndex ();
            if(!visited[n]){
                dfsSearch (n, visited);
            }
        }
    }

    public void bfs(int node){
        boolean visited[] = new boolean[numNodes];
        for(int i=0; i<numNodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println (node + ": " + adjList[node].getInfo ());
        Queue<Integer> queue = new LinkedQueue<> ();
        queue.enqueue (node);
        GraphNode<E> pom = null;
        while (!queue.isEmpty ()){
            pom = adjList[queue.dequeue ()];
            GraphNode<E> temp = null;
            for(int i=0; i<pom.getNeighbors ().size (); i++){
                temp = pom.getNeighbors ().get (i);
                if(!visited[temp.getIndex ()]){
                    visited[temp.getIndex ()] = true;
                    System.out.println (temp.getIndex () + ": " + temp.getInfo ());
                    queue.enqueue (temp.getIndex ());
                }
            }
        }

    }




    @Override
    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.numNodes; i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }



    public static void main(String[] args) {
        Character niza[] = new Character[10];
        //Postavuvanje na bukvite od A do J vo niza
        //0:A 1:B 2:C 3:D 4:E 5:F 6:G 7:H 8:I 9:J
        for(int i=0;i<10;i++)
            niza[i] = (char)((int)'A'+i);
        Graph<Character> g = new Graph<Character>(10,niza);
        g.addEdge(0, 1); //dodavam rebro od A do B
        g.addEdge(1, 2); //dodavam rebro od B do C
        g.addEdge(2, 3); //dodavam rebro od C do D
        g.addEdge(3, 6); //dodavam rebro od D do G
        g.addEdge(6, 9); //dodavam rebro od G do J
        g.addEdge(2, 5); //dodavam rebro od B do F
        g.addEdge(5, 8); //dodavam rebro od F do I
        g.addEdge(0, 4); //dodavam rebro od A do E
        System.out.print(g);
        System.out.println("Depth First Search Recursive:");
        g.dfs(0);
        System.out.println("Depth First Search Nonrecursive:");
        g.dfsNonRecursive(0);
        System.out.println("Breath First Search:");
        g.bfs(0);

    }


}
