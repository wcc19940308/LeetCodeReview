package LeetCode;

public class ValidateBST_98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public  boolean isValidBST(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        boolean res = judge(pre, root);
        return res;
    }

    public  boolean judge(TreeNode[] pre, TreeNode root) {
        if (root == null) return true;
        boolean left = judge(pre, root.left);
        if (pre[0] != null && pre[0].val >= root.val){
            return false;
        }
        pre[0] = root;
        boolean right = judge(pre, root.right);
        return left && right;
    }


}
