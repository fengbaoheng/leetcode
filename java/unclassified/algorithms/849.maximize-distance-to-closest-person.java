/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;

        int[] distances = new int[size];

        // 记录前一个人的位置
        // 初始在负无穷远处
        int preSeat = -100000;
        for (int i = 0; i < size; i++) {
            int seat = seats[i];
            if (seat == 1) {
                distances[i] = 0;

                // 向前搜索
                for (int j = i - 1; j > preSeat && j >= 0; j--) {
                    int distanceToNext = i - j;
                    if (distanceToNext < distances[j]) {
                        distances[j] = distanceToNext;
                    } else {
                        break;
                    }
                }

                // 重置记录
                preSeat = i;
            } else {
                int distanceToPre = i - preSeat;
                distances[i] = distanceToPre;
            }
        }


        return IntStream.of(distances).max().getAsInt();
    }
}   
// @lc code=end

