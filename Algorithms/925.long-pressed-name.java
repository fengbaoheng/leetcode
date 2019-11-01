/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();

        if (len2 < len1) {
            return false;
        }

        if (len1 == 0) {
            return len2 == len1;
        }


        // 待匹配的索引位置
        int i = 0;
        char lastChar = name.charAt(0);

        // 对typed逐个匹配name[i]
        for (char c : typed.toCharArray()) {
            if (c == name.charAt(i)) {
                lastChar = c;
                if (++i == len1) {
                    return true;
                }
            } else if (c != lastChar) {
                return false;
            }
        }

        return false;
    }
}
// @lc code=end

