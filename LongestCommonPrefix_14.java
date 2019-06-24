package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix_14 {
    // ����ɨ��
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            // һֱ�ң�ֱ���ҵ����ڵ�2���ַ�������ͬǰ׺
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // ��ֱɨ�裬һ����̵��Ǹ���������ˣ���ֱ�ӷ�����
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                // һ����̵��Ǹ������˻����в���ȵ��ˣ�����
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        // ���ִ�е��ⲽ����ʾ��strs���������ˣ�strs������̵Ĺ���ǰ׺
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs));
    }
}
