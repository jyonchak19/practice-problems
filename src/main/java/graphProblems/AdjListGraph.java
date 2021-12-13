package main.java.graphProblems;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AdjListGraph {
    //              key      value
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;
    private List<Node> nodes; // all nodes

    public AdjListGraph(boolean directed) {
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
        this.nodes = new ArrayList<>();
    }

    // up to user to decide on duplicates
    public void addNode(Node node) {
        nodes.add(node);
        LinkedList<Node> defaultList = new LinkedList<>();
        adjacencyMap.put(node, defaultList);
    }

    // this should be called after nodes are added
    public void addEdge(Node source, Node destination) {
        if(!adjacencyMap.containsKey(source))
            adjacencyMap.put(source, null);

        if(!adjacencyMap.containsKey(destination))
            adjacencyMap.put(destination, null);

        addEdgeHelper(source, destination);

        if (!directed)
            addEdgeHelper(destination, source);
    }
    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> adjacentNodes = adjacencyMap.get(a);
        if(adjacentNodes != null)
            adjacentNodes.remove(b);
        else {
            adjacentNodes = new LinkedList<>();
        }
        adjacentNodes.add(b);
        adjacencyMap.put(a, adjacentNodes);
    }

    // for (Item item: List.getSet())
    // map.keySet() -> [Node1, Node2, ...]
    public void printEdges() {
        for(Node node: adjacencyMap.keySet()) {
            System.out.print("Node " + node.id + " is connected to: ");
            LinkedList<Node> adjacentNodes = adjacencyMap.get(node);
            if(adjacentNodes == null)
                System.out.print("nothing");
            else {
                for(Node neighbor: adjacentNodes){
                    System.out.print(neighbor.id + " ");
                }
            }
            System.out.println();
        }
    }

    // prints all nodes in the graph
    public void printNodes() {
        System.out.print("All nodes: ");
        for(Node node: nodes){
            System.out.print(node.id + " ");
        }
        System.out.println();
    }

    // prints all the nodes in the graph and their visited status
    public void printNodesVisitedStatus() {
        for(Node node: adjacencyMap.keySet()) {
            System.out.println("Node " + node.id + " visited = " + node.visited);
        }
    }

    // checks only one direction
    public boolean hasEdge(Node source, Node destination) {
        if(!adjacencyMap.containsKey(source))
            return false;
        LinkedList<Node> adjacentNodes = adjacencyMap.get(source);
        if(adjacentNodes == null)
            return false;
        return adjacentNodes.contains(destination);
    }

    // DFS stack - recursive
    public void DFS(Node root) {
        if (root == null)
            return;
        root.visited = true; // mark it visited
        for (Node n: adjacencyMap.get(root)) {
            if (!n.visited) {
                DFS(n);
            }
        }
    }

    public boolean DFSFind(Node root, Node toFind) {
        if (root == null)
            return false;
        if (root == toFind)
            return true;
        root.visited = true; // mark it visited
        for (Node n: adjacencyMap.get(root)) {
            if (!n.visited) {
                DFSFind(n, toFind);
            }
        }
        return false;
    }

    public void DFSIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            currentNode.visited = true;
            for(Node n: adjacencyMap.get(currentNode)){
                if(!n.visited) {
                    stack.push(n);
                }
            }
        }
    }

    public boolean DFSIterativeFind(Node root, Node toFind) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            currentNode.visited = true;
            if(currentNode == toFind)
                return true;
            for(Node n: adjacencyMap.get(currentNode)) {
                if(!n.visited) {
                    stack.push(n);
                }
            }
        }
        return false;
    }

    // BFS queue - non-recursive
    // 1) initialize a queue
    // 2) mark the root as visited
    // 3) add the root to the end of the queue (enqueue)
    // 4) while the queue is not empty:
    //   4a) get the first node from the front of the queue (removing it from the queue)
    //   4b) for each adjacent node (that we haven't yet visited!), we'll go through and visit them, then add them to the queue

    public void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        root.visited = true;
        q.add(root);
        while(!q.isEmpty()) {
            Node currentNode = q.poll();
            for(Node n: adjacencyMap.get(currentNode)){
                if(!n.visited) {
                    q.add(n);
                    n.visited = true;
                }
            }
        }
    }

    public int BFSLevelFirst(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                 Node currentNode = q.poll();
                 for (Node n: adjacencyMap.get(currentNode))
                    q.add(n);

            }
            depth++;
        }
        return depth;
    }

    public boolean BFSFind(Node root, Node toFind) {
        Queue<Node> q = new LinkedList<>();
        root.visited = true;
        q.add(root);
        if(root == toFind)
            return true;
        while(!q.isEmpty()) {
            Node currentNode = q.poll();
            for (Node n: adjacencyMap.get(currentNode)) {
                if (!n.visited) {
                    q.add(n);
                    n.visited = true;
                    if(n == toFind)
                        return true;
                }
            }
        }
        return false;
    }

    // assume that the graph is directed
    // this method checks for cycles from given sourceNode
    public boolean hasCycle(Node sourceNode) {

        sourceNode.visiting = true; // starting with Node A ...
        for (Node n: adjacencyMap.get(sourceNode)) {
            if(n.visiting)
                return true; // detected a cycle!!
            else if (!n.visited && hasCycle(n)) {
                return true;
            }
        }
        sourceNode.visiting = false;
        sourceNode.visited = true;
        return false;
    }

    // this method checks the whole graph
    public boolean hasCycle() {
        for (Node node: nodes) {
            if(!node.visited && hasCycle(node)) {
                resetVisited();
                return true;
            }
        }
        resetVisited();
        return false;
    }
     //    1~
     // 2~     3~
     // 3 , 2 , 1 (order of pushes)

    public void topologicalDFS(Node currentNode, Stack<Node> stack) {
        if(currentNode == null)
            return;
        currentNode.visited = true;
        for(Node n: adjacencyMap.get(currentNode)) {
            if(!n.visited) {
                topologicalDFS(n, stack);
            }
        }
        stack.push(currentNode);
    }

    // this will print the topological ordering
    public void topologicalSort() {
        Stack<Node> stack = new Stack<>();
        for(Node node: nodes) {
            if(!node.visited) {
                topologicalDFS(node, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().id + " ");
        }
    }

    public boolean isDirected() {
        return directed;
    }

    public void resetVisited(){
        for(Node node: nodes){
            node.visited = false;
        }
    }

}

