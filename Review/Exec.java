package LeetCode.Review;

import java.util.*;

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
        int target = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int res = partition(nums, lo, hi);
            if (res == target) {
                break;
            } else if (res < target) {
                lo = res + 1;
            } else {
                hi = res - 1;
            }
        }
        return nums[target];
    }

    public static int partition(int[] nums, int lo, int hi) {
        int random = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, random, hi);
        int pivot = nums[hi];
        while (lo < hi) {
            while (lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
            while (lo < hi && nums[hi] > pivot) hi--;
            nums[lo] = nums[hi];
        }
        nums[lo] = pivot;
        return lo;
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
