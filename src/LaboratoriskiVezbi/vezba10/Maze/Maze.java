package LaboratoriskiVezbi.vezba10.Maze;

import AuditoriskiVezbi.aud10.Maze.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Stack;

public class Maze {
    Graph<Integer> graph;
    Hashtable<Integer, String> hashtable2;
    Hashtable<String, Integer> hashtable;
    int startNode;
    int numNodes;
    int endNode;

    int rows;
    int columns;

    char [][] matrix;

    public Maze(){
        hashtable2 = new Hashtable<> ();
        hashtable = new Hashtable<> ();
    }

    public void generateGraph(int rows, int columns, String[] in){
        this.rows = rows;
        this.columns = columns;

        numNodes = 0;
        matrix = new char[rows][columns];

        String key;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = in[i].charAt (j);
                if(in[i].charAt (j) != '#'){
                    key = i + "," + j;
                    hashtable2.put (numNodes, key);
                    hashtable.put (key, numNodes);
                    if(in[i].charAt (j) == 'S')
                        startNode = hashtable.get (i + "," + j);
                    if(in[i].charAt (j) == 'E')
                        endNode = hashtable.get (i + "," + j);
                    numNodes ++;
                }
            }
        }
        graph = new Graph<> (numNodes);

        int x, y;

        for(int i=1; i<rows; i++){
            for (int j=1; j<columns; j++){
                if(in[i].charAt (j) != '#'){
                    //Desno
                    if(in[i].charAt (j+1) != '#'){
                        x = hashtable.get (i + "," + j);
                        y = hashtable.get (i + "," + (j+1));
                        graph.addEdge (x, y);
                    }
                    //Levo
                    if(in[i].charAt (j-1) != '#'){
                        x = hashtable.get (i + "," + j);
                        y = hashtable.get (i + "," + (j-1));
                        graph.addEdge (x, y);
                    }
                    //Gore
                    if(in[i+1].charAt (j) != '#'){
                        x = hashtable.get (i + "," + j);
                        y = hashtable.get ((i+1) + "," + j);
                        graph.addEdge (x, y);
                    }
                    //Dole
                    if(in[i-1].charAt (j) != '#'){
                        x = hashtable.get (i + "," + j);
                        y = hashtable.get ((i-1) + "," + j);
                        graph.addEdge (x, y);
                    }
                }
            }
        }
    }

    public void printMatrix(){
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print (matrix[i][j] + " ");
            System.out.println ();
        }
    }

    public void findPath(){
        boolean visited[] = new boolean[numNodes];
        for (int i = 0; i < numNodes; i++)
            visited[i] = false;
        visited[startNode] = true;
        //System.out.println(startNode + ": " + graph.nodes[startNode]);
        Stack<Integer> s = new Stack<Integer>();
        s.push(startNode);



        int pom;

        while (!s.isEmpty() && s.peek () != endNode) {
            pom = s.peek ();
            int pom1 = pom;
            for (int i = 0; i < numNodes; i++) {
                if (graph.adjacent (pom, i) == 1) {
                    pom1 = i;
                    if (!visited[i])
                        break;
                }
            }
            if (!visited[pom1]) {
                visited[pom1] = true;
                //System.out.println(pom1 + ": " + graph.nodes[pom1]);
                s.push (pom1);
            } else
                s.pop ();
        }
        if(s.isEmpty ()){
            System.out.println ("Nema resenie...");
        }
        else {
            int n, x, y;
            String key;
            Stack<Integer> s2 = new Stack<> ();
            while (!s.isEmpty ()){
                 s2.push(s.pop ());
//                key = hashtable2.get (n);
//                x = Integer.parseInt (key.split (",")[0]);
//                y = Integer.parseInt (key.split (",")[1]);
//                if(matrix[x][y] != 'S' && matrix[x][y] != 'E') matrix[x][y] = 'o';
            }
            while (!s2.isEmpty ()){
                System.out.println (hashtable2.get (s2.pop ()));
            }
//            printMatrix ();
        }


    }
    public static void main(String args[]) throws IOException {
        Maze m = new Maze ();
        int rows;
        int columns;
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String line = br.readLine ();
        rows = Integer.parseInt (line.split (",")[0]);
        columns = Integer.parseInt (line.split (",")[1]);

        String[] in = new String[rows];

        for(int i=0; i<rows; i++)
            in[i] = br.readLine ();

        m.generateGraph(rows, columns, in);

        m.findPath();
    }

}
