package LeetCode;

import java.util.Stack;

public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        if (m ==0 || n == 0) return 0;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            max = Math.max(max, getMaxArea(height));
        }
        return max;
    }

    public int getMaxArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int index = 0;
        int max = 0;
        while (index < n) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[index]) {
                int top = stack.pop();
                int cur = stack.isEmpty() ? index : index - stack.peek() - 1;
                int area = cur * height[top];
                max = Math.max(max, area);
            }
            stack.push(index++);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int cur = stack.isEmpty() ? n : n - stack.peek() - 1;
            int area = cur * height[top];
            max = Math.max(max, area);
        }
        return max;
    }

}
