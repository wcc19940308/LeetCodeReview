package LeetCode;

import java.util.Stack;

public class DecodeString_394 {
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int curNum = 0;
        StringBuilder sb = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                curNum = curNum * 10 + ch - '0';
            } else if (ch == '[') {
                numStack.push(curNum);
                strStack.push(sb);
                sb = new StringBuilder();
                curNum = 0;
            } else if (ch == ']') {
                StringBuilder tmp = sb;
                Integer popNum = numStack.pop();
                sb = strStack.pop();
                while (popNum-- > 0) {
                    sb.append(tmp);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
