package LeetCode;

import java.util.Arrays;

public class Candy_135 {
    public int candy(int[] ratings) {
        int sum = 0;
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        // �������ң�����ұ߱���ߴ���ô������ߵĻ�����+1
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        // �������������߱��ұߴ���ô���ұ߻�����+1
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
