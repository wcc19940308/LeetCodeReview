package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix_14 {
    // 横向扫描
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            // 一直找，直到找到相邻的2个字符串的相同前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // 垂直扫描，一旦最短的那个搜索完毕了，就直接返回了
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                // 一旦最短的那个找完了或者有不相等的了，返回
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        // 如果执行到这步，表示对strs都遍历完了，strs就是最短的公共前缀
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs));
    }
}
