/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> map = getMap(equations, values);

        return queries.stream()
                .map(queryStr -> query(map, queryStr))
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    // 构造图网络
    private Map<String, Node> getMap(List<List<String>> equations, double[] values) {
        int n = values.length;
        Map<String, Node> map = new HashMap<>(2 * n);

        for (int i = 0; i < n; i++) {
            double value = values[i];
            List<String> equation = equations.get(i);
            Node dividendNode = map.computeIfAbsent(equation.get(0), name -> new Node());
            Node divisorNode = map.computeIfAbsent(equation.get(1), name -> new Node());

            dividendNode.neighbors.put(divisorNode, value);
            divisorNode.neighbors.put(dividendNode, 1 / value);
        }

        return map;
    }

    // 查询等式连接
    private double query(Map<String, Node> map, List<String> equation) {
        Node dividendNode = map.get(equation.get(0));
        Node divisorNode = map.get(equation.get(1));

        if (dividendNode == null || divisorNode == null) {
            return -1;
        }

        return 1 / dividendNode.query(divisorNode, 1);
    }

    private static class Node {
        private boolean searched;
        private final Map<Node, Double> neighbors = new HashMap<>();

        // 查询当前点到目标点的距离值
        public double query(Node target, double value) {
            // 是否直达
            if (neighbors.containsKey(target)) {
                return value / neighbors.get(target);
            }


            searched = true;

            // 深度优先搜索
            double result = -1;
            for (Map.Entry<Node, Double> entry : neighbors.entrySet()) {
                Node neighbor = entry.getKey();
                if (neighbor.searched) {
                    continue;
                }
                result = neighbor.query(target, value / entry.getValue());
                if (isValid(result)) {
                    break;
                }
            }

            searched = false;

            return result;
        }

        // 浮点数判断与-1相等
        private boolean isValid(double value) {
            return Math.abs(-1 - value) > 0.00001;
        }
    }
}


// @lc code=end

