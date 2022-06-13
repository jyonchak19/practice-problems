package test.java.BinaryTreeExamples;

import main.java.BinaryTreeExamples.BinaryTreeProblems;
import main.java.BinaryTreeExamples.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeProblemsTest {
    public static TreeNode constructBinaryTree(int[] arr, TreeNode root, int i) {
        if(i < arr.length) {
            root = new TreeNode(arr[i]);
            root.left = constructBinaryTree(arr, root.left, 2 * i + 1);
            root.right = constructBinaryTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void printTreeInOrder(TreeNode root) {
        if(root == null)
            return;
        printTreeInOrder(root.left);
        System.out.print(root.value + " ");
        printTreeInOrder(root.right);
    }

    @Test
    public void levelOrderTestSimple() {
        TreeNode root = new TreeNode();
        int[] arr = {3, 9, 20, 1, 2, 15, 7, 4, 2};
        root = constructBinaryTree(arr, root, 0);

        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<>(Arrays.asList(3)));
        expectedResult.add(new ArrayList<>(Arrays.asList(9, 20)));
        expectedResult.add(new ArrayList<>(Arrays.asList(1, 2, 15, 7)));
        expectedResult.add(new ArrayList<>(Arrays.asList(4, 2)));

        Assert.assertEquals(expectedResult, BinaryTreeProblems.levelOrder(root));
    }

    @Test
    public void levelOrderBFSTestSimple() {
        TreeNode root = new TreeNode();
        int[] arr = {3, 9, 20, 1, 2, 15, 7, 4, 2};
        root = constructBinaryTree(arr, root, 0);

        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<>(Arrays.asList(3)));
        expectedResult.add(new ArrayList<>(Arrays.asList(9, 20)));
        expectedResult.add(new ArrayList<>(Arrays.asList(1, 2, 15, 7)));
        expectedResult.add(new ArrayList<>(Arrays.asList(4, 2)));

        Assert.assertEquals(expectedResult, BinaryTreeProblems.levelOrderBFS(root));
    }
}
