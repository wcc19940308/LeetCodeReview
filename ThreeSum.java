package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l1 = i + 1;
            int l2 = len - 1;
            while (l1 < l2) {
                int sum = nums[i] + nums[l1] + nums[l2];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l1], nums[l2]));
                    while (l1 < l2 && nums[l1] == nums[l1 + 1]) l1++;
                    while (l1 < l2 && nums[l2] == nums[l2 - 1]) l2--;
                    l1++;
                    l2--;
                } else if (sum < 0) {
                    l1++;
                } else {
                    l2--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }
}

