package LeetCode;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i, j;
        for (i = n - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) break;
        }
        if (i == 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (j = i; j < n; j++) {
            if (nums[j] <= nums[i - 1] && nums[j - 1] > nums[i - 1]) {
                break;
            }
        }
        swap(nums, i - 1, j - 1);
        reverse(nums, i, n - 1);
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
