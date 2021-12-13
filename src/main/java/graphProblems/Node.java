package main.java.graphProblems;

public class Node {
    int val;
    String id;
    Boolean visited;
    Boolean visiting;
    Node (int val, String id) {
        this.val = val;
        this.id = id;
        this.visited = false;
        this.visiting = false;
    }
}
