package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        System.out.println(subarraySum(nums, 1));
    }
}
