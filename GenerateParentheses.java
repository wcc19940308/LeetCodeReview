package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursive(list, sb, n, 0, 0);
        return list;
    }

    public static void recursive(List<String> list, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == 2 * n) list.add(sb.toString());
        if (left < n) {
            sb.append("(");
            left++;
            recursive(list, sb, n, left, right);
            left--;
            sb.setLength(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            right++;
            recursive(list, sb, n, left, right);
            right--;
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
