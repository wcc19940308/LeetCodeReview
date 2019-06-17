package LeetCode;

import java.util.Stack;

public class ConvertBSTtoGreaterTree_538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode res = root;
        int sum = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root.val += sum;
            sum = root.val;
            root = root.left;
        }
        return res;
    }
}
