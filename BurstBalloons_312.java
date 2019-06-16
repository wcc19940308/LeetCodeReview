package LeetCode;

/**
 * 带记忆数组的dp，要求i到j之间的最大得分，递归求解出i到k-1 + k + k+1到j的得分，注意计算k的得分的时候i和j已经被扎破了，因此要计算i-1 和 j+1
 * dp[i][j]代表炸光区间[i, j]的全部气球能够得到的最大分数
 * 3重循环，遍历每个子数组，对于每个子数组从左到右进行遍历
 */
public class BurstBalloons_312 {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNum = new int[n + 2];
        newNum[0] = 1;
        newNum[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            newNum[i] = nums[i - 1];
        }
        int res = backTrack(newNum, new int[n + 2][n + 2], 1, n);
        return res;
    }

    // 求出i到j之间的最大得分
    public static int backTrack(int[] nums, int[][] memo, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] > 0) return memo[i][j];
        int res = 0;
        for (int k = i; k <= j; ++k) {
            res = Math.max(res, nums[i - 1] * nums[k] * nums[j + 1] + backTrack(nums, memo, i, k - 1) + backTrack(nums, memo, k + 1, j));
        }
        memo[i][j] = res;
        return res;
    }

    public int maxCoins_dp(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int leftValue = 1, rightValue = 1;
                    // 左边不用乘1
                    if (i != 0) {
                        leftValue = nums[i - 1];
                    }
                    // 右边不用乘1
                    if (j != n - 1) {
                        rightValue = nums[j + 1];
                    }
                    int before = 0, after = 0;
                    // 得到左边的得分
                    if (k != i) {
                        before = dp[i][k - 1];
                    }
                    // 得到右边的得分
                    if (k != j) {
                        after = dp[k + 1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + after + leftValue * nums[k] * rightValue);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
}
