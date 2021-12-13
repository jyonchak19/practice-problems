package main.java.graphProblems;

// simple graph
public class Graph {
    private boolean directed;
    private boolean weighted;
    private float[][] adjacencyMatrix;
    private int numNodes;

    private boolean[][] isSetMatrix; // instead of using inf/0

    public Graph(boolean directed, boolean weighted, int numNodes) {
        this.numNodes = numNodes;
        this.directed = directed;
        this.weighted = weighted;
        adjacencyMatrix = new float[numNodes][numNodes];
        isSetMatrix = new boolean[numNodes][numNodes];
    }

    public void addEdge(int source, int destination){
        int weightValue = 1;
        if (weighted)
                weightValue = 0;
        adjacencyMatrix[source][destination] = weightValue;
        isSetMatrix[source][destination] = true;
        if(!directed){
            adjacencyMatrix[destination][source] = weightValue;
            isSetMatrix[destination][source] = true;
        }
    }
    public void addEdge(int source, int destination, float weight) {
        float weightValue = weight;
        if (!weighted)
            weightValue = 1;
        adjacencyMatrix[source][destination] = weightValue;
        isSetMatrix[source][destination] = true;
        if (!directed) {
            adjacencyMatrix[destination][source] = weightValue;
            isSetMatrix[destination][source] = true;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if(isSetMatrix[i][j]) {
                    System.out.print(adjacencyMatrix[i][j]);
                }
                else {
                    System.out.print("/ ");
                }
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < numNodes; j++) {
                if(isSetMatrix[i][j])
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    public Float getEdgeValue(int source, int destination) {
        if(!weighted || !isSetMatrix[source][destination])
            return null;
        return adjacencyMatrix[source][destination];
    }
}
