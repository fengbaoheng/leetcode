/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, int[]> map = new HashMap<>(Math.max(list1.length, list2.length));

        // 单词第1次出现的索引
        for (int i = 0; i < list1.length; i++) {
            String word = list1[i];
            map.put(word, new int[]{i, 10000});
        }

        // 单词第2次出现的索引
        for (int i = 0; i < list2.length; i++) {
            String word = list2[i];
            if (map.containsKey(word)) {
                map.get(word)[1] = i;
            }
        }

        int minSum = Integer.MAX_VALUE;
        List<String> results = new LinkedList<>();
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            int[] values = entry.getValue();
            int sum = values[0] + values[1];
            if (sum > minSum) {
                continue;
            }

            if (sum < minSum) {
                minSum = sum;
                results.clear();
            }

            results.add(entry.getKey());
        }

        return results.toArray(new String[0]);
    }
}
// @lc code=end

