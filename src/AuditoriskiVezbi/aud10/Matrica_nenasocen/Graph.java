package AuditoriskiVezbi.aud10.Matrica_nenasocen;

import java.util.Stack;

public class Graph <E> {

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
        nodes = nodes;

        createNewAdjMat (numNodes);
    }

    public void createNewAdjMat(int numNodes){
        adjMat = new int[numNodes][numNodes];

        for(int i=0; i<numNodes; i++)
            for (int j=0; j<numNodes; j++)
                adjMat[i][j] = 0;
    }

    public int adjacent(int x, int y){
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

    void dfsRecursive(int node, boolean visited[]) {
        visited[node] = true;
        System.out.println(node + ": " + nodes[node]);

        for (int i = 0; i < this.numNodes; i++) {
            if(adjacent(node, i)==1){
                if (!visited[i])
                    dfsRecursive(i, visited);
            }
        }
    }

    void dfsNonrecursive(int node) {
        boolean visited[] = new boolean[numNodes];
        for (int i = 0; i < numNodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node + ": " + nodes[node]);
        Stack<Integer> s = new Stack<Integer>();
        s.push(node);

        int pom;

        while (!s.isEmpty()) {
            pom = s.peek();
            int pom1 = pom;
            for (int i = 0; i < numNodes; i++) {
                if(adjacent(pom,i)==1){
                    pom1 = i;
                    if(!visited[i])
                        break;
                }
            }
            if(!visited[pom1]){
                visited[pom1] = true;
                System.out.println(pom1 + ": " + nodes[pom1]);
                s.push(pom1);
            }
            else
                s.pop();
        }

    }

    void bfs(int node){
        boolean visited[] = new boolean[numNodes];
        for (int i = 0; i < numNodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node+": " + nodes[node]);
        Queue<Integer> q = new LinkedQueue<Integer>();
        q.enqueue(node);

        int pom;

        while(!q.isEmpty()){
            pom = q.dequeue();
            for (int i = 0; i < numNodes; i++) {
                if(adjacent(pom, i)==1){
                    if (!visited[i]){
                        visited[i] = true;
                        System.out.println(i+": " + nodes[i]);
                        q.enqueue(i);
                    }

                }
            }


        }

    }

}
