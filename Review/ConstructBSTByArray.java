package LeetCode.Review;

/**
 * 通过数组构造二叉树
 */
public class ConstructBSTByArray {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode construct(int[] arr, int lo, int hi) {
        if (lo < hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = construct(arr, lo, mid);
        root.right = construct(arr, mid + 1, hi);
        return root;
    }

}
