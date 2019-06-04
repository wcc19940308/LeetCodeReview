package LeetCode;

public class LIS_300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                maxval = Math.max(maxval, dp[j]);
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(maxval, dp[j] + 1);
                } else {
                    dp[i] = maxval;
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(nums));
    }
}
