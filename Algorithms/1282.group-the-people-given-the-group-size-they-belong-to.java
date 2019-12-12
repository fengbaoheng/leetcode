/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new LinkedList<>();

        // 记录每个分组的数量与对应的人
        Map<Integer, List<Integer>> map = new HashMap<>();


        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // 将第i个人分配分组
            map.putIfAbsent(size, new LinkedList<>());
            List<Integer> people = map.get(size);
            people.add(i);

            // 分组恰好达到容量上限
            if(people.size() == size){
                results.add(people);
                map.put(size, new LinkedList<>());
            }
        }

        return results;
    }
}
// @lc code=end

