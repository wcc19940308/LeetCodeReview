package LeetCode;

/**
 * ˫ָ�룬���i��j����ȣ���ô����nums[j]����nums[i]�����j����ĩβ�����
 */
public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
