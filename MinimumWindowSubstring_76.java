package LeetCode;


/**
 * 关于滑动窗口的模板
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int counter = t.length();
        int size = Integer.MAX_VALUE;
        int head = 0;
        int[] hash = new int[128];
        for (char ch : t.toCharArray()) hash[ch]++;
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0) counter--;
            while (counter == 0) {
                if (size > right - left) {
                    size = right - left;
                    head = left;
                }
                if (hash[s.charAt(left++)]++ >= 0) counter++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(head, head + size);
    }
}
