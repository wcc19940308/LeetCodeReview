package LeetCode;

import java.util.Arrays;

public class Manacher {
    // ͳһ��ż�����Ӵ�
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
        // �������ĺ����һ��ı߽�
        int index = -1, pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < newChar.length; i++) {
            // �ȵõ�λ��i�Ļ��İ뾶������
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            // Ȼ��ͨ��������������ʽ��i�������������
            while (i + pArr[i] < newChar.length && i - pArr[i] > -1) {
                if (newChar[i + pArr[i]] == newChar[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // ��ʱ���»������ĺ����һ��ı߽�
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

}
