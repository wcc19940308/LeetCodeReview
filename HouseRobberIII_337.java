package LeetCode;

public class HouseRobberIII_337 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] res = recursive(root);
        return Math.max(res[0], res[1]);
    }

    public int[] recursive(TreeNode root) {
        if (root == null) return new int[2];
        int[] res = new int[2];
        int[] left, right;
        left = recursive(root.left);
        right = recursive(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
