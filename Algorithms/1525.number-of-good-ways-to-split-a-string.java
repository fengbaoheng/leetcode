/*
 * @lc app=leetcode.cn id=1525 lang=java
 *
 * [1525] 字符串的好分割数目
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int numSplits(String s) {
        // 右侧不同字符数
        int rightCount = 0;
        int[] lastIndex = new int[26];

        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (lastIndex[ch] == -1) {
                rightCount++;
            }

            lastIndex[ch] = i;
        }

        // 左侧不同字符数，初始为0，逐渐向右移动
        int leftCount = 0;
        boolean[] isVisited = new boolean[26];

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int ch = s.charAt(i) - 'a';

            // 更新左侧字符数
            if (!isVisited[ch]) {
                leftCount++;
                isVisited[ch] = true;
            }

            // 更新右侧字符数
            if (lastIndex[ch] == i) {
                rightCount--;
            }

            if (leftCount == rightCount) {
                result++;
            }
        }

        return result;

    }
}
// @lc code=end

