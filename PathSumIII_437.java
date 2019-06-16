package LeetCode;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII_437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    // ��¼�Ӹ��ڵ������ÿ������֧�ϵ�·���ͣ����ƶ������ۼӣ�Ȼ�����Ƿ����ĳ��ֵΪtarget�������飩
    // preSum��¼���ǵ�ǰ·�����ܹ��ﵽ��ÿ���Ϸ�ǰ׺������Ӧ�ĸ���
    public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        // ������֧������ϣ����Ϸ��أ������Ҫ��ȥ�Ըýڵ���Ϊ�յ��·����
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = root.left = new TreeNode(5);
        TreeNode right = root.right = new TreeNode(-3);
        TreeNode lLeft = left.left = new TreeNode(3);
        TreeNode lRight = left.right = new TreeNode(2);
        TreeNode rRight = right.right = new TreeNode(11);
        TreeNode llLeft = lLeft.left = new TreeNode(3);
        TreeNode llRight = lLeft.right = new TreeNode(-2);
        TreeNode lrRight = lRight.right = new TreeNode(1);
        //System.out.println(pathSum(root, 8));
    }
}
