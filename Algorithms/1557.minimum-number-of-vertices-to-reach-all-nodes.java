/*
 * @lc app=leetcode.cn id=1557 lang=java
 *
 * [1557] 可以到达所有点的最少点数目
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] toEdge = new boolean[n];

        // 剔除入度大于0的节点
        for (List<Integer> edge : edges) {
            toEdge[edge.get(1)] = true;
        }

        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (!toEdge[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
// @lc code=end

