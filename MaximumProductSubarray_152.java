package LeetCode;

public class MaximumProductSubarray_152 {
    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int maxHere = nums[0];
        int minHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxHere = Math.max(maxHere * nums[i], nums[i]);
                minHere = Math.min(minHere * nums[i], nums[i]);
            } else {
                int tmp = maxHere;
                maxHere = Math.max(minHere * nums[i], nums[i]);
                minHere = Math.min(tmp * nums[i], nums[i]);
            }
            res = Math.max(maxHere, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }
}
