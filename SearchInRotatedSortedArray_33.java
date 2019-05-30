package LeetCode;

/**
 *
 */
public class SearchInRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    // 因为是不重复的，所以只能是nums[mid] > target || target > nums[hi]，下边同理，因此不需要hi = mid(因为是左闭右闭的区间)
                    hi = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(search(arr, 8));
    }
}
