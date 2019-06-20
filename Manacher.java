package LeetCode;

import java.util.Arrays;

public class Manacher {
    // 统一奇偶回文子串
    public char[] manacherString(String s) {
        int n = s.length();
        char[] newChar = new char[2 * n + 1];
        int index = 0;
        for (int i = 0; i < newChar.length; i++) {
            newChar[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        return newChar;
    }

    public  int maxLcpsLength(String s) {
        char[] newChar = manacherString(s);
        int[] pArr = new int[newChar.length];
        // 回文中心和最右回文边界
        int index = -1, pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < newChar.length; i++) {
            // 先得到位置i的回文半径的下限
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            // 然后通过向两边扩的形式看i最多能扩到哪里
            while (i + pArr[i] < newChar.length && i - pArr[i] > -1) {
                if (newChar[i + pArr[i]] == newChar[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 及时更新回文中心和最右回文边界
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

}
