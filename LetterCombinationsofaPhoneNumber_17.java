package LeetCode;

import java.util.*;

/**
 * 类似BFS的一种遍历方式，每次将数字对应的全部字符压入，然后弹出，和下一个数字对应的所有字符重组再次压入
 * 也可以使用DFS遍历所有的可能
 */
public class LetterCombinationsofaPhoneNumber_17 {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            dfs("", digits);
        }
        return list;
    }

    public void dfs(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            list.add(combination);
        } else {
            String digits = nextDigits.substring(0, 1);
            String letters = map.get(digits);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                dfs(combination + letter, nextDigits.substring(1));
            }
        }
    }


    public List<String> letterCombinations_BFS(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits.length() == 0) {
            return list;
        }
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xyz"};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int curNumber = Character.getNumericValue(toString().charAt(i));
            while (list.peek().length() == i) {
                String tmp = list.poll();
                for (char s : mapping[curNumber].toCharArray()) {
                    list.add(tmp + s);
                }
            }
        }
        return list;
    }
}
