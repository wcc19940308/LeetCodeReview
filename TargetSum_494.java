package LeetCode;

public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || (S + sum) % 2 != 0) {
            return 0;
        }
        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = dp[j - 1];
                if (j >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }
}
