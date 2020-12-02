/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */

// @lc code=start
class Solution {
    private static final int MAX = 9999;

    public int videoStitching(int[][] clips, int T) {
        if (T == 0) {
            return 0;
        }

        // 记录最长可剪辑到的长度
        int[] dp = new int[T + 1];
        for (int i = 0; i <= T; i++) {
            dp[i] = i;
        }

        for (int[] clip : clips) {
            int from = clip[0];
            int to = clip[1];
            // T可能很短
            if (from <= T) {
                dp[from] = Math.max(dp[from], to);
            }
        }


        // 剪辑次数
        int count = 0;
        // 起始位置
        int start = -1;
        // 结束位置
        int end = 0;

        while (start != end) {
            count++;

            // 最大结束位置, 1次尽可能剪更长
            int maxEnd = end;

            for (int i = start + 1; i <= end; i++) {
                maxEnd = Math.max(maxEnd, dp[i]);
            }
            
            // 找到结果
            if (maxEnd >= T) {
                return count;
            }

            start = end;
            end = maxEnd;
        }


        return -1;
    }
}
// @lc code=end

