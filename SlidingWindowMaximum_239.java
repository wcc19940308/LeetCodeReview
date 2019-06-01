package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null || k > nums.length) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
