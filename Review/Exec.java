package LeetCode.Review;

public class Exec {
    public static int findKthLargest(int[] nums, int k) {
        int index = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
        return nums[index];
    }

    public static int quickSelect(int[] nums, int lo, int hi, int k) {
        int random = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, random, hi);
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) {
            return i;
        } else if (m < k) {
            return quickSelect(nums, i + 1, hi, k - m);
        } else {
            return quickSelect(nums, lo, i - 1, k);
        }

    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
