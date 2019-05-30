package LeetCode;

import java.util.Arrays;

public class HouseRobber_198 {
    public static  int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return recursive(nums, memo,nums.length - 1);
    }

    public static int recursive(int[] nums, int[] memo, int curNum) {
        if (curNum < 0) return 0;
        if (memo[curNum] != -1) {
            return memo[curNum];
        }
        int res = Math.max(recursive(nums, memo, curNum - 2)
                + nums[curNum], recursive(nums, memo, curNum - 1));
        memo[curNum] = res;
        return res;
    }

    public int dpRob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
