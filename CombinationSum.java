package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> tmpList
            , int[] candidates, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(tmpList));
        }
        if (target < 0) return;
        for (int i = start; i <candidates.length; i++) {
            tmpList.add(candidates[i]);
            backTrack(list, tmpList, candidates, target - candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
