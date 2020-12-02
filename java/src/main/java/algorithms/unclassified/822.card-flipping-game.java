/*
 * @lc app=leetcode.cn id=822 lang=java
 *
 * [822] 翻转卡片游戏
 */

// @lc code=start
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        int min = Integer.MAX_VALUE;

        Set<Integer> repeated = new HashSet<>();
        Set<Integer> total = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int front = fronts[i];
            int back = backs[i];

            if (front == back) {
                repeated.add(back);
            } else {
                total.add(front);
                total.add(back);
            }
        }

        total.removeAll(repeated);
        return total.stream().min(Integer::compareTo).orElse(0);
    }
}
// @lc code=end

