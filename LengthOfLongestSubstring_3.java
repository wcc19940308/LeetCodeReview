package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 当出现重复的字符时，重新计算max
 */
class LengthOfLongestSubstring_03 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start)
                    start = map.get(c) + 1;
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i);
        }
        return max;
    }
}
