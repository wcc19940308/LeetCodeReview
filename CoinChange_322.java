package LeetCode;

import java.util.Arrays;

public class CoinChange_322 {
    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        int res = backTrack(coins, memo, amount);
        return res;
    }

    public static int backTrack(int[] coins, int[] memo, int target) {
        if (target < 0) return -1;
        if (target == 0) return 0;
        if (memo[target] != 0) return memo[target];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = backTrack(coins, memo, target - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[target] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[target];
    }

    public static int coinChange_dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(coinChange_dp(nums, 3));
    }
}
