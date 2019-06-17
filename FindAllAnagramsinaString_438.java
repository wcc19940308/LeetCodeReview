package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[128];
        int cnt = p.length();
        int left = 0, right = 0;
        for (Character ch : p.toCharArray()) {
            hash[ch]++;
        }
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0) cnt--;
            if (cnt == 0) res.add(left);
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) cnt++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
