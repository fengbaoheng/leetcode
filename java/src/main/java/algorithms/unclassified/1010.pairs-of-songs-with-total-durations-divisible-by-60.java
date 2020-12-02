/*
 * @lc app=leetcode.cn id=1010 lang=java
 *
 * [1010] 总持续时间可被 60 整除的歌曲
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // 记录各长度歌曲的数量
        int[] count = new int[60];

        int result = 0;
        for (int t : time) {
            t %= 60;
            
            // 0, 60特殊处理
            if (t == 0) {
                result += count[0];
            } else {
                result += count[60 - t];
            }

            count[t]++;
        }

        return result;
    }
}
// @lc code=end

