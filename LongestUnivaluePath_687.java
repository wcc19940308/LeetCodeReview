package LeetCode;

public class LongestUnivaluePath_687 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        univalePath(root);
        return max;
    }

    // �������㣬������һ���ӽڵ�����·������,����max����ʹ��2���ӽڵ�
    public int univalePath(TreeNode root) {
        if (root == null) return 0;
        int left = univalePath(root.left);
        int right = univalePath(root.right);
        int pl = 0, pr = 0;
        if (root.left != null && root.left.val == root.val) {
            pl += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            pr += right + 1;
        }
        max = Math.max(max, pl + pr);
        return Math.max(pl, pr);
    }
}
