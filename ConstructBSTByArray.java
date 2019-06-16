package LeetCode;

import java.util.Arrays;

public class ConstructBSTByArray {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = construct(arr, lo, mid - 1);
        root.right = construct(arr, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        Arrays.sort(nums);
        TreeNode treeNode = construct(nums, 0, nums.length - 1);
        System.out.println(treeNode);
    }
}
