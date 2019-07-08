package LeetCode;

/**
 * 将数组分成k份，看每一分内的和是否等于everSum，dfs进行搜索
 * curNum表示当前子集内的元素数量
 */
public class PartitiontoKEqualSumSubsets_698 {
    public  boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (k <= 0 || sum % k != 0) return false;
        int everySum = sum / k;
        boolean[] visited = new boolean[n];
        return dfs(nums, visited, 0, k, 0, 0, everySum);
    }

    public  boolean dfs(int[] nums, boolean[] visited, int startIndex, int k, int curSum, int curNum, int target) {
        if (k == 1) return true;
        // 找到了就从头开始搜索
        if (curSum == target && curNum > 0) return dfs(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                // 继续向后面搜索
                if (dfs(nums, visited, i + 1, k, curSum + nums[i], curNum + 1, target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
