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

    public static int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int res = partition(nums, lo, hi);
            if (res == target) {
                break;
            } else if (res < target) {
                lo = res + 1;
            } else {
                hi = res - 1;
            }
        }
        return nums[target];
    }

    public static int partition(int[] nums, int lo, int hi) {
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

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = m;
        while (lo <= hi) {
            int partitionX = lo + (hi - lo) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX ];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }else if (maxLeftX > minRightY) {
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        slow = reverse(slow);
        fast = dummy.next;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        Deque deque = new ArrayDeque();
        return pre;
    }



    public static int solution2(int money, int[] value, int[] hot) {
        int[] dp = new int[money + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = money; j >= 0; j--) {
                if (j >= value[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - value[i - 1]] + hot[i - 1]);
                }
            }
        }
        return dp[money];
    }

    public static int solution1(int money, int[] value, int[] hot) {
        int[][] dp = new int[value.length + 1][money + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 0; j <= money; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                if (j >= value[i-1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - value[i - 1]] + hot[i - 1]);
                }
            }
        }
        return dp[value.length][money];
    }

    public static int solution(int money, int[] value, int[] hot) {
        int[] dp = new int[money + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = money; j >= 0; j--) {
                if (j > value[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - value[i - 1]] + hot[i - 1]);
                }
            }
        }
        return dp[money];
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int res = backTrack(word1, word2, 0, 0, new int[m][n]);
        return res;
    }

    public int backTrack(String word1, String word2, int i, int j, int[][] memo) {
        // 如果某个字符串先结束了，那么直接返回另外一个字符串剩下的长度
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        if (memo[i][j] > 0) return memo[i][j];
        int res = 0;
        // 如果i和j相等，那么只需要比较后面的即可
        if (word1.charAt(i) == word2.charAt(j)) {
            return backTrack(word1, word2, i + 1, j + 1, memo);
            // 否则，需要对word1进行增加、删除或者修改
        } else {
            int insertCount = backTrack(word1, word2, i, j + 1, memo);
            int deleteCount = backTrack(word1, word2, i + 1, j, memo);
            int changeCount = backTrack(word1, word2, i + 1, j + 1, memo);
            res = 1 + Math.min(insertCount, Math.min(deleteCount, changeCount));
        }
        return memo[i][j];
    }

    public int minDistance_DP(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 自底向上，对word1进行增加、删除或者修改
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (left != 0 && s.charAt(i) == ')') {
                left--;
            } else if (left == 0 && s.charAt(i) == ')') {
                right++;
            }
        }
        dfs(s, list, left, right, 0);
        return list;
    }

    public void dfs(String s, List<String> list, int left, int right,int start) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                list.add(s);
            }
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (left > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), list, left - 1, right, i);
            }
            if (right > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), list, left, right - 1, i);
            }
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return true;
    }

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        longestThroughRoot(root);
        return max;
    }

    public int longestThroughRoot(TreeNode root) {
        if (root == null) return 0;
        int left = longestThroughRoot(root.left);
        int right = longestThroughRoot(root.right);
        int pl = 0, pr = 0;
        if (left != 0 && root.val == root.left.val) {
            pl += left;
        }
        if (right != 0 && root.val == root.right.val) {
            pr += right;
        }
        max = Math.max(max, pl + pr);
        return Math.max(pl, pr) + 1;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }



    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public  int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 重复的元素可能在区间里，也可能在区间外部（左侧）
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 这里可以通过map来表示有向图
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            // 根据equations中的式子分别求出a/b和b/a
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);

            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1.0 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>());
        }
        return res;
    }

    public double dfs(String A, String B, Map<String, Map<String, Double>> map, Set<String> set) {
        if (!map.containsKey(A) || !map.containsKey(B)) {
            return -1.0;
        }
        if (A.equals(B)) {
            return 1.0;
        }
        Map<String, Double> pair = map.get(A);
        set.add(A);
        for (String index : pair.keySet()) {
            // 这里的set主要是为了防止邻居节点的回边，重复访问节点
            if (set.contains(index)) continue;
            double res = dfs(index, B, map, set);
            if (res > 0) return pair.get(index) * res;
        }
        return -1.0;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = len + i - 1;
                for (int k = i; k <= j; k++) {
                    int leftValue = 1, rightValue = 1;
                    int before = 0, after = 0;
                    if (i != 0) {
                        leftValue = nums[i - 1];
                    }
                    if (j != n - 1) {
                        rightValue = nums[j + 1];
                    }
                    if (k != i) {
                        before = dp[]
                    }
                }
            }
        }
    }


}
