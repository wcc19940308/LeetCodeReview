package LeetCode;

import java.util.*;

// 中序和层次遍历构造二叉树
public class ConstructTreeByInAndLevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode constructTree(List<Integer> levelOrder, List<Integer> inOrder, int inStart, int inEnd) {
        if (levelOrder.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder.get(0));
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.get(i) == levelOrder.get(0)) {
                index = i;
                break;
            }
        }
        List<Integer> leftLayer = new ArrayList<>();
        List<Integer> rightLayer = new ArrayList<>();
        for (int i = 1; i < levelOrder.size(); i++) {
            boolean isLeft = false;
            for (int j = inStart; j < index; j++) {
                if (levelOrder.get(i) == inOrder.get(j)) {
                    isLeft = true;
                    break;
                }
            }
            if (isLeft) {
                leftLayer.add(levelOrder.get(i));
            } else {
                rightLayer.add(levelOrder.get(i));
            }
        }
        root.left = constructTree(leftLayer, inOrder, inStart, index - 1);
        root.right = constructTree(rightLayer, inOrder, index + 1, inEnd);
        return root;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = backTrack(s, wordDict, new HashMap<>());
        return res;
    }

    public List<String> backTrack(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> list = new LinkedList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> resList = backTrack(s.substring(word.length()), wordDict, map);
                for (String res : resList) {
                    if (!res.equals("")) {
                        list.add(word + " " + res);
                    } else {
                        list.add(word);
                    }
                }
            }
        }
        map.put(s, list);
        return list;
    }

}
