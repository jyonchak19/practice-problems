package main.java.graphProblems;

import java.util.*;

public class GraphProblems {

    // list of LinkedLists, ex adj[1] -> adj nodes for the node 1
    private static LinkedList<Integer> adj[];

    // given an m x n 2D grid that represents some water and land.
    // via a map of 1s and 0s. 1s are land and the 0s are water
    // and an 'island' is surrounded by water and is formed by
    // connecting adjacent pieces of land.
    // given this grid of land, find the number of islands.
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
                    islandTraversal(grid, visited, i, j, n, m);
                }
            }
        }
        return islandCount;
    }

    // recursive helper
    public static void islandTraversal(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        islandTraversal(grid, visited, i - 1, j, n, m);
        islandTraversal(grid, visited, i +1, j, n, m);
        islandTraversal(grid, visited, i, j - 1, n, m);
        islandTraversal(grid, visited, i, j + 1, n, m);
    }


    // x,y, newColor -> 'flood fill' the image starting from image[x][y] with color newColor
    // flood fill -> from the starting pixel, we'll move 4-directionally like before (up,down, left, right)
    // and color all places that are the same color as the starting pixel with the new color
    // [1 1 1 1]                           [32 32 32 32]
    // [1 1 3 5]  x=1,y=1, newColor=32 --> [32 32  3 5]
    // [1 2 1 1]                           [32  2  1 1]
    // [1 1 7 8]                           [32 32  7 8]
    public static int[][] pixelFloodFill(int[][] image, int x, int y, int newColor) {
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length) {
            return image;
        }
        pixelFloodFillHelper(image, x, y, newColor, image[x][y]);
        return image;
    }

    public static void pixelFloodFillHelper(int[][] image, int x, int y, int newColor, int oldColor) {
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length
                || image[x][y] != oldColor || oldColor == newColor) {
            return;
        }

        image[x][y] = newColor;
        pixelFloodFillHelper(image, x - 1, y, newColor, oldColor);
        pixelFloodFillHelper(image, x + 1, y, newColor, oldColor);
        pixelFloodFillHelper(image, x, y - 1, newColor, oldColor);
        pixelFloodFillHelper(image, x, y + 1, newColor, oldColor);
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
    public static void bfsTraversal(int start, int total) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[total];
        queue.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.remove();
            visited[curr] = true;
            for(int next : adj[curr]) {
                if (!visited[next])
                    queue.add(next);
            }
        }
    }

    public static boolean breadthFirstSearch(int start, int total, int toFind) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[total];
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            visited[curr] = true;
            if (curr == toFind)
                return true;
            for (int next : adj[curr]) {
                if (!visited[next])
                    queue.add(next);
            }
        }
        return false;
    }

    // given a row x col grid that represents a map where grid[i][j] = 1 represents land
    // and the grid[i][j] = 0 represents water. Grid cells are connected horiz/vert, not diagonally.
    // the grid will contain only one island that is completely surrounded by water.
    // the island will never have 'lakes'
    // grid will be rect, width and height will never be greater than 100
    // determine the perimeter of the island.
    // ex:
    // [ 0 1 0 0 ]
    // [ 1 1 1 0 ]
    // [ 0 1 0 0 ]  -> result: 16, perimeter is 16
    // [ 1 1 0 0 ]
// ex 2
    // [ 0 0 0 0 ]
    // [ 0 1 1 0 ] -> 12
    // [ 0 1 0 1 ]
    // [ 1 1 1 1 ]
    public static int islandPerimeter(int[][]grid) {
        int perimeterCount = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    queue.add(new Integer[]{i, j});

                    while(!queue.isEmpty()) {
                        Integer[] curr = queue.remove();
                        visited[curr[0]][curr[1]] = true;

                        perimeterCount += islandPerimeterHelper(grid, i + 1, j,
                                queue, visited);
                        perimeterCount += islandPerimeterHelper(grid, i - 1, j,
                                queue, visited);
                        perimeterCount += islandPerimeterHelper(grid, i, j + 1,
                                queue, visited);
                        perimeterCount += islandPerimeterHelper(grid, i, j - 1,
                                queue, visited);
                    }
                }
            }
        }

        return perimeterCount;
    }

    public static int islandPerimeterHelper(int[][]grid, int i, int j,
                                            Queue<Integer[]> queue, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 1;
        if(visited[i][j])
            return 0;
        if(grid[i][j] == 1) {
            return 0;
        }
        return 1;
    }

    // given a square chessboard of N x N size, the position of a knight and of a target square
    // are given. we have to find the min num of steps the knight needs to take to get to the target
    // N = 8, knight (7,0) -> (0,7)

    // [0 0 0 0 0 0 0 f ]
    // [0 0 0 0 0 0 0 0 ]
    // [0 0 0 0 0 0 0 0 ]
    // [0 0 x 0 0 0 0 0 ]
    // [0 0 0 0 0 0 0 0 ]
    // [0 x 0 0 0 0 0 0 ]
    // [0 0 x 0 0 0 0 0 ]
    // [k 0 0 0 0 0 0 0 ]

    // weighted graph, dijkstra's - just a modified BFS
    // with a weighted graph, BFS is no longer the simple
    // solution for a shortest path. BUT if there are no
    // weights, we can use BFS to find the shortest path.

    //     a*
    //   /    \
    //   b     c
    //  /  \  /  \
    // d   e  f   g

    // start = [7, 0]
    //          x, y
    static class Move {
        int x, y, distance;
        public Move(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // start: (x, y), target: (x, y)
    public static int minKnightMoves(int[] start, int[] target, int n) {
        Queue<Move> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = { 1, -1,  2, -2, 2,-2, 1,-1};
        // push start onto queue
        queue.add(new Move(start[0], start[1], 0));
        while(!queue.isEmpty()) {
            Move curr = queue.remove();
            if (curr.x == target[0] && curr.y == target[1])
                return curr.distance;
            // loop through all possible moves...
            for (int i = 0; i < 8; i++) {
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];
                int dis = curr.distance;
                // still need to check if inside the board
                // AND that we haven't visited already
                if (insideBounds(n, x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Move(x, y, dis + 1));
                }
            }
        }
        return -1;
    }

    private static boolean insideBounds(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static boolean insideBounds(int n, int m, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // given a rectangular field matrix with a few sensor bombs,
    // cross the field by taking the shortest safe route without
    // activating the sensors.

    // [0 1 1 1 0 1 1 1 1 1 ]
    // [1 1 1 1 1 1 1 1 1 1 ]
    // [1 1 1 1 1 1 1 1 0 1 ]
    // [1 1 1 1 1 1 1 1 1 1 ]

    // [0 2 1 2 0 2 1 1 1 1 ]
    // [2 2 1 2 2 2 1 2 2 2 ]
    // [1 1 1 1 1 1 1 2 0 2 ]   --> return num of steps
    // [1 1 1 1 1 1 1 2 2 2 ]

    // Q: (Moves) M1: 0,0,0, M2: 0,1, dist: 1
    // extend this to print out the moves next time
    public static int shortestDistanceBombs(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Queue<Move> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int currDistance = Integer.MAX_VALUE;
        int[] dx = {-1, 1, 0, 1, -1, 0, 1, -1};
        int[] dy = {-1, 1, 1, 0, 0, -1, -1, 1};
        int moves = 8, bombDetectedValue = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for (int k = 0; k < moves; k++) {
                    if (matrix[i][j] == 0 && insideBounds(n, m, i + dx[k], j + dy[k])
                            && matrix[i + dx[k]][j + dy[k]] == 1) {
                        matrix[i + dx[k]][j + dy[k]] = bombDetectedValue;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 1) {
                queue.add(new Move(i, 0, 0));
                visited[i][0] = true;
            }
        }

        int[] d2x = {0, 1, -1, 0};
        int[] d2y = {1, 0, 0, -1};
        int adjMoves = 4;

        while(!queue.isEmpty()) {
            Move curr = queue.remove();
            if (curr.y == m - 1 ) //&& curr.distance < currDistance
                //currDistance = curr.distance;
                return curr.distance;
            for (int i = 0; i < adjMoves; i++) {
                int x = curr.x + d2x[i];
                int y = curr.y + d2y[i];
                int dis = curr.distance;
                if (matrix[curr.x][curr.y] == 1 && insideBounds(n, m, x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Move(x, y, dis + 1));
                }
            }
        }
        return currDistance;
    }


    // given a binary rectangular maze, find the shortest path from (x, y), to (a,b)
    // the path can only be constructed from True cells
    // we can only move one step in one of four directions
    // (x, y) -> x+1, x-1, y+1,y-1 (possible moves)
    // constraint: must use backtracking.
    // we will return the length of the shortest path.
    //   if (x,y) = (0,0) and (a,b) = (7,5) in the matrix below...
    //  the shortest path from the source to the goal has a length of 12.
    //            [ 1  1  1  1  1  0  0  1  1  1 ]
    //            [ 0  1  1  1  1  1  0  1  0  1 ]
    //            [ 0  0  1  0  1  1  1  0  0  1 ]
    //            [ 1  0  1  1  1  0  1  1  0  1 ]
    //            [ 0  0  0  1  0  0  0  1  0  1 ]
    //            [ 1  0  1  1  1  0  0  1  1  0 ]
    //            [ 0  0  0  0  1  0  0  1  0  1 ]
    //            [ 0  1  1  1  1  1  1  1  0  0 ]
    //            [ 1  1  1  1  1  0  0  1  1  1 ]
    //            [ 0  0  1  0  0  1  1  0  0  1 ]

    public static int findShortestPath(boolean[][] matrix, int x, int y, int a, int b) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return findShortestPathHelper(matrix, x, y, a, b, visited, 0, Integer.MAX_VALUE);
    }
    // need a recursive helper
    public static int findShortestPathHelper(boolean[][] matrix, int x, int y, int a, int b,
                                             boolean[][] visited, int currDistance, int minDistance) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        visited[x][y] = true;
        if(x == a && y == b && currDistance < minDistance)
            minDistance = currDistance;
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (insideBounds(matrix.length, matrix[0].length, x1, y1) && matrix[x1][y1] && !visited[x1][y1]) {
                findShortestPathHelper(matrix,x1, y1, a, b, visited, currDistance + 1, minDistance);
            }
        }
        visited[x][y] = false;
        return minDistance;
    }
}
