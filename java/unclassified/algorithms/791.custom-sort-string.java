/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
    // 统计字符次数按给定顺序打印即可
    public String customSortString(String S, String T) {
        int[] count = new int[26];

        // 统计所有字符出现的次数
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        // 依次遍历给定顺序S, 拼接
        for (char c : S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                stringBuilder.append(c);
            }

            count[c - 'a'] = 0;
        }

        // 拼接未出现在S中的字符
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            for (int j = 0; j < count[i]; j++) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
// @lc code=end

