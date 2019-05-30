package LeetCode;

/**
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 * DP,dp[i][j]�����ַ���1�ĵ�iλ����ַ���2�ĵ�jλ��Ҫ�����ٲ�������
 * dp[i][j] = dp[i-1][j-1] if (i == j) ���2���ַ���ȣ���ô�Ϳ�ǰ����ַ������
 *          = 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) ��������ַ�������ȣ�Ҫô����ǰ����滻һ����Ҫô��ɾ��һ����Ҫô�ǲ���һ��
 */
public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[m][n];
    }
}
