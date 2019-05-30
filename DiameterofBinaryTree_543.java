package LeetCode;

public class DiameterofBinaryTree_543 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        lengthOfTree(root);
        return max;
    }

    public int lengthOfTree(TreeNode root) {
        if (root == null) return 0;
        int left = lengthOfTree(root.left);
        int right = lengthOfTree(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
