package main.java.graphProblems;

// import java.awt.*;

public class Driver {
    public static void main(String[] args) {

//        System.out.println("Adjacency Matrix Graph: ");
//        Graph graph = new Graph(false, true, 5);
//        graph.addEdge(0, 2, 19);
//        graph.addEdge(0,3, -4);
//        graph.addEdge(1, 2, 3);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 3);
//        graph.printMatrix();
//        graph.printEdges();
//
        System.out.println("Adjacency List Graph: ");
        AdjListGraph adjListGraph = new AdjListGraph(true);
        Node d = new Node(3, "D");
        adjListGraph.addNode(d);
        Node a = new Node(0, "A");
        adjListGraph.addNode(a);
        Node b = new Node(1, "B");
        adjListGraph.addNode(b);
        Node c = new Node(2, "C");
        adjListGraph.addNode(c);


        adjListGraph.addEdge(a,b);
        adjListGraph.addEdge(b,c);
        // adjListGraph.addEdge(c,a);
        adjListGraph.addEdge(d,c);

        // adjListGraph.printEdges();
        // adjListGraph.printNodesVisitedStatus();
        // adjListGraph.BFS(a);
        // System.out.println("Ran BFS...");
        // adjListGraph.printNodesVisitedStatus();
        // adjListGraph.printNodes();




        System.out.println("Test 1: A,B,C,D graph which contains a cycle...");
        System.out.println("Does the graph contain a cycle?: " +adjListGraph.hasCycle());

        // check if the graph has cycles, if non-cyclic and directed, determine top ordering
        if(!adjListGraph.hasCycle() && adjListGraph.isDirected()) {
            System.out.print("Topological ordering: ");
            adjListGraph.topologicalSort();
            System.out.println();
        }
//        NaryNode b = new NaryNode(1);
//        NaryNode a = new NaryNode(2);
//        List<NaryNode> adjNodes = new ArrayList<>();
//        adjNodes.add(a);
//        adjNodes.add(b);
//        NaryNode root = new NaryNode(0, adjNodes);
//
//        System.out.println("The result of maxDepth for our tree is: " + NaryTreeProblems.maxDepth(root));
//        System.out.println("The result of levelOrderTraversal for our tree is: " + NaryTreeProblems.levelOrderTraversal(root));

    }
}
