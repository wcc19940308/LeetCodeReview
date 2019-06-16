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

    // 记录从根节点出发的每条单分支上的路径和（类似对数组累加，然后求是否存在某个值为target的子数组）
    // preSum记录的是当前路径下能够达到的每个合法前缀和所对应的个数
    public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        // 单条分支遍历完毕，向上返回，因此需要减去以该节点作为终点的路径和
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
