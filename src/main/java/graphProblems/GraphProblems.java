package main.java.graphProblems;

import java.util.*;

public class GraphProblems {

    // given an m x n 2D grid that represents some water and land.
    // via a map of 1s and 0s. 1s are land and the 0s are water
    // and an 'island' is surrounded by water and is formed by
    // connecting adjacent pieces of land.
    // given this grid of land, find the number of islands.
    private static LinkedList<Integer> adj[];

    // input grid: =
    // [ 1    1    1    1  ]
    // [ 1    1    0    1  ] --> 1 island
    // [ 1    1    0    0  ]
    // input grid2 =
    // [ 1   1  0  0  0 ]
    // [ 1   1  0  0  0 ]
    // [ 0   0  1  0  0 ] --> 3 islands
    // [ 0   0  0  1  1 ]
    // TODO finish this problem

    // assumption: there will only ever be '1's and '0's
    public static int numIslands(char[][] grid) {
        int n = grid.length; // rows
        int m = grid[0].length; // columns
        int islandCount = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    islandTraversal(grid, visited, i, j);
                }
            }
        }
        return islandCount;
    }

    // recursive helper
    public static void islandTraversal(char[][] grid, boolean[][] visited, int i, int j) {

    }

    // DFS iterative, based off of the video we watched last lesson
    public static void DepthFirstTraversalIterative(int startVertex, int totalNodesInGraph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[totalNodesInGraph];
        stack.push(startVertex);
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            for (int next : adj[curr]) {
                if (!visited[next])
                    stack.push(next);
            }
        }
    }

    // reviewing depth first search.
    // cycle: a node may be visited twice
    // DFS for graphs is very similar to trees BUT
    // graphs can contain CYCLES. To avoid this,
    // we can use a data structure to keep track of visited nodes.
    // let's just use a boolean 'visited' array.

    public static void depthFirstTraversalRecursive(int startVertex, int totalNodesInGraph){
        boolean[] visited = new boolean[totalNodesInGraph];
        DFSTraversalUtil(startVertex, visited);
    }

    // start at some node (v) and explore as far as possible
    // along a given branch before 'backtracking.'
    // 1. start from given node
    // 2. mark the node as visited
    // 3. move to an adjacent node
    // 4. recurse


    // assume we have an adj list, assume it's global
    // adj[v] -> list of nodes that are adjacent to v
    // Iterator<Integer> i = adj[v].listIterator();
    // i.hasNext() -> there are more in the list
    // i.next() -> grab the next adjacent node

    public static void DFSTraversalUtil(int v, boolean visited[]) {
        // visit and print the current node
        visited[v] = true;
        System.out.print(v + " ");

        // recursive step(s)
        for (int next : adj[v]) {
            if (!visited[next])
                DFSTraversalUtil(next, visited);
        }
    }

    // returns true if the node toFind is in the graph, false if not found
    public static boolean depthFirstSearchIterative(int start, int total, int toFind) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[total];
        stack.push(start);
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            if(curr == toFind)
                return true;
            for (int next : adj[curr]) {
                if (!visited[next])
                    stack.push(next);
            }
        }
        return false;
    }

    // returns true if the node toFind is in the graph, false if not found
    public static boolean depthFirstSearchRecursive(int start, int total, int toFind) {
        boolean[] visited = new boolean[total];
        return DFSRecursiveUtil(start, visited, toFind);
    }

    public static boolean DFSRecursiveUtil(int current, boolean[] visited, int toFind) {
        if (current == toFind)
            return true;
        visited[current] = true;
        System.out.print(current + " ");

        for (int next : adj[current]) {
            if (!visited[next])
                if (DFSRecursiveUtil(next, visited, toFind))
                    return true;
        }
        return false;
    }

    // if you know a solution is not far from the given node
    // broad/breadth is better BFS


}
