/*
 * @lc app=leetcode.cn id=1387 lang=java
 *
 * [1387] 将整数按权重排序
 */

// @lc code=start
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private static final Map<Integer, Integer> power = new HashMap<>(1000);

    public int getKth(int lo, int hi, int k) {
        return IntStream.rangeClosed(lo, hi)
                .boxed()
                .sorted((o1, o2) -> {
                    int cmp = getPower(o1) - getPower(o2);
                    return cmp != 0 ? cmp : o1 - o2;
                })
                .skip(k - 1)
                .findFirst().orElse(0);
    }

    private static int getPower(int x) {
        if (x == 1) {
            return 0;
        } else if (power.containsKey(x)) {
            return power.get(x);
        }

        int p = x % 2 == 0 ? getPower(x / 2) : getPower(x + x + x + 1);
        p += 1;

        power.put(x, p);
        return p;
    }
}
// @lc code=end

