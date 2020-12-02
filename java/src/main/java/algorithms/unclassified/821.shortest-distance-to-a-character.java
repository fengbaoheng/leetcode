/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] shortestToChar(String S, char C) {
        // 统计C出现的索引
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < S.toCharArray().length; i++) {
            if (S.charAt(i) == C) {
                queue.addLast(i);
            }
        }

        // 在两端足够远的距离添加两个虚拟的C
        final int max = 30000;
        queue.addFirst(-max);
        queue.addLast(max);


        int[] result = new int[S.length()];
        
        // 每一个字符索引在left,right之间
        int left = queue.pollFirst();
        int right = queue.pollFirst();
        for (int i = 0; i < S.toCharArray().length; i++) {
            // 计算到左侧C和右侧C的距离 取最小
            int distance = Math.min(i - left, right - i);
            result[i] = distance;

            // 切换左右边界
            if (distance == 0) {
                left = right;
                right = queue.pollFirst();
            }
        }

        return result;
    }
}
// @lc code=end

