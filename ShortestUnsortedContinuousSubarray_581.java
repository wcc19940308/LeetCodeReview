package LeetCode;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if (max > nums[i]) end = i;
            if (min < nums[n - i - 1]) start = n - i - 1;
        }
        return end - start + 1;
    }
}
