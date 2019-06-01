package LeetCode.Review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Exec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        int index = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
        return nums[index];
    }

    public static int quickSelect(int[] nums, int lo, int hi, int k) {
        int random = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, random, hi);
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) {
            return i;
        } else if (m < k) {
            return quickSelect(nums, i + 1, hi, k - m);
        } else {
            return quickSelect(nums, lo, i - 1, k);
        }

    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }



}
