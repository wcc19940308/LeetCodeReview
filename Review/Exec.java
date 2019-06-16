package LeetCode.Review;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class Exec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] midArr = new int[m];
            for (int j = i; j < n; j++) {
                // midArr[j] = matrix[i][j];
                for (int len = 0; len < m; len++) {
                    midArr[len] += matrix[j][len];
                }
                max = Math.max(max, findMax(midArr, k));
            }
        }
        return max;
    }

    public int findMax(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                res = Math.max(res, sum - ceiling);
            }
        }
        return res;
    }

    public static String minWindow(String s, String t) {
        int[] hash = new int[128];
        int left = 0, right = 0;
        int start = 0, end = 0, len = Integer.MAX_VALUE;
        int cnt = t.length();
        for (Character ch : t.toCharArray()) {
            hash[ch]++;
        }
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0) cnt--;
            while (cnt == 0) {
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
                if (hash[s.charAt(left++)]++ >=0) cnt++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int res = partition(nums, lo, hi);
            if (res == target) {
                return nums[res];
            } else if (res < target) {
                lo = res + 1;
            } else {
                hi = res - 1;
            }
        }
        return 0;
    }

    public int partition(int[] nums, int lo, int hi) {
        int random = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, random, hi);
        int pivot = nums[hi];
        while (lo < hi) {
            while (lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
            while (lo < hi && nums[hi] > pivot) hi--;
            nums[lo] = nums[hi];
        }
        nums[lo] = pivot;
        return lo;
    }

    public void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }


    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
                // 注意只有2个元素的时候会出现相等的情况，如果不加等于判断，会死循环
            } else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) {
                if (nums[hi] >= target && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    TreeNode pre = null;
    TreeNode res = null;
    public TreeNode Convert(TreeNode root) {
        convert(root);
        return res;
    }

    public void convert(TreeNode root) {
        if (root == null) return;
        Convert(root.left);
        root.left = pre;
        if (pre == null) res = root;
        if (pre != null) pre.right = root;
        pre = root;
        Convert(root.right);
    }

    public boolean VerifySquenceOfBST(int[] sequence,int lo, int hi) {
        if (lo >= hi) return true;
        int i = lo;
        for (; i < hi; i++) {
            if (sequence[i] > sequence[hi]) break;
        }
        for (int j = i; j < hi; j++) {
            if (sequence[j] < sequence[hi]) return false;
        }
        return VerifySquenceOfBST(sequence, lo, i - 1) && VerifySquenceOfBST(sequence, lo, hi - 1);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
