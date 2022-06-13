package main.java.BinaryTreeExamples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeProblems {

    // a tree is "uni-valued" if every node has the same value.
    public static boolean isUniValTree(TreeNode root, int currentValue) {
        if(root == null) return true;
        if(currentValue == -1) currentValue = root.value;
        return (root.value == currentValue) && isUniValTree(root.left, root.value) && isUniValTree(root.right, root.value);
    }

    public static boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        if(root.value > min && root.value < max) {
            return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
        }
        return false;
    }

    public static int height(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //        1
    //    3        2
    // 5         4     7

    //        2
    //   4       1      3
    //     5        4         7


    //      3
    //   4      5
    // 5   4        7=
    // = ( conditionalStatement ? ifTrueValue : ifFalseValue  ) + (...)
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        int newValue = (root1 == null ? 0 : root1.value) + (root2 == null ? 0 : root2.value);
        TreeNode newNode = new TreeNode(newValue);
        newNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newNode;
    }

    // 1 ) think out loud and talk pseudocode

    // A) look through both trees and find their leaf nodes (recursive) (traversal)
    // recurse through the tree and return a stack of the leaf nodes
    // B) compare those leaf nodes to see if they're the same (is not recursive?)

//    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
//        stack1.push(root1);
//        stack2.push(root2);
////        if(root1.left != null && root1.right != null)
////            stack1 = dfs(stack1);
//
//    }
    //     2           stack: 2
    //   3    4
    //      1   2
    // [3, 1, 2]
    // a method that returns the sequential ordering of the leaf nodes (left to right) (returned as a stack)
//    public static Stack<Integer> dfs(Stack<TreeNode> stack) {
//
//    }

    // totally separate method that will print leaf nodes sequentially of a given tree
    public static void dfsLeafNodesPrint(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            System.out.print(root.value + " ");

        if (root.left != null)
            dfsLeafNodesPrint(root.left);
        if(root.right != null)
            dfsLeafNodesPrint(root.right);
    }

    //

    // given the root of a binary tree, return it's max depth - which is the number of nodes along the longest path
    // from the root node to the farthest leaf node. You could use BFS, DFS, or a custom traversal algo
    //              3
    //        /           \
    //       9             20                ->    max depth is 4
    //                 /         \
    //                15            7
    //              /   \
    //             4     2
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);
        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }

    // given the root of a binary tree, return the 'level order traversal' - which is the traversal
    // from left to right, level by level
    //              3
    //        /           \
    //       9             20              --->    [[3], [9,20], [1,2,15,7], [4,2]]
    //      /  \         /         \
    //     1    2     15            7
    //              /   \
    //             4     2
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderHelper(root, 0, list);
        return list;
    }

    public static void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> list) {
        if(root == null)
            return;
        if(list.size() <= depth) {
            list.add(new ArrayList<>());
        }

        list.get(depth).add(root.value);
        levelOrderHelper(root.left, depth + 1, list);
        levelOrderHelper(root.right, depth + 1, list);
    }


    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    level.add(node.value);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!level.isEmpty())
                list.add(level);
        }
        return list;
    }
}

