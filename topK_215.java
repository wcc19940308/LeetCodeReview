package LeetCode;

/**
 * topK：
 * 1.堆排序，维护k大小的小顶堆
 * 2.快速选择，原地快速选择，平均时间复杂度O（n）
 */
public class topK_215 {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        int target = nums.length - k;
        while (lo <= hi) {
            int pivotIndex = partition(nums, lo, hi);
            if (pivotIndex == target) break;
            else if (pivotIndex < target) {
                lo = pivotIndex + 1;
            } else {
                hi = pivotIndex - 1;
            }
        }
        return nums[target];
    }

    public int partition(int[] nums, int lo, int hi) {
        int random = lo + (int) Math.random() * (hi - lo + 1);
        swap(nums, random, lo);
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && pivot <= nums[hi]) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    public  void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
