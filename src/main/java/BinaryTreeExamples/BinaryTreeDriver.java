package main.java.BinaryTreeExamples;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode root2 = new TreeNode();
        int[] arr = {3, 1, 5, 0, 2, 4, 6};
        int[] arr2 = {2, 2, 2, 4, 9};
        root = constructBinaryTree(arr, root, 0);
        root2 = constructBinaryTree(arr2, root2, 0);
        printTreeInOrder(Problems.mergeTrees(root, root2));
//        System.out.println(Problems.isUniValTree(root, -1));
//        System.out.println(Problems.isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        //printTreeInOrder(root);
    }
    // constructs a complete binary tree from the array in level order
    // [3, 1, 5, 0, 2, 4, 6]
//           5
//       3       7
//    4    11   4    6
//          2
    //   2     2
    //  4  9
    // 4 2 5 1 6 3
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
}





