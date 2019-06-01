package LeetCode;

import java.util.Arrays;

/**
 * ����ƽ������DP��⣬ÿ������������1������ƽ������1����ͨ�����
 */
public class PerfectSquares_279 {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        int min = Integer.MAX_VALUE;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], (dp[i - j * j] + 1));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
