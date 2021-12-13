package main.java.graphProblems;
import java.util.*;

public class NaryTreeProblems {

    public static int maxDepth(NaryNode root) {
        Queue<NaryNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                NaryNode currentNode = q.poll();
                q.addAll(currentNode.children);

            }
            depth++;
        }
        return depth;
    }


    // print out a level order traversal of the given tree

//               1
//        2  3      4
//    5  6            7
//    output: [[1], [2,3,4], [5,6,7]]

    public static List<List<Integer>> levelOrderTraversal(NaryNode root) {
        Queue<NaryNode> q = new LinkedList<>();
        List<List<Integer>> output = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                NaryNode currentNode = q.poll();
                sublist.add(currentNode.value);
                q.addAll(currentNode.children);
            }
            output.add(sublist);
        }
        return output;
    }
}

