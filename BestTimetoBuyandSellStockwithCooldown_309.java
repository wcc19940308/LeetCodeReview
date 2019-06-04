package LeetCode;

/**
 * 2��dp���飬�ֱ��������������ȴ��������ȴ���ܵõ����������
 */
public class BestTimetoBuyandSellStockwithCooldown_309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] buy = new int[n + 1];
        int[] sell = new int[n + 1];
        buy[1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] + prices[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 2] + prices[i - 1]);
        }
        return sell[n];
    }
}
