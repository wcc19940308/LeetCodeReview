package LeetCode.Review;

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

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
