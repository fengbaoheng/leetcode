/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
import java.util.*;


class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 排序
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // 记录每个数字对应的顺序
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int num : sortedArr) {
            if(!map.containsKey(num)){
                map.put(num, index);
                index++;
            }
        }


        // 映射结果
        int[] result = arr.clone();
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(result[i]);
        }

        return result;
    }
}
// @lc code=end

