package LeetCode;

import java.util.TreeSet;

/**
 * 求不大于k的最大子数组
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83599/Accepted-C%2B%2B-codes-with-explanation-and-references
 * 通过2D的kadane，再加上TreeSet进行二分搜索，ceiling用二分查找搜索下界
 */
public class MaxSumofRectangleNoLargerThanK_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        for (int i = 0; i < n; i++) {
            int[] each = new int[m];
            for (int j = i; j >= 0; j--) {
                for (int r = 0; i < m; r++) {
                    each[r] += matrix[r][j];
                }
                result = Math.max(result, getCloseToK(each, k));
            }
        }
        return result;
    }

    public int getCloseToK(int[] arr, int k) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            Integer ceiling = treeSet.ceiling(sum - k);
            if (ceiling != null) {
                result = Math.max(result, ceiling);
            }
            treeSet.add(sum);
        }
        return result;
    }
}
