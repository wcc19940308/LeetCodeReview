package LeetCode;

import java.util.*;

public class WordBreakII_140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> res = dfs(s, wordDict, map);
        return res;
    }

    public static List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> res = wordBreak(s, list);
        System.out.println(res);
    }
}
