/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int N) {
        String bin = Integer.toString(N, 2);

        int last = 33;
        int max = 0;
        for (int i = 0; i < bin.toCharArray().length; i++) {
            if (bin.charAt(i) != '1') {
                continue;
            }

            // 当出现第一个1时
            // max = 0, i-last = i -33 < 0, 因此max依然为0
            // 但last = i
            max = Math.max(max, i - last);
            last = i;
        }

        return max;
    }
}
// @lc code=end

