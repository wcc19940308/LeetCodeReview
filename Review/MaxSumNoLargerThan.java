package LeetCode.Review;

import java.util.TreeSet;

/**
 * 求一维数组中不大于k的最大子数组和
 * https://www.programcreek.com/2016/08/maximum-sum-of-subarray-close-to-k/
 */
public class MaxSumNoLargerThan {
    public static int maxSumNoLargerThan(int[] array, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            Integer min = set.ceiling(sum - k);
            if (min != null)
                max = Math.max(max, sum - min);
            set.add(sum);
        }
        return max;
    }
}
