/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] arr = S.toCharArray();

        // 记录每个字符最后出现的索引位置
        Map<Character, Integer> end = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            end.put(arr[i], i);
        }

        List<Integer> result = new ArrayList<>();

        // 依次比较每个分段的最后索引位置
        // 分段的切分位置即max(分段内元素最后索引位置)
        int maxE = 0;
        for (int i = 0; i < arr.length; i++) {
            // 到达切分位置
            if (i > maxE) {
                result.add(maxE);
                maxE = i;
            }

            int e = end.get(arr[i]);

            // 出现了更大的最后索引位置
            // 需要延长分段
            if (e > maxE) {
                maxE = e;
            }
        }

        // 数组结束位置切分
        result.add(maxE);

        // 将索引位置转换为长度
        for (int i = result.size() - 1; i > 0; i--) {
            result.set(i, result.get(i) - result.get(i - 1));
        }

        result.set(0, result.get(0) + 1);


        return result;
    }
}
// @lc code=end

