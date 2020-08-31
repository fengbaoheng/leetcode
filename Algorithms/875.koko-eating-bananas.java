/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int p = 1, q = getMaxSpeed(piles);
        int result = q;
        while (p <= q) {
            int speed = p + (q - p) / 2;

            if (canFinished(piles, H, speed)) {
                // 当前速度可以吃完,尝试放慢
                result = speed;
                q = speed - 1;
            } else {
                // 当前速度不能吃完,加快
                p = speed + 1;
            }
        }

        return result;
    }

    /**
     * 最大速上限
     */
    private int getMaxSpeed(int[] piles) {
        return IntStream.of(piles).max().getAsInt();
    }


    private boolean canFinished(int[] piles, int H, double speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil(pile / speed);
            if (hours > H) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

