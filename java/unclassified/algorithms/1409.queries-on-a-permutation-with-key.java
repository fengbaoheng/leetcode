/*
 * @lc app=leetcode.cn id=1409 lang=java
 *
 * [1409] 查询带键的排列
 */

// @lc code=start
import java.util.*;


class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }


        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int query = queries[i];

            int index = 0;
            final Iterator<Integer> iterator = list.iterator();
            while (true) {
                if (query == iterator.next()) {
                    iterator.remove();
                    break;
                }
                index++;
            }

            list.add(0, query);
            result[i] = index;
        }

        return result;
    }
}
// @lc code=end

