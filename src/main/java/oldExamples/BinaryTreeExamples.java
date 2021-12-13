package main.java.oldExamples;

public class BinaryTreeExamples {
    class TreeNode {
        int value;
        TreeNode right;
        TreeNode left;
    }

    //           10
    //      5        15
    //   3    7          18
    // given a pointer to a BST (->10) low = 7, high = 15
    // output 32
    // rangeSumBST(root, 7, 15) // root is a pointer to 10

    //   5     rangeSumBST(root, 7, 15)
    // 3   7

    // rangeSumBST(root, 7, 15) <- first call

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.value >= low && root.value <= high) {
            return root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        else if(root.value < low)
            return rangeSumBST(root.right, low, high);
        else
            return rangeSumBST(root.left, low, high);
    }
    public int rangeSumBSTClean(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        int sum = 0;
        if (root.value > low)
            sum += rangeSumBSTClean(root.left, low, high);
        if (root.value < high)
            sum += rangeSumBSTClean(root.right, low, high);
        if (root.value >= low && root.value <= high)
            sum += root.value; // include the root
        return sum;
    }

    boolean isFull(TreeNode root){
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);
        return false;
    }
    // O(N^2))
    boolean isBalanced(TreeNode root) {
        return optimizedHeight(root) != -1;
    }
    // O(N)
    int optimizedHeight (TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = optimizedHeight(root.left);
        // if the left subtree is not balanced, return our false signal
        if (lHeight == -1)
            return -1;
        int rHeight = optimizedHeight(root.right);
        // if the right subtree is not balanced, return our false signal
        if (rHeight == -1)
            return -1;
        // add check to see if balanced
        if(Math.abs(lHeight - rHeight) <= 1)
            return Math.max(lHeight, rHeight) + 1;

        return -1;
    }
//         1 <-
//      2<-   1
//   3   4
// 1
    // 2

    // stack: 1,<- 1
    int height (TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    int countNodes (TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.value > min && root.value < max)
            return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
        return false;
    }


    /* ~~~~~~~~~ BINARY TREE TRAVERSAL TYPES ~~~~~~~ */
    public void preorderTraverse(TreeNode root) {
        if(root == null)
            return;
        System.out.println(root.value);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }


    // postorder: left, right, root
    public void postorderTraverse(TreeNode root){
        if(root == null)
            return;
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.println(root.value);
    }

    // inorder: left, root, right
    public void inorderTraverse(TreeNode root){
        if(root == null)
            return;
        inorderTraverse(root.left);
        System.out.println(root.value);
        inorderTraverse(root.right);
    }
}

//           1
//       12       9
//    5     6
// preorder: 1->12->5->6->9
// postorder: 5->6->12->9->1
// inorder: 5->12->6->1->9


