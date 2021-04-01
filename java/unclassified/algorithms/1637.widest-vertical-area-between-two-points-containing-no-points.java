/*
 * @lc app=leetcode.cn id=1637 lang=java
 *
 * [1637] 两点之间不包含任何点的最宽垂直面积
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        int[] arr = Arrays.stream(points)
                .mapToInt(point -> point[0]) // 取x坐标
                .distinct() // 去重
                .sorted() // 排序
                .toArray();

        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            max = Math.max(max, diff);
        }
        return max;
    }
}
// @lc code=end

