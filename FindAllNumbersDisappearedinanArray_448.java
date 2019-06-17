package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]) - 1;
            if (nums[value] > 0) {
                nums[value] = -nums[value];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
