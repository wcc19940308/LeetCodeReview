package LeetCode;

import java.util.Arrays;

public class Candy_135 {
    public int candy(int[] ratings) {
        int sum = 0;
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        // 从左往右，如果右边比左边大，那么就在左边的基础上+1
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        // 从右往左，如果左边比右边大，那么在右边基础上+1
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
