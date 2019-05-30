package LeetCode;

/**
 * ����ÿһ��λ���ܹ��洢���ٵ�ˮ��ֻҪ�ҵ���ߺ��ұ���ߵ�������ȡ��С�ģ���ľͰԭ���ҵ������и��̵��ǿ�ľ��
 * Ȼ���øó��ȼ�ȥheight[i]��ǰindex�ĸ߶ȣ����ǵ�ǰindex�ܹ��洢�ĵ�λ�����ˮ
 * ע��������������������߶ȵļ���Ҫ����ǰ���ӵ�heightҲ������
 */
public class TrappingRainWater_42 {
    // ��������,����ÿ��λ�ã���������λ����ߺ��ұ���ߵ����ӣ�ȡ�����и�С�ģ�Ȼ���ȥheight[index]�ۼӼ���
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

    // ���������¼��ÿ����Ϊ��ʼ����ߺ��ұ���ߵ����Ӹ߶�
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

    // ˫ָ��
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
