package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curSize = 1;
                int curNum = num + 1;
                while (set.contains(curNum)) {
                    curSize++;
                    curNum++;
                }
                max = Math.max(max, curSize);
            }
        }
        return max;
    }
}
