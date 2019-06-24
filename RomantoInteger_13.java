package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger_13 {

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int n = s.length();
        int i = 0, j = 1;
        for (; j < n; i++, j++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(j))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        res += map.get(s.charAt(i));
        return res;
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }
}
