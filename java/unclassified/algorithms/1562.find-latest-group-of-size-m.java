/*
 * @lc app=leetcode.cn id=1562 lang=java
 *
 * [1562] 查找大小为 M 的最新分组
 */

// @lc code=start
import java.util.Map;
import java.util.TreeMap;

class Solution {
    /**
     * 逆向思维,从全1字符串逐渐变为全0字符串
     */
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;

        // 全1的组,只有到最后一步才符合
        if (m == n) {
            return n;
        }

        TreeMap<Integer, Integer> gap = new TreeMap<>();

        // 最初只有一个组
        gap.put(1, n);

        for (int i = arr.length - 1; i >= 0; i--) {
            int cut = arr[i];

            if (gap.containsKey(cut)) {
                int end = gap.remove(cut);
                if (end != cut) {
                    // 切出的新组
                    gap.put(cut + 1, end);
                    if (end - cut == m) {
                        return i;
                    }
                }
            } else {
                // 中间切断
                Map.Entry<Integer, Integer> pre = gap.floorEntry(cut);
                int preKey = pre.getKey();
                int preValue = pre.getValue();

                gap.put(preKey, cut - 1);
                if (cut - preKey == m) {
                    return i;
                }

                if (preValue != cut) {
                    gap.put(cut + 1, preValue);
                    if (preValue - cut == m) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end

