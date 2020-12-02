/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */
class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int rows = 0;
        int length = 0;

        // 遍历字符串
        for (char ch : S.toCharArray()) {
            int width = widths[ch - 'a'];

            if (length + width <= 100) {
                length += width;
            } else {
                rows += 1;
                length = width;
            }
        }

        // 最后一行不是完整的行 因此rows+1
        return new int[] { rows + 1, length };
    }
}
