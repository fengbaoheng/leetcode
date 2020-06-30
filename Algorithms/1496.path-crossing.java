/*
 * @lc app=leetcode.cn id=1496 lang=java
 *
 * [1496] 判断路径是否相交
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> visitMap = new HashMap<>();
        visitMap.put(0, new HashSet<>());
        visitMap.get(0).add(0);

        int x = 0, y = 0;
        for (char move : path.toCharArray()) {
            switch (move) {
                case 'N':
                    y += 1;
                    break;
                case 'S':
                    y -= 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }

            if (!visitMap.computeIfAbsent(x, k -> new HashSet<>()).add(y)) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

