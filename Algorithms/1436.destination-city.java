/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start
import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> fromSet = new HashSet<>();
        Set<String> toSet = new HashSet<>();

        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);

            fromSet.add(from);
            toSet.add(to);
        }

        // 仅到达，没有出发
        // 差集
        toSet.removeAll(fromSet);
        
        return toSet.stream().findFirst().orElse("");
    }
}
// @lc code=end

