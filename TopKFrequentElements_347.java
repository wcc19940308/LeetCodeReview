package LeetCode;

import java.util.*;

public class TopKFrequentElements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Integer index : map.keySet()) {
            priorityQueue.offer(index);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
