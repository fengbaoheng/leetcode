/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        
        // 令w从sqrt(area)~1,依次判断
        int W = (int) Math.floor(Math.sqrt(area));

        if (area % W == 0) {
            int L = area / W;
            return new int[] { L, W };
        }

        for (int w = W; w > 0; w--) {
            if (area % w == 0) {
                int l = area / w;
                return new int[] { l, w };
            }
        }

        return new int[] { area, 1 };
    }
}
// @lc code=end
