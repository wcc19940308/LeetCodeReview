package LeetCode;

public class StringToInteger_8 {
    public static int myAtoi(String str) {
        int index = 0, sign = 1, res = 0;
        int n = str.length();
        if (n == 0) return 0;
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) return 0;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < n) {
            int dight = str.charAt(index) - '0';
            if (dight < 0 || dight > 9) break;
            if (res > (Integer.MAX_VALUE - dight) / 10) {
                // 这里只需要判断max就够了，因为这里用的是大于号，所以当res * 10 + digit > Integer.MAX_VALUE的时候，
                // 本身就已经计算上了Integer.MIN_VALUE的绝对值了，而如果res * 10 + digit = Integer.MAX_VALUE有意境通过res = res * 10 + dight
                // 将res编程了Integer.MAX_VALUE
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + dight;
            index++;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(myAtoi(s));
    }
}
