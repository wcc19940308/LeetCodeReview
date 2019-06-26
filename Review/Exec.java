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

    public int countSubstrings(String s) {
        char[] newChar = preProcess(s);
        int[] pArr = new int[newChar.length];
        int res = 0;
        int index = -1;
        int pR = -1;
        for (int i = 0; i < newChar.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < newChar.length && i - pArr[i] > -1) {
                if (newChar[i + pArr[i]] == newChar[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                index = i;
                pR = i + pArr[i];
            }
        }
        for (int num : pArr) {
            res += num / 2;
        }
        return res;
    }

    public char[] preProcess(String s) {
        char[] newChar = new char[2 * s.length() + 1];
        int index = 0;
        for (int i = 0; i < newChar.length; i++) {
            newChar[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        return newChar;
    }

    public static int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int i = 1;;i++) {
            if (i == min) continue;
            return i;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }
}
