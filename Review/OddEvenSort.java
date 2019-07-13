package LeetCode.Review;

import java.util.Arrays;

/**
 * ÂÒĞòÊı×é£¬ÅÅĞòÊ¹µÃ×óÆæÓÒÅ¼
 */
public class OddEvenSort {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 6, 9, 4, 2, 1, 5, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] % 2 == 0) {
                right++;
            } else {
                swap(nums, left++, right++);
            }
        }
    }

    public static void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}
