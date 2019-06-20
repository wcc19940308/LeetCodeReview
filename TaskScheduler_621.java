package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        int k = 0, p = 0;
        for (Character task : tasks) {
            hash[task - 'A']++;
        }
        Arrays.sort(hash);
        k = hash[25];
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == k) {
                p++;
            }
        }
        return Math.max(tasks.length, (k - 1) * (n + 1) + p);
    }

}
