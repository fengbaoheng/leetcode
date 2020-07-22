/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : A) {
            counts.merge(num, 1, Integer::sum);
        }

        ArrayList<Integer> keys = new ArrayList<>(counts.keySet());
        Collections.sort(keys);

        // 出现次数为0的最小数字
        int zero = keys.get(0);

        int result = 0;
        for (Integer cur : keys) {
            int count = counts.get(cur);

            // 恰好出现1次不需要修改
            if (count == 1) {
                continue;
            }

            // 出现多次,将多余的count-1个数，分别递增到最近的zero处
            // 每次递增都会消耗一个zero，因此还需要寻找下一个最小的zero
            for (int c = 0; c < count - 1; c++) {

                // 更新下一个zero
                zero = zero <= cur ? cur + 1 : zero + 1;
                while (counts.containsKey(zero)) {
                    zero++;
                }

                // 把当前值一直递增到zero处
                result += zero - cur;
            }
        }

        return result;
    }
}
// @lc code=end

