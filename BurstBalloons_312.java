package LeetCode;

/**
 * �����������dp��Ҫ��i��j֮������÷֣��ݹ�����i��k-1 + k + k+1��j�ĵ÷֣�ע�����k�ĵ÷ֵ�ʱ��i��j�Ѿ��������ˣ����Ҫ����i-1 �� j+1
 * dp[i][j]����ը������[i, j]��ȫ�������ܹ��õ���������
 * 3��ѭ��������ÿ�������飬����ÿ������������ҽ��б���
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

    // ���i��j֮������÷�
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
                    // ��߲��ó�1
                    if (i != 0) {
                        leftValue = nums[i - 1];
                    }
                    // �ұ߲��ó�1
                    if (j != n - 1) {
                        rightValue = nums[j + 1];
                    }
                    int before = 0, after = 0;
                    // �õ���ߵĵ÷�
                    if (k != i) {
                        before = dp[i][k - 1];
                    }
                    // �õ��ұߵĵ÷�
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
