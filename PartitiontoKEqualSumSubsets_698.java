package LeetCode;

/**
 * ������ֳ�k�ݣ���ÿһ���ڵĺ��Ƿ����everSum��dfs��������
 * curNum��ʾ��ǰ�Ӽ��ڵ�Ԫ������
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
        // �ҵ��˾ʹ�ͷ��ʼ����
        if (curSum == target && curNum > 0) return dfs(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                // �������������
                if (dfs(nums, visited, i + 1, k, curSum + nums[i], curNum + 1, target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
