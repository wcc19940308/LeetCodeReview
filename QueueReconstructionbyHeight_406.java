package LeetCode;

import java.util.*;

public class QueueReconstructionbyHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] mid : people) {
            res.add(mid[1], mid);
        }
        return res.toArray(new int[0][]);
    }
}
