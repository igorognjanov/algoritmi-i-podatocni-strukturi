package LaboratoriskiVezbi.vezba10.SocialNetwork;


import AuditoriskiVezbi.aud10.Matrica_nenasocen.LinkedQueue;
import AuditoriskiVezbi.aud10.Matrica_nenasocen.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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

    public void printMatrix(){
        for(int i=0; i<numNodes; i++) {
            for (int j = 0; j < numNodes; j++)
                System.out.print (adjMat[i][j] + " ");
            System.out.println ();
        }
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
        Queue<Integer> q = new LinkedQueue<Integer> ();
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

//    public int getCounts(int x, int y){
//        boolean visited[] = new boolean[numNodes];
//        for (int i = 0; i < numNodes; i++)
//            visited[i] = false;
//        return count (x, y, 0, visited);
//    }
//
//    int count(int node, int end, int counter, boolean[] visited) {
//        visited[node] = true;
//        if(node == end){
//            return counter;
//        }
//       // System.out.println(node + ": " + nodes[node]);
//        int min = 100000;
//        for (int i = 0; i < numNodes; i++) {
//            if(adjacent(node, i)==1 && !visited[i]){
//                return count (i, end, counter + 1, visited);
//            }
//        }
//        return 0;
//    }


    public int getCount(int start, int end){
        boolean visited[] = new boolean[numNodes];
        for (int i = 0; i < numNodes; i++)
            visited[i] = false;
        visited[start] = true;
        //System.out.println(node+": " + nodes[node]);
        Queue<Integer> q = new LinkedQueue<Integer> ();
        q.enqueue(start);

        int counter = 0;
        int parent = start;

        int pom;

        while(!q.isEmpty() && q.peek () != end){
            pom = q.dequeue();
            if(q.peek () == null){
                counter ++;
                parent = pom;
            }
            else if(adjMat[q.peek ()][parent] == 0){
                counter++;
                parent = pom;
            }
            for (int i = 0; i < numNodes; i++) {
                if (!visited[i] && adjMat[i][pom] == 1){
                    visited[i] = true;
                    //System.out.println(i+": " + nodes[i]);
                    q.enqueue(i);
                }
            }
        }
        //printMatrix ();
        return counter;
    }



}




public class CountFacebookFriends {


    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        N = Integer.parseInt (br.readLine ());
        Graph<Integer> graph = new Graph<> (N);
        for(int i=0; i<N; i++){
            int m = Integer.parseInt (br.readLine ());
            for(int j=0; j<m; j++){
                int x = Integer.parseInt (br.readLine ().split (" ")[0]);
                graph.addEdge (i, x);
            }
        }

        System.out.println (graph.getCount (Integer.parseInt (br.readLine ()), Integer.parseInt (br.readLine ())));

    }
}
