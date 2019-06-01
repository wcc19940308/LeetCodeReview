package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree_297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "#_";
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList<>(Arrays.asList(data.split("_"))));

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(Queue<String> queue) {
        String top = queue.poll();
        if (top.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(top));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(serialize(root).toString());
    }
}
