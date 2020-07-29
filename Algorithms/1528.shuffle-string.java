/*
 * @lc app=leetcode.cn id=1528 lang=java
 *
 * [1528] 重新排列字符串
 */

// @lc code=start
class Solution {
    public String restoreString(String s, int[] indices) {
        int[] indexes = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            indexes[index] = i;
        }

        StringBuilder builder = new StringBuilder();
        for (int index : indexes) {
            builder.append(s.charAt(index));
        }

        return builder.toString();
    }
}
// @lc code=end

