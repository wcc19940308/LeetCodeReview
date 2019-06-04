package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses_301 {
    public  List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else if (left > 0 && s.charAt(i) == ')') left--;
            else if (left == 0 && s.charAt(i) == ')') right++;
        }
        backTrack(res, s, left, right, 0);
        return res;
    }

    public  void backTrack(List<String> list, String s, int left, int right, int start) {
        if (left == 0 && right == 0 && isValid(s)) {
            list.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' && left > 0) {
                backTrack(list, s.substring(0, i) + s.substring(i + 1, s.length()), left - 1, right, i);
            } else if (s.charAt(i) == ')' && right > 0) {
                backTrack(list, s.substring(0, i) + s.substring(i + 1, s.length()), left, right - 1, i);
            }
        }
    }

    public  boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

}
