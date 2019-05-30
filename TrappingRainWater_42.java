package LeetCode;

/**
 * 对于每一个位置能够存储多少的水，只要找到左边和右边最高的柱子中取更小的，即木桶原则，找到二者中更短的那块木板
 * 然后用该长度减去height[i]当前index的高度，就是当前index能够存储的单位体积的水
 * 注意对于左右两边柱子最大高度的计算要将当前柱子的height也算在内
 */
public class TrappingRainWater_42 {
    // 暴力遍历,对于每个位置，都遍历该位置左边和右边最高的柱子，取二者中更小的，然后减去height[index]累加即可
    public static int trap1(int[] height) {
        int res = 0, n = height.length;
        for (int i = 1; i < n - 1; i++) {
            int left_max = 0, right_max = 0;
            for (int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            for (int j = i; j < n; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            res += Math.min(left_max, right_max) - height[i];
        }
        return res;
    }

    // 记忆数组记录以每个点为起始点左边和右边最高的柱子高度
    public static int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0, n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }

    // 双指针
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else res += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(arr));
    }
}
