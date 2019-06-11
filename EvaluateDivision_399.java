package LeetCode;

import java.util.*;

/**
 * 构造有向图，通过判断2个节点是否连通，如果不连通则返回-1，否则返回相应边上的值
 * 通过Map<String, Map<String, Double>>来记录每个节点到相应节点的值来模拟图
 * 通过中间节点找到一个路径，然后将路径全都相乘即可
 * https://www.youtube.com/watch?v=UwpvInpgFmo
 */
public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1.0 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>());
        }
        return res;
    }

    public double dfs(String A, String B, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!map.containsKey(A) || !map.containsKey(B)) return -1.0;
        if (A.equals(B)) return 1.0;
        visited.add(A);
        Map<String, Double> pair = map.get(A);
        for (String key : pair.keySet()) {
            // 为了防止对邻居节点的重复访问,即防止回边的访问
            if (visited.contains(key)) continue;
            double res = dfs(key, B, map, visited);
            if (res > 0) return res * map.get(A).get(key);
        }
        return -1.0;
    }


}
