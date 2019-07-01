package LeetCode;

public class JumpGameII_45 {
    public static int jump(int[] nums) {
        int cnt = 0, left = 0, right = 0;
        int n = nums.length;
        while (right < n - 1) {
            cnt++;
            int rightMax = left + nums[left];
            for (int i = left + 1; i <= right; i++) {
                rightMax = Math.max(rightMax, i + nums[i]);
            }
            left = right;
            right = rightMax;
        }
        return cnt;
    }

    /**
     *
     * I try to change this problem to a BFS problem, where nodes in level i are all the nodes that can be reached in i-1th jump. for example. 2 3 1 1 4 , is
     * 2||
     * 3 1||
     * 1 4 ||
     * @param nums
     * @return
     */
    public static int jump_BFS(int[] nums) {
        if (nums.length <= 1) return 0;
        int curMax = 0; // to mark the last element in a level
        int level = 0, i = 0;
        while (i <= curMax) {
            int furthest = curMax; // to mark the last element in the next level
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            curMax = furthest;
        }
        return -1; // if i < curMax, i can't move forward anymore (the last element in the array can't be reached)
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));

    }
}
