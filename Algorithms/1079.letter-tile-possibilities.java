/*
 * @lc app=leetcode.cn id=1079 lang=java
 *
 * [1079] 活字印刷
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        // 统计各字母出现的次数
        int[] counter = new int[26];
        for (char c : tiles.toCharArray()) {
            counter[c - 'A']++;
        }

        // 根据次数统计, 递归统计各种单词可能
        return numTilePossibilities(counter);
    }

    private int numTilePossibilities(int[] counter) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                // 创建新的子数组递归统计
                int[] subCounter = Arrays.copyOf(counter, 26);
                subCounter[i]--;
                count += 1 + numTilePossibilities(subCounter);
            }
        }

        return count;
    }
}
// @lc code=end

