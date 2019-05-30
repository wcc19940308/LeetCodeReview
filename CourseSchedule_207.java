package LeetCode;

import java.util.*;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
            indegree[pre[1]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            for (Integer index : graph[top]) {
                indegree[index]--;
                if (indegree[index] == 0) queue.offer(index);
            }
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) return false;
        }
        return true;
    }
}
