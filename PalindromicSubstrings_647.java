package LeetCode;

public class PalindromicSubstrings_647 {

    public static int countSubstrings(String s) {
        char[] newChar = manacherString(s);
        int[] pArr = new int[newChar.length];
        int index = -1, pR = -1;
        for (int i = 0; i < newChar.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < newChar.length && i - pArr[i] > -1) {
                if (newChar[i + pArr[i]] == newChar[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
        }
        int res = 0;
        for (int num : pArr) {
            res += num / 2;
        }
        return res;
    }

    public static char[] manacherString(String s) {
        int n = s.length();
        char[] newChar = new char[2 * n + 1];
        int index = 0;
        for (int i = 0; i < newChar.length; i++) {
            newChar[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        return newChar;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
