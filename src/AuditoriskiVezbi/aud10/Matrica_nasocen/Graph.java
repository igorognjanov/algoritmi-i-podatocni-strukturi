package AuditoriskiVezbi.aud10.Matrica_nasocen;


public class Graph <E> {

    int numNodes;
    E nodes[];
    int adjMat[][];

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        nodes = (E[]) new Object[numNodes];

        createNewAdjMat (numNodes);
    }

    public Graph(int numNodes, E[] nodes) {
        this.numNodes = numNodes;
        nodes = nodes;

        createNewAdjMat (numNodes);
    }

    public void createNewAdjMat(int numNodes) {
        adjMat = new int[numNodes][numNodes];

        for (int i = 0; i < numNodes; i++)
            for (int j = 0; j < numNodes; j++)
                adjMat[i][j] = 0;
    }

    public int adjecent(int x, int y){
        return adjMat[x][y];
    }

    public void addEdge(int x, int y){
        adjMat[x][y] = 1;
    }

    public void removeEdge(int x,  int y){
        adjMat[x][y] = 0;
    }

    public int getNum_nodes(){return numNodes;}

    public void setNum_nodes(int num_nodes){this.numNodes = num_nodes;}


}