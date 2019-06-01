package LeetCode;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, left++, i);
            }
        }
    }

    public void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }
}
